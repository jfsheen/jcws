package cc.aisc.core.config.cache.support;

import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.*;

/**
 * Created by sjf on 16-4-30.
 */

public class RedisCache implements Cache {

    private RedisTemplate<String, Object> redisTemplate;
    private String name;

    public RedisTemplate<String, Object> getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return this.name;
    }

    @Override
    public Object getNativeCache() {
        // TODO Auto-generated method stub
        return this.redisTemplate;
    }

    @Override
    public ValueWrapper get(Object key) {
        // TODO Auto-generated method stub
        final String keyf = (String) key;
        Object object = null;
        object = redisTemplate.execute((RedisConnection connection) -> {

            byte[] key1 = keyf.getBytes();
            byte[] value = connection.get(key1);
            if (value == null) {
                return null;
            }
            return toObject(value);

        });
        return (object != null ? new SimpleValueWrapper(object) : null);
    }

    @Override
    public <T> T get(Object o, Class<T> aClass) {
        return null;
    }

    @Override
    public void put(Object key, Object value) {
        // TODO Auto-generated method stub
        final String keyf = (String) key;
        final Object valuef = value;
        final long liveTime = 86400;

        redisTemplate.execute((RedisConnection connection) -> {
            byte[] keyb = keyf.getBytes();
            byte[] valueb = toByteArray(valuef);
            connection.set(keyb, valueb);
            connection.expire(keyb, liveTime);
            return 1L;
        });
    }

    @Override
    public ValueWrapper putIfAbsent(Object o, Object o1) {
        return null;
    }

    /**
     * 描述 : <Object转byte[]>. <br>
     * <p>
     * <使用方法说明>
     * </p>
     *
     * @param obj
     * @return
     */
    private byte[] toByteArray(Object obj) {
        byte[] bytes = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            oos.flush();
            bytes = bos.toByteArray();
            oos.close();
            bos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return bytes;
    }

    /**
     * 描述 : <byte[]转Object>. <br>
     * <p>
     * <使用方法说明>
     * </p>
     *
     * @param bytes
     * @return
     */
    private Object toObject(byte[] bytes) {
        Object obj = null;
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bis);
            obj = ois.readObject();
            ois.close();
            bis.close();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return obj;
    }

    @Override
    public void evict(Object key) {
        // TODO Auto-generated method stub
        final String keyf = (String) key;
        redisTemplate.execute((RedisConnection connection) -> {
            return connection.del(keyf.getBytes());
        });
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        redisTemplate.execute((RedisConnection connection) -> {
            connection.flushDb();
            return "ok";
        });
    }
}

package cc.aisc.core.commons.utils;

import java.util.Random;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by sjf on 15-11-14.
 */
public abstract class RandomUtils {

    @SuppressWarnings("unused")
    private final static Logger LOGGER = LoggerFactory.getLogger(RandomUtils.class);

    private static final Random random = new Random();

    // 定义验证码字符.去除了O、I、l、、等容易混淆的字母
    public static final char authCode[] = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'G', 'K', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y',
            'a', 'c', 'd', 'e', 'f', 'g', 'h', 'k', 'm', 'n', 'p', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y',
            '3', '4', '5', '7', '8' };

    public static final int length = authCode.length;

    /**
     * 生成验证码
     * @return
     */
    public static char getAuthCodeChar() {
        return authCode[number(0, length)];
    }

    /**
     * 生成验证码
     * @return
     */
    public static String getAuthCode(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(authCode[number(0, length)]);
        }
        return sb.toString();
    }

    public static String getRandomString(int length){
        String str="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for(int i = 0 ; i < length; ++i){
            int number = random.nextInt(36);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 获取UUID by jdk
     *
     * @return
     */
    public static String getUuid(boolean is32bit){
        String uuid = UUID.randomUUID().toString();
        if(is32bit){
            return uuid.toString().replace("-", "");
        }
        return uuid;
    }

    /**
     * 产生两个数之间的随机数
     * @param min 小数
     * @param max 比min大的数
     * @return int 随机数字
     */
    public static int number(int min, int max) {
        return min + random.nextInt(max - min);
    }

    /**
     * 产生0--number的随机数,不包括num
     * @param number   数字
     * @return int 随机数字
     */
    public static int number(int number) {
        return random.nextInt(number);
    }

    /**
     * 生成RGB随机数
     * @return
     */
    public static int[] getRandomRgb() {
        int[] rgb = new int[3];
        for (int i = 0; i < 3; i++) {
            rgb[i] = random.nextInt(255);
        }
        return rgb;
    }
}

package cc.aisc.core.config.db.support.annotation;

import java.lang.annotation.*;

/**
 * Created by sjf on 16-3-21.
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {
    String value() default "default";
}

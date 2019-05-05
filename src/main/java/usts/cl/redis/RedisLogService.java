package usts.cl.redis;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface RedisLogService {
    enum CACHE_OPERATION {
        FIND, // 查询缓存操作
        UPDATE, // 需要执行修改缓存的操作
        INSERT, // 需要执行新增缓存的操作
        DELETE // 需要执行新增缓存的操作
    }

    /**
     * 存储的分组
     */
    String[] group() default {};

    /**
     * 当前缓存操作类型
     */
    CACHE_OPERATION cacheOperation() default CACHE_OPERATION.FIND;

    /**
     * 存储的Key 默认加入类名跟方法名
     */
    String key() default "";

    /**
     * 是否使用缓存
     */
    boolean use() default true;

    /**
     * 超时时间
     */
    int expire() default 0;

}

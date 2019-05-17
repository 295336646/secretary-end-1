package usts.cl.redis;

import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import usts.cl.bean.User;
import usts.cl.service.GroupService;

import java.lang.reflect.Method;
import java.util.Collections;

@Aspect
@Component
public class RedisInterceptor {
    @Autowired
    GroupService groupService;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Around("execution(* usts.cl.service..*(..))&&@annotation(redisLogService)")
    public Object execute(ProceedingJoinPoint proceedingJoinPoint, RedisLogService redisLogService) throws Throwable {
        Object result;
        Method method = getMethod(proceedingJoinPoint);
        // 判断是否使用缓存
        boolean useRedis = redisLogService.use();
        if (useRedis) {
            // 判断当前操作
            switch (redisLogService.cacheOperation()) {
                case FIND:
                    result = executeFind(redisLogService, proceedingJoinPoint, method);
//                    proceedingJoinPoint.proceed();
                    break;
                case UPDATE:
                    result = executeUpdate(redisLogService, proceedingJoinPoint, method);
                    break;
                case INSERT:
                    result = "";
                    break;
                case DELETE:
                    result = "";
                    break;
                default:
                    result = proceedingJoinPoint.proceed();
                    break;
            }
        } else {
            result = proceedingJoinPoint.proceed();
        }
        return result;
    }

    private Object executeUpdate(RedisLogService redisLogService, ProceedingJoinPoint proceedingJoinPoint, Method method) throws Throwable {
        Object result = true;
        // 获取key的后缀的参数名
        String key = redisLogService.key();
        if (StringUtils.isNotBlank(key)) {
            redisTemplate.delete(key);
            result = proceedingJoinPoint.proceed();
        }
        return result;
    }

    private Object executeFind(RedisLogService redisLogService, ProceedingJoinPoint proceedingJoinPoint, Method method) throws Throwable {
        Object result = null;
        Object[] args = proceedingJoinPoint.getArgs();
        // 获取key的后缀的参数名
        String key = redisLogService.key();
        if (key.equals("group")) {
            BoundHashOperations<String, String, Object> boundHashOperations = redisTemplate.boundHashOps(key);
            if (args.length != 0) {
                if (boundHashOperations.hasKey(String.valueOf(args[0]))) {
                    result = boundHashOperations.get(String.valueOf(args[0]));
                    return result;
                } else {
                    result = proceedingJoinPoint.proceed();
                }
            } else {
                if (boundHashOperations.hasKey(method.getName())) {
                    result = boundHashOperations.get(method.getName());
                    return result;
                } else {
                    result = proceedingJoinPoint.proceed();
                }
            }
        }
        return result;
    }

    /**
     * @param joinPoint
     * @return
     * @Title: getMethod
     * @Description: 获取被拦截方法对象
     */
    protected Method getMethod(JoinPoint joinPoint) {

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        Method method = methodSignature.getMethod();

        return method;
    }

}

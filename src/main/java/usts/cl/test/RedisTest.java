package usts.cl.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.hash.HashMapper;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import usts.cl.bean.User;
import usts.cl.service.GroupService;
import usts.cl.service.UserService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@Slf4j
public class RedisTest {
    @Autowired
    GroupService groupService;
    @Autowired
    UserService userService;
    // inject the actual template
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Resource(name = "redisTemplate")
    private HashOperations<String, String, Object> hashOps;
    private Logger logger = Logger.getLogger(String.valueOf(RedisTest.class));

    @Test
    public void test() throws Exception {
        long startTime = System.currentTimeMillis();   //获取开始时间
//        System.out.println(userService.logOut("30008"));
//        System.out.println(groupService.showGroup(1));
//        DefaultRedisScript<Boolean> redisScript = new DefaultRedisScript<Boolean>();
//        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("/delGroup.lua")));
//        redisScript.setResultType(Boolean.class);
//        System.out.println(redisTemplate.execute(redisScript, Collections.singletonList("key"), "2", "1"));
//        String boundKey = "key1";
//        BoundValueOperations<String,String> ops = redisTemplate.boundValueOps(boundKey);//绑定key
//        ops.set("hellos");//添加数据，相当于redis命令:set key1 hellos,只是在这里不需要显式使用key了
//        System.out.println(ops.get());
//        redisTemplate.opsForHash().put("login", "1", groupService.getGroup());
//        groupService.getGroup();
//        redisTemplate.opsForHash().get("login", "1");
//        System.out.println(redisCache.getObject(user.getUid()));

//        System.out.println(groupService.getGroup());
//        System.out.println(groupService.getLeader());
//        System.out.println(groupService.dividedGroup("30008",3));
        long endTime = System.currentTimeMillis();   //获取开始时间
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

}

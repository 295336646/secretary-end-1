package usts.cl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import usts.cl.bean.Msg;
import usts.cl.bean.User;
import usts.cl.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/cl")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 登录
     *
     * @param user
     * @return
     * @throws Exception
     */
    @ResponseBody
    @PostMapping("/login")
    public Msg login(@RequestBody User user, HttpSession session) throws Exception {
        if (userService.login(user) == false)
            return Msg.fail().add("login", false);
        else
            return Msg.success().add("login", true).add("userName",session.getAttribute("userName"));
    }

    @ResponseBody
    @GetMapping("/logOut")
    public Boolean logOut() {
        return userService.logOut();
    }

    /**
     * 注册
     *
     * @param user
     * @return
     * @throws Exception
     */
    @ResponseBody
    @PostMapping("/register")
    public Msg register(@RequestBody User user) throws Exception {
        if (userService.register(user)) return Msg.success().add("register", true);
        else return Msg.fail().add("register", false);
    }

    /**
     * 通过uid修改密码
     *
     * @param uid
     * @param rawPass
     * @param newPass
     * @return
     * @throws Exception
     */
    @ResponseBody
    @PutMapping("/updatePass/{uid}")
    public Msg update(@PathVariable("uid") String uid,
                      @RequestParam(value = "rawPass") String rawPass,
                      @RequestParam(value = "newPass") String newPass)
            throws Exception {
        if (userService.update(uid, rawPass, newPass)) return Msg.success().add("update", true);
        else return Msg.fail().add("update", false);
    }

    /**
     * 用户——文件显示(一用户对应多文件)
     */
    @GetMapping("/showFiles")
    @ResponseBody
    public List<User> showDownFiles() {
        return userService.showDownFiles();
    }
}

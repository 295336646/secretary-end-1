package usts.cl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import usts.cl.bean.Msg;
import usts.cl.bean.User;
import usts.cl.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/cl")
public class UserController {
    @Autowired
    UserService userService;

    /**
     * 登录
     * @param user
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @PostMapping("/login")
    public Msg login(@RequestBody User user, HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        if (userService.login(user))
            return Msg.success().add("login", true).add("userName", session.getAttribute("username"));
        else return Msg.fail().add("login", false);
    }

    /**
     * 注册
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

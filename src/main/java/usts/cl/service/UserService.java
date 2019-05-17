package usts.cl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import usts.cl.bean.User;
import usts.cl.dao.UserMapper;
import usts.cl.redis.RedisLogService;
import usts.cl.utils.PasswordHash;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.concurrent.TimeUnit;


@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    // 登录
    public Boolean login(User user) throws Exception {
        System.out.println(user.getRole());
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        User currentUser = userMapper.selectByPrimaryKey(user.getUid());
        if (currentUser == null) return false;
        else {
            if (currentUser.getRole() != user.getRole()) return false;
            // 如果存在用户
            if (user.getPassword() == null || user.getUid() == null
                    || user.getPassword().equals("") || user.getUid().equals(""))
                return false;
            String hash = currentUser.getPassword();
            String salt = currentUser.getSalt();
            user.setUserName(currentUser.getUserName());
            //登录成功，创建会话，有效时间为30min
            if (PasswordHash.validatePassword(user.getPassword(), hash, salt)) {
                int expireTime = 30 * 60;
                session.setAttribute("userName", currentUser.getUserName());
                session.setMaxInactiveInterval(expireTime);
                return true;
            } else return false;
        }
    }

    //销毁session
    public Boolean logOut() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        session.invalidate();
        return true;
    }

    // 注册
    public Boolean register(User user) throws Exception {
        User currentUser = userMapper.selectByPrimaryKey(user.getUid());
        if (currentUser == null) {
            String[] params = PasswordHash.createHash(user.getPassword()).split(":");
            String hash = params[PasswordHash.PBKDF2_INDEX];
            String salt = params[PasswordHash.SALT_INDEX];
            userMapper.insert(new User(user.getUid(), user.getUserName(), hash, salt, user.getRole()));
            return true;
        }
        return false;
    }

    // 修改密码
    public Boolean update(String uid, String rawPass, String newPass) throws Exception {
        User currentUser = new User(uid, null, rawPass, null, null);
        if (login(currentUser)) {
            String[] params = PasswordHash.createHash(newPass).split(":");
            String hash = params[PasswordHash.PBKDF2_INDEX];
            String salt = params[PasswordHash.SALT_INDEX];
            userMapper.updateByPrimaryKeySelective(new User(uid, null, hash, salt, null));
            return true;
        }
        return false;
    }

    public List<User> showDownFiles() {
        return userMapper.selectByExampleWithFile(null);
    }
}

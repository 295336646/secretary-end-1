package usts.cl.bean;

import lombok.Data;

import java.util.List;

@Data
public class User {
    private String uid;

    private String userName;

    private String password;

    private String salt;

    private Integer role;

    private List<File> fileList;

    public User() {
    }

    public User(String uid, String userName, String password, String salt, Integer role) {
        this.uid = uid;
        this.userName = userName;
        this.password = password;
        this.salt = salt;
        this.role = role;
    }
}
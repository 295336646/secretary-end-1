package usts.cl.bean;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
public class User implements Serializable {
    @NotNull
    private String uid;

    private String userName;
    @NotNull
    private String password;

    private String salt;
    @NotNull
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
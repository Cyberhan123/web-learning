package cn.hselfweb.awsomeservlet.VO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    public User(Long id, String name, String password, String phone, String sex) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.sex = sex;
    }
    public User(){

    }

    private Long id;
    private String name;
    private String password;
    private String phone;
    private String sex;
    private String iconName;
}

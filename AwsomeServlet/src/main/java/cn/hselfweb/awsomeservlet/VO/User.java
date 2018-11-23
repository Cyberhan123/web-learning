package cn.hselfweb.awsomeservlet.VO;

import lombok.Data;

@Data
public class User {
    public User(Long id, String name, String phone, String sex) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.sex = sex;
    }

    private Long id;
    private String name;
    private String phone;
    private String sex;
}

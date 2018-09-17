package cn.hselfweb.jsp.VO;

public class User {
    private String userid;
    private String username;
    private String password;
    private String sex;
    private String agree;

    public User() {

    }

    public User(String userid, String username, String password, String sex, String agree) {
        this.agree = agree;
        this.sex = sex;
        this.password = password;
        this.username = username;
    }

    /**
     * 检测 类中变量赋值情况
     *
     * @return boolean empty[] 这是一个查看是否为空的bool数组
     */
    public boolean[] isEmpty() {
        boolean empty[] = new boolean[4];
        empty[0] = this.username != null;
        empty[1] = this.password != null;
        empty[2] = this.sex != null;
        empty[3] = this.agree != null;
        return empty;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUserid() {
        return userid;
    }

    public void setAgree(String agree) {
        this.agree = agree;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAgree() {
        return agree;
    }

    public String getPassword() {
        return password;
    }

    public String getSex() {
        return sex;
    }

    public String getUsername() {
        return username;
    }
}

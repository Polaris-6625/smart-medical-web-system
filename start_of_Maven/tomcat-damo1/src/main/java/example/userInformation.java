package example;

public class userInformation {
    private Integer id;
    private String username;
    private String password;
    private String per;
    private String sex;
    private String realname;

    public String getPer() {
        return per;
    }

    public void setPer(String per) {
        this.per = per;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "userInformation{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", per='" + per + '\'' +
                ", sex='" + sex + '\'' +
                ", realname='" + realname + '\'' +
                '}';
    }
}

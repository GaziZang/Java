package gz.maven.web.model;

/**
 * Created by gazizang on 17/3/19.
 */
public class User {
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private String userName;
    private int age;
}

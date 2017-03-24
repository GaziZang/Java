package gz.springMVC.model;

import gz.springMVC.helper.JsonHelper;

/**
 * Created by gazizang on 17/3/19.
 */
public class User {

    private String userName;
    private int age;

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

    @Override
    public String toString(){
        return JsonHelper.objectToJson(this);
    }
}

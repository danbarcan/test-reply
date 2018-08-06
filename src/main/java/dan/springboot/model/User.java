package dan.springboot.model;

import java.util.List;

public class User {
    private Integer id;
    private String name;
    private String gender;
    private Integer age;
    private String username;
    private String password;

    public User() {
    }

    public User(Integer id, String name, String gender, Integer age, String username, String password) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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
}
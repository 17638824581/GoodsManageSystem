package com.xty.bean;

import java.time.LocalDateTime;

public class User {
    private int id;
    private String username;
    private String name;
    private String password;
    private LocalDateTime ctime;

    public User() {
    }

    public User(int id, String username, String name, String password, LocalDateTime ctime) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.password = password;
        this.ctime = ctime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCtime() {
        return ctime;
    }

    public void setCtime(LocalDateTime ctime) {
        this.ctime = ctime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", ctime=" + ctime +
                '}';
    }
}

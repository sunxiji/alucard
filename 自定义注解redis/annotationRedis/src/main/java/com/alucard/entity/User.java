package com.alucard.entity;

import java.io.Serializable;

/**
 * @author alucard
 * @Description
 * @Date Create in 18:47 2018/10/25
 */
public class User implements Serializable {
    private static final long serialVersionUID = 8809101560720973267L;
    private Integer id;
    private String username;

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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}

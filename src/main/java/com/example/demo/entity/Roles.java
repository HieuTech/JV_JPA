package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity(name = "roles")
public class Roles {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "create_at")
    private Date createAt;

    @Column(name = "role_name")
    private String roleName;

    @OneToMany(mappedBy = "roles")
    //Set la 1 list loại bỏ dữ liệu trùng
    private Set<Users> userList;

    public Set<Users> getUserList() {
        return userList;
    }

    public void setUserList(Set<Users> userList) {
        this.userList = userList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}

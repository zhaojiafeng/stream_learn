package com.zjf.terminal.model;

import java.util.Objects;

public class Admin {

    private Integer id;
    private String adminName;
    private String password;
    private Integer age;
    private Integer deleteFlag;
    private String telephone;
    private String email;

    public Admin() {
    }

    public Admin(String adminName, Integer age) {
        this.adminName = adminName;
        this.age = age;
    }

    public Admin(Integer id, String adminName, Integer age) {
        this.id = id;
        this.adminName = adminName;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id);
        result = prime * result + ((adminName == null) ? 0 : adminName.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((id == null) ? 0 : age);
        result = prime * result + ((id == null) ? 0 : deleteFlag);
        result = prime * result + ((telephone == null) ? 0 : telephone.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Admin temp = (Admin) obj;
        return Objects.equals(id, temp.id) &&
                Objects.equals(adminName, temp.adminName) &&
                Objects.equals(password, temp.password) &&
                Objects.equals(age, temp.age) &&
                Objects.equals(deleteFlag, temp.deleteFlag) &&
                Objects.equals(telephone, temp.telephone) &&
                Objects.equals(email, temp.email) ;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", adminName='" + adminName + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", deleteFlag=" + deleteFlag +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}


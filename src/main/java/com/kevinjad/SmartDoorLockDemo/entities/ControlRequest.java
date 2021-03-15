package com.kevinjad.SmartDoorLockDemo.entities;

public class ControlRequest {

    private String name;
    private String password;
    private String lock;

    public String getLock() {
        return lock;
    }

    public void setLock(String lock) {
        this.lock = lock;
    }

    public ControlRequest(String name, String password, String lock) {
        this.name = name;
        this.password = password;
        this.lock = lock;
    }

    public ControlRequest() {
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
}

package com.lzy.demo.model;

/**
 * Created by 54330 on 2018/6/7.
 */

public class APPMemuModel {
    String id;
    String name;

    public String getId() {
        return id == null ? "" : id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name == null ? "" : name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

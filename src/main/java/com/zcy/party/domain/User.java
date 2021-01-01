package com.zcy.party.domain;
public class User {
    private int type;
    private String id;
    private String name;
    public User(int type, String id, String name){
        this.id=id;this.type=type;this.name=name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

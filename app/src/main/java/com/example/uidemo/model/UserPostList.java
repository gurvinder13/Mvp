package com.example.uidemo.model;

import java.util.List;

public class UserPostList {
    private String company;
    private String title;
    private String body;

    public UserPostList(String title, String body,String company){
       this.title = title;
       this.body = body;
       this.company = company;
    }


    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}

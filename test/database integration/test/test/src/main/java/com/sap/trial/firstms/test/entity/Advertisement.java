package com.sap.trial.firstms.test.entity;


public class Advertisement {


    private Long id;


    private String title;

    public Advertisement(){

    }

    public Advertisement(Long id, String title){
        this.id = id;
        this.title = title;
    }


    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Advertisement [id=" + id + ", title=" + title + "]";
    }

}

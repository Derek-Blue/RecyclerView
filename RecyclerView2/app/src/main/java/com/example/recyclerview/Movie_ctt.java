package com.example.recyclerview;

public class Movie_ctt {
    //清單建立的基本架構
    public int pic;
    public String name;
    public String date;
    public String story;

    public Movie_ctt(int pic, String name, String date, String story) {
        this.pic = pic;
        this.name = name;
        this.date = date;
        this.story = story;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }







}

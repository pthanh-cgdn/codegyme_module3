package com.codegyme.case_study_module3.models;

public class Movie {
    private int id;
    private String title;
    private String director;
    private String release_year;
    private int duration;
    private String image;
    private String description;

    public Movie(int id, String title, String director, String release_year, int duration, String image, String description) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.release_year = release_year;
        this.duration = duration;
        this.image = image;
        this.description = description;
    }

    public Movie(String title, String director, String release_year, int duration, String image, String description) {
        this.title = title;
        this.director = director;
        this.release_year = release_year;
        this.duration = duration;
        this.image = image;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getRelease_year() {
        return release_year;
    }

    public void setRelease_year(String release_year) {
        this.release_year = release_year;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

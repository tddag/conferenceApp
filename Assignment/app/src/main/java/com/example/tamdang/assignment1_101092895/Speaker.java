package com.example.tamdang.assignment1_101092895;

public class Speaker {
    private long id;
    private String first_name;
    private String last_name;
    private String affiliation;
    private String email;
    private String bio;

    public Speaker(long id, String first_name, String last_name, String affiliation, String email, String bio) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.affiliation = affiliation;
        this.email = email;
        this.bio = bio;
    }
    public Speaker(String first_name, String last_name, String affiliation, String email, String bio) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.affiliation = affiliation;
        this.email = email;
        this.bio = bio;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return first_name;
    }

    public void setFirstname(String first_name) {
        this.first_name = first_name;
    }

    public String getLastname() {
        return last_name;
    }

    public void setLastname(String last_name) {
        this.last_name = last_name;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) { this.email = email; }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }


    @Override
    public String toString() {
        return "";
    }
}

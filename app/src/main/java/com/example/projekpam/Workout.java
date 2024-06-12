package com.example.projekpam;

// Workout.java
public class Workout {
    private String name;
    private String reps;
    private int imageResourceId;

    public Workout(String name, String reps, int imageResourceId) {
        this.name = name;
        this.reps = reps;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public String getReps() {
        return reps;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}



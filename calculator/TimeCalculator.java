package com.gijon.screenmatch.calculator;

import com.gijon.screenmatch.models.Title;

public class TimeCalculator {
    private int totalTime;
    public int getTotalTime() {
        return this.totalTime;
    }

    public void inclui(Title title) {
        System.out.println("Adding length in minutes of " + title);
        this.totalTime += title.getTimeInMinutes();
    }
}

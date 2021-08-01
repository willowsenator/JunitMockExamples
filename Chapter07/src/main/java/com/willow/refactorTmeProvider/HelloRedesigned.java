package com.willow.refactorTmeProvider;

public class HelloRedesigned {
    private TimeProvider timeProvider;

    public HelloRedesigned(TimeProvider timeProvider){
        this.timeProvider = timeProvider;
    }

    public String sayHello(){
        return timeProvider.isMorning() ? "Good Morning!" : "Good Afternoon!";
    }
}

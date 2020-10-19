package com.javaex.ch6;

public class TvProps {
    //객체 프로퍼티
    private boolean power;
    private int channel;

    public TvProps() {
        this.channel = 1;
        this.power = false;
    }

    void power() {
        this.power = !power;
    }

    void channelUp() {
        this.channel = ++channel;
    }

    void channelDown() {
        this.channel = --channel;
    }

    public int getChannel() {
        return channel;
    }

}
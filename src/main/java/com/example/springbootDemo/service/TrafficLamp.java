package com.example.springbootDemo.service;

public enum TrafficLamp {

    Red(30) {
        @Override
        public TrafficLamp newxLamp() {
            return GREEN;
        }
    },
    GREEN(45) {
        @Override
        public TrafficLamp newxLamp() {
            return YELLOW;
        }
    },
    YELLOW(5) {
        @Override
        public TrafficLamp newxLamp() {
            return Red;
        }
    };

    public abstract TrafficLamp newxLamp();

    private int time;

    TrafficLamp(int time) {
        this.time = time;
    }

    public static void main(String[] args) {
        System.out.println(TrafficLamp.Red.newxLamp());
        System.out.println(TrafficLamp.Red.time);
    }
}

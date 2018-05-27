package com.example.springbootDemo.service;

public enum Grade {
    A {
        @Override
        public String getDesc() {
            return "优秀";
        }
    },
    B {
        @Override
        public String getDesc() {
            return "良好";
        }
    };
    public abstract String getDesc();

    public static void main(String[] args) {
        System.out.printf(Grade.A.getDesc());
    }
}

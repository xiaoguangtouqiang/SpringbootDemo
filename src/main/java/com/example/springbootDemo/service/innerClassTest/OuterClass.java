package com.example.springbootDemo.service.innerClassTest;

public class OuterClass {
    private String outName;
    private int outAge;

    public void display() {
        InnerClass innerClass = new InnerClass();
        innerClass.display();
    }

    public class InnerClass {
        private int innerAge;
        public InnerClass() {
            outName = "this is outerClass property";
            outAge = 20;
        }

        public void display() {
            System.out.println(outName + "and outAge is:" + outAge);
        }
    }

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        outerClass.display();
    }

}

package com.example.springbootDemo.service.arrayT;

public class Generic<T> {
    private T key;

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public Generic(T key) {
        this.key = key;
    }

    public <E> void showKeyName(Generic<E> container){
        System.out.println("container key :" + container.getKey());
        //当然这个例子举的不太合适，只是为了说明泛型方法的特性。
        E test = container.getKey();
//        return test;
    }


    public static void main(String[] args) {
        Generic<Integer> genericInteger = new Generic<Integer>(123456);
        Generic genericString = new Generic("ssss");
        Generic<String> genericInt = new Generic<String>("SSSS");
        System.out.println(genericInteger.getKey());
        System.out.println(genericString.getKey());
    }
}

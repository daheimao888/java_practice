package com.meek;

import java.util.function.Consumer;

public interface MyInterface {
    double test1();
    default double test2(){
        return 1;
    }
}
class Person{
    private String name;
    private String name1;
    Person(String name,String name1){
        this.name = name;
        this.name1 = name1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }
}

class MyDefault{
    public static void main(String[] args){
        MyInterface i = new MyInterface() {
            @Override
            public double test1() {
                return 0;
            }
        };
        i.test1();
        i.test2();

        Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.getName());
        greeter.accept(new Person("Luke", "Skywalker"));

    }
}

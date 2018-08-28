package com.abhi.server.userservice.test;

public class Employee {

    int id;
    String name;

    Employee(int id, String name){
        this.name = name;
        this.id = id;
        System.out.println("Creating Employee with name : " + name +" hashcode: "+ name.hashCode());
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

//    @Override
//    public boolean equals(Object obj) {
//        return this.name.equals(((Employee) obj).name);
//    }

    @Override
    public String toString() {
        return "Employee : {"+id+", "+name+"}";
    }
}

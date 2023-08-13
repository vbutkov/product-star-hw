package ru.vbutkov.collection.workshop1.entity;

//Абрикосов,Абрикос,Java,Moscow,33
//Бутков,Владимир,Java,Sochi,34
//Персиков,Иван,DevOps,Rostov,30


public class Student {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String surname;
    private String name;
    private String course;
    private String city;
    private int age;

    public Student() {
    }
    public Student(String surname, String name, String course, String city, int age) {
        this.surname = surname;
        this.name = name;
        this.course = course;
        this.city = city;
        this.age = age;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getCourse() {
        return course;
    }

    public int getAge() {
        return age;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Student{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", course='" + course + '\'' +
                ", city='" + city + '\'' +
                ", age=" + age +
                '}';
    }
}

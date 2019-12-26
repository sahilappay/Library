package util;

public class User {
    private String name;
    private String surname;
    private int age;
    private int id;

    public User() {
    }

    public User(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public User(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "name: " + name + ", surname: " + surname + ", age: " + age + ", id: " + id +"\n";
    }
}

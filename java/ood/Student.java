package ood;

public class Student implements Person {
    String id;
    String name;
    int age;

    public Student(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getID() {
        return id;
    }

    @Override
    public boolean equals(Person other) {
        if (!(other instanceof Student))
            return false; // cannot be possibly equal
        Student s = (Student) other; // explicit cast now safe
        return id.equals(s.id); // compare IDs
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student [age=" + age + ", id=" + id + ", name=" + name + "]";
    }

}

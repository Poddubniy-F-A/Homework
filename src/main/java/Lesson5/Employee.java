package Lesson5;

public class Employee {
    String FullName;
    String post;
    String email;
    String phone;
    int salary;
    int age;

    public Employee() {
        this.FullName = "No name";
        this.post = "No post";
        this.email = "example@mail.com";
        this.phone = "0-000-000-00-00";
        this.salary = 0;
        this.age = 0;
    }

    public Employee(String FullName, String post, String email, String phone, int salary, int age) {
        this.FullName = FullName;
        this.post = post;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void Print() {
        System.out.println("Full name: " + this.FullName);
        System.out.println("Post: " + this.post);
        System.out.println("Email: " + this.email);
        System.out.println("Phone: " + this.phone);
        System.out.println("Salary: " + this.salary);
        System.out.println("Age: " + this.age);
    }
}

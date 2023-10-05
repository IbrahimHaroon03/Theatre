package com.mycompany.test;
import java.util.Scanner;

public class Person {
    private String name;
    private String surname;
    private String email;
    
    public Person(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }
    
    public Person() {
        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter name: ");
        this.name = input.nextLine();
        System.out.print("Enter surname: ");
        this.surname = input.nextLine();
        System.out.print("Enter email: ");
        this.email = input.nextLine();

    }
    
    // getters and setters
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
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
}
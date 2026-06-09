package org.g1rix.config.Reflection;

public class Employee {

    private int id;
    private String name;
    public String companyName;

    private Employee() {
        this.id = 101;
        this.name = "Giri";
        this.companyName = "Company";
    }

    public Employee(int id, String name, String companyName) {
        this.id = id;
        this.name = name;
        this.companyName = companyName;
    }

    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("CompanyName: " + companyName);
    }

    private void secretMethod() {
        System.out.println("Private method executed!");
    }
}

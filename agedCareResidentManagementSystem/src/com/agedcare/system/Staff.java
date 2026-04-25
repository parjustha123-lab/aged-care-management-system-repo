package com.agedcare.system;
//Staff class represents staff members working in the aged care system.
public class Staff extends Person {
 private String role;

 public Staff(int id, String name, int age, String role) {
     super(id, name, age);
     this.role = role;
 }

 public String getRole() {
     return role;
 }

 public void setRole(String role) {
     this.role = role;
 }

 @Override
 public String getDetails() {
     return "Staff ID: " + getId()
             + ", Name: " + getName()
             + ", Age: " + getAge()
             + ", Role: " + role;
 }
}
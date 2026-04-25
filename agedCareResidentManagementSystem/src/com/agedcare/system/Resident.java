package com.agedcare.system;
// Resident class stores aged care resident information.
// It extends Person to reuse common fields like id, name, and age.
public class Resident extends Person {
    private String healthStatus;
    private int roomNumber;
    private double balance;

    public Resident(int id, String name, int age, String healthStatus, int roomNumber, double balance) {
        super(id, name, age);
        this.healthStatus = healthStatus;
        this.roomNumber = roomNumber;
        this.balance = balance;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Reward reduces the resident balance.
    public void applyReward(double amount) {
        balance = balance - amount;

        if (balance < 0) {
            balance = 0;
        }
    }

    // Penalty increases the resident balance.
    public void applyPenalty(double amount) {
        balance = balance + amount;
    }

    // This method checks resident health and applies a simple action.
    public String evaluateStatus() {
        if (healthStatus.equalsIgnoreCase("Good")) {
            applyReward(50);
            return "Good health condition. Reward applied: $50 discount.";
        } else if (healthStatus.equalsIgnoreCase("Critical")) {
            applyPenalty(100);
            return "Critical health condition. Penalty/action applied: $100 additional care charge.";
        } else {
            return "Normal condition. No reward or penalty applied.";
        }
    }

    @Override
    public String getDetails() {
        return "Resident ID: " + getId()
                + ", Name: " + getName()
                + ", Age: " + getAge()
                + ", Health Status: " + healthStatus
                + ", Room Number: " + roomNumber
                + ", Balance: $" + balance;
    }
}
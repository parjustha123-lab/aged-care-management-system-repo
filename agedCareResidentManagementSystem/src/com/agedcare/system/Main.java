package com.agedcare.system;
import java.util.ArrayList;
import java.util.Scanner;

// Main class runs the text-based menu for the aged care system.
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ResidentManager manager = new ResidentManager();

        String fileName = "residents.txt";

        ArrayList<Resident> loadedResidents = FileHandler.loadResidentsFromFile(fileName);

        for (Resident resident : loadedResidents) {
            manager.addResident(resident);
        }

        int choice = 0;

        do {
            System.out.println("\n===== Aged Care Resident Management System =====");
            System.out.println("1. Add Resident");
            System.out.println("2. View Resident by ID");
            System.out.println("3. View Resident by Name");
            System.out.println("4. Update Resident");
            System.out.println("5. Delete Resident");
            System.out.println("6. Display All Residents");
            System.out.println("7. Evaluate All Residents");
            System.out.println("8. Save Records");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(input.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Enter Resident ID: ");
                        int id = Integer.parseInt(input.nextLine());

                        System.out.print("Enter Resident Name: ");
                        String name = input.nextLine();

                        System.out.print("Enter Resident Age: ");
                        int age = Integer.parseInt(input.nextLine());

                        System.out.print("Enter Health Status (Good / Normal / Critical): ");
                        String healthStatus = input.nextLine();

                        System.out.print("Enter Room Number: ");
                        int roomNumber = Integer.parseInt(input.nextLine());

                        System.out.print("Enter Balance: ");
                        double balance = Double.parseDouble(input.nextLine());

                        Resident newResident = new Resident(id, name, age, healthStatus, roomNumber, balance);
                        manager.addResident(newResident);

                        System.out.println("Resident added successfully.");
                        break;

                    case 2:
                        System.out.print("Enter Resident ID: ");
                        int searchId = Integer.parseInt(input.nextLine());

                        Resident foundById = manager.searchResidentById(searchId);

                        if (foundById != null) {
                            System.out.println(foundById.getDetails());
                        } else {
                            System.out.println("Resident not found.");
                        }
                        break;

                    case 3:
                        System.out.print("Enter Resident Name: ");
                        String searchName = input.nextLine();

                        Resident foundByName = manager.searchResidentByName(searchName);

                        if (foundByName != null) {
                            System.out.println(foundByName.getDetails());
                        } else {
                            System.out.println("Resident not found.");
                        }
                        break;

                    case 4:
                        System.out.print("Enter Resident ID to update: ");
                        int updateId = Integer.parseInt(input.nextLine());

                        System.out.print("Enter New Name: ");
                        String newName = input.nextLine();

                        System.out.print("Enter New Age: ");
                        int newAge = Integer.parseInt(input.nextLine());

                        System.out.print("Enter New Health Status: ");
                        String newHealthStatus = input.nextLine();

                        System.out.print("Enter New Room Number: ");
                        int newRoomNumber = Integer.parseInt(input.nextLine());

                        System.out.print("Enter New Balance: ");
                        double newBalance = Double.parseDouble(input.nextLine());

                        boolean updated = manager.updateResident(updateId, newName, newAge, newHealthStatus, newRoomNumber, newBalance);

                        if (updated) {
                            System.out.println("Resident updated successfully.");
                        } else {
                            System.out.println("Resident not found.");
                        }
                        break;

                    case 5:
                        System.out.print("Enter Resident ID to delete: ");
                        int deleteId = Integer.parseInt(input.nextLine());

                        boolean deleted = manager.deleteResident(deleteId);

                        if (deleted) {
                            System.out.println("Resident deleted successfully.");
                        } else {
                            System.out.println("Resident not found.");
                        }
                        break;

                    case 6:
                        manager.displayAllResidents();
                        break;

                    case 7:
                        manager.evaluateAllResidents();
                        break;

                    case 8:
                        FileHandler.saveResidentsToFile(manager.getResidents(), fileName);
                        break;

                    case 9:
                        FileHandler.saveResidentsToFile(manager.getResidents(), fileName);
                        System.out.println("Thank you. Program closed.");
                        break;

                    default:
                        System.out.println("Invalid choice. Please select from 1 to 9.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter numbers where required.");
            }

        } while (choice != 9);

        input.close();
    }
}

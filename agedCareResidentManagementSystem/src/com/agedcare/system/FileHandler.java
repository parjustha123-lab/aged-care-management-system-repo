package com.agedcare.system;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.ArrayList;

// This class handles reading and saving resident data from/to a text file.
public class FileHandler {

    public static ArrayList<Resident> loadResidentsFromFile(String fileName) {
        ArrayList<Resident> residents = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                String healthStatus = data[3];
                int roomNumber = Integer.parseInt(data[4]);
                double balance = Double.parseDouble(data[5]);

                Resident resident = new Resident(id, name, age, healthStatus, roomNumber, balance);
                residents.add(resident);
            }

            System.out.println("Resident records loaded successfully.");

        } catch (FileNotFoundException e) {
            System.out.println("Data file not found. Program will start with an empty list.");
        } catch (IOException e) {
            System.out.println("Error reading the data file.");
        } catch (Exception e) {
            System.out.println("Invalid data format found in the file.");
        }

        return residents;
    }

    public static void saveResidentsToFile(ArrayList<Resident> residents, String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {

            for (Resident resident : residents) {
                writer.println(
                        resident.getId() + ","
                        + resident.getName() + ","
                        + resident.getAge() + ","
                        + resident.getHealthStatus() + ","
                        + resident.getRoomNumber() + ","
                        + resident.getBalance()
                );
            }

            System.out.println("Resident records saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving resident records.");
        }
    }
}

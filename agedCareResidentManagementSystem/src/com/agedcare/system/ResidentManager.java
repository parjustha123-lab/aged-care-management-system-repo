package com.agedcare.system;
import java.util.ArrayList;

// This class manages all resident records using ArrayList.
public class ResidentManager {
    private ArrayList<Resident> residents;

    public ResidentManager() {
        residents = new ArrayList<>();
    }

    public void addResident(Resident resident) {
        residents.add(resident);
    }

    public ArrayList<Resident> getResidents() {
        return residents;
    }

    public Resident searchResidentById(int id) {
        for (Resident resident : residents) {
            if (resident.getId() == id) {
                return resident;
            }
        }
        return null;
    }

    public Resident searchResidentByName(String name) {
        for (Resident resident : residents) {
            if (resident.getName().equalsIgnoreCase(name)) {
                return resident;
            }
        }
        return null;
    }

    public boolean updateResident(int id, String newName, int newAge, String newHealthStatus, int newRoomNumber, double newBalance) {
        Resident resident = searchResidentById(id);

        if (resident != null) {
            resident.setName(newName);
            resident.setAge(newAge);
            resident.setHealthStatus(newHealthStatus);
            resident.setRoomNumber(newRoomNumber);
            resident.setBalance(newBalance);
            return true;
        }

        return false;
    }

    public boolean deleteResident(int id) {
        Resident resident = searchResidentById(id);

        if (resident != null) {
            residents.remove(resident);
            return true;
        }

        return false;
    }

    public void displayAllResidents() {
        if (residents.isEmpty()) {
            System.out.println("No resident records found.");
        } else {
            for (Resident resident : residents) {
                System.out.println(resident.getDetails());
            }
        }
    }

    public void evaluateAllResidents() {
        if (residents.isEmpty()) {
            System.out.println("No residents available for evaluation.");
        } else {
            for (Resident resident : residents) {
                System.out.println(resident.getName() + ": " + resident.evaluateStatus());
            }
        }
    }
}

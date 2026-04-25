package com.agedcare.system;
//Room class stores room details for aged care residents.
public class Room {
 private int roomNumber;
 private String roomType;
 private boolean available;

 public Room(int roomNumber, String roomType, boolean available) {
     this.roomNumber = roomNumber;
     this.roomType = roomType;
     this.available = available;
 }

 public int getRoomNumber() {
     return roomNumber;
 }

 public String getRoomType() {
     return roomType;
 }

 public boolean isAvailable() {
     return available;
 }

 public void setAvailable(boolean available) {
     this.available = available;
 }

 @Override
 public String toString() {
     return "Room Number: " + roomNumber
             + ", Room Type: " + roomType
             + ", Available: " + available;
 }
}
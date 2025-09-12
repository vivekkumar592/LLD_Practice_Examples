package org.example.ParkingSystem;

public class Truck implements Vehicle{
    private int licenseNumber;
    private Category category;
    Truck(int licenseNumber){
        this.licenseNumber = licenseNumber;
        category = Category.small;
    }
    @Override
    public Category typeOfVehicle(){
        return category;
    }

}
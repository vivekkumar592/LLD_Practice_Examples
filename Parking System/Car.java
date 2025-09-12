package org.example.ParkingSystem;

public class Car implements Vehicle{
    private int licenseNumber;
    private Category category;

    Car(int licenseNumber){
        this.licenseNumber = licenseNumber;
        category = Category.small;
    }
    @Override
    public Category typeOfVehicle(){
        return category;
    }

}

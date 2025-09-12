package org.example;

import org.example.ParkingSystem.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Vehicle vehicle = new Car(123);

        Space space1 = new Space(Category.small);
        Space space2 = new Space(Category.MAV);

        Space space3 = new Space(Category.small);
        Space space4 = new Space(Category.small);
        List<Space> listOfspaces = new ArrayList<>();
        listOfspaces.add(space1);
        listOfspaces.add(space2);

        List<Space> listOfspaces1 = new ArrayList<>();
        listOfspaces.add(space3);
        listOfspaces.add(space4);

        IndividualLevel level1 = new IndividualLevel(1,listOfspaces);
        IndividualLevel level2 = new IndividualLevel(2,listOfspaces1);

        List<IndividualLevel> listOfLevels = new ArrayList<>();
        listOfLevels.add(level1);
        listOfLevels.add(level2);


        MultiLevelParking multiLevelParking = new MultiLevelParking(listOfLevels);

        Parking parking  = new Parking(multiLevelParking);

        Vehicle vehicle1 = new Car(123);
        Vehicle vehicle2 = new Car(124);
        Vehicle vehicle3 = new Car(125);
        Vehicle vehicle4 = new Car(126);
        Vehicle vehicle5 = new Car(127);
        Vehicle vehicle6 = new Truck(128);
        Vehicle vehicle7 = new Truck(129);

        System.out.println(multiLevelParking.getNoOfLevels());
        System.out.println(parking.assignParking(Category.small,vehicle1));
        System.out.println(parking.assignParking(Category.small,vehicle2));
        System.out.println(parking.assignParking(Category.small,vehicle3));
        System.out.println(parking.assignParking(Category.small,vehicle4));
        System.out.println(parking.assignParking(Category.small,vehicle5));
        System.out.println(parking.assignParking(Category.MAV,vehicle6));
        System.out.println(parking.assignParking(Category.MAV,vehicle7));






    }
}
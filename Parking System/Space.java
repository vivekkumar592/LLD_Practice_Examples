package org.example.ParkingSystem;
import java.time.*;
import java.time.temporal.ChronoUnit;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class Space {

    private static Integer id = 0;
    private Category categoryAssociated;
    private LocalDateTime  timeOccupied;
    private Boolean vacant;
    private Vehicle parkedVehicle;

    Space(Category categoryAssociated)
    {
        this.categoryAssociated = categoryAssociated;
        this.vacant = true;

        id = id + 1;
    }

    public Category getCategoryAssociated() {
        return categoryAssociated;
    }

    public Integer getId(){
        return id;
    }

    public Boolean isFilled(){
        return !vacant;
    }

    public void fillSpace(Vehicle vehicle)
    {
        if(vacant)
        {
            parkedVehicle = vehicle;
            timeOccupied = LocalDateTime.now();
            vacant = false;

        }
    }

    public long vacantSpace(){
        if(!vacant)
        {
            Vehicle dummyVehicle = new Car(0);
            parkedVehicle =dummyVehicle;
            vacant = true;

        }
        return (ChronoUnit.HOURS.between(timeOccupied, LocalDateTime.now()));
    }

}

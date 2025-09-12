package org.example.ParkingSystem;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Parking {
    private String name;
    private String address;
    private String id;
    private  final MultiLevelParking multiLevelParking;

    Parking( MultiLevelParking multiLevelParking ){

        this.multiLevelParking =  multiLevelParking;;
    }
    public String assignParking(Category category, Vehicle vehicle){
        return multiLevelParking.assignSpaceInLevel(category, vehicle);
    }
}

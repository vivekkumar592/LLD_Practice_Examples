package org.example.ParkingSystem;
import java.util.*;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class MultiLevelParking {
    private int noOfLevels;
    private final List<IndividualLevel> listOfAvailableLevels;

    MultiLevelParking(List<IndividualLevel> listOfAvailableLevels){
        this.listOfAvailableLevels = new ArrayList<>(listOfAvailableLevels);
        this.noOfLevels = listOfAvailableLevels.size();
    }
    public void addLevels(List<Space> listOfSpaces)
    {
        IndividualLevel individualLevel = new IndividualLevel(noOfLevels+1, listOfSpaces);
        listOfAvailableLevels.add(individualLevel);
        noOfLevels++;
    }
    private int findFreeLevel(Category category)
    {
//        System.out.println("Finding free leaevel"+ listOfAvailableLevels.size());
        for(int i = 0 ; i < listOfAvailableLevels.size() ; i++)
        {
//            System.out.println(listOfAvailableLevels.get(i).isFreeSpaceAvailable(category));
            if(listOfAvailableLevels.get(i).isFreeSpaceAvailable(category)) return i;
        }
        return -1;
    }

    public String assignSpaceInLevel(Category category, Vehicle vehicle)
    {
        int freeLevelId = findFreeLevel(category);
        if(freeLevelId == -1) return "No Space Available";
        String assigned = listOfAvailableLevels.get(freeLevelId).assignSpace(category, vehicle);
        return assigned;
    }
}

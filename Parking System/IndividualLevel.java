package org.example.ParkingSystem;

import java.util.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IndividualLevel
{
    private int totalNoOfSpace;
    private List<Space> listOfSpaces;
    private Map<Category, Integer> noOfAvailableSpaceForCategory;
    private Integer levelId;
    private Map<Space, Vehicle> filledSpaces;

    IndividualLevel(Integer levelId, List<Space> listOfSpaces)
    {
        this.levelId = levelId;
        this.listOfSpaces = new ArrayList<>(listOfSpaces);
        Map<Category, Integer> availabelSpaceVsCategoryMapping = new HashMap<>();
        for(int i = 0 ; i < listOfSpaces.size();i++)
        {
            Space currentSpace = listOfSpaces.get(i);
            availabelSpaceVsCategoryMapping.compute(currentSpace.getCategoryAssociated(), (k, value) -> (value == null) ? 1 : value + 1);
        }
        this.noOfAvailableSpaceForCategory = new HashMap<>(availabelSpaceVsCategoryMapping);
        this.filledSpaces = new HashMap<>();
    }


    public void addNewSpace(Category categoryAssociated){
        Space space = new Space(categoryAssociated);
        listOfSpaces.add(space);
        totalNoOfSpace++;
    }

    public Boolean isFreeSpaceAvailable(Category category)
    {
        if(noOfAvailableSpaceForCategory == null) return false;
        Integer value = noOfAvailableSpaceForCategory.get(category);

        return (value != null && value > 0);
    }

    private Integer findSpaceId(Category category)
    {
        for(int i = 0  ; i < listOfSpaces.size(); i++)
        {
            Space currentSpace = listOfSpaces.get(i);
            if(!currentSpace.isFilled() && (currentSpace.getCategoryAssociated() == (category))) return listOfSpaces.get(i).getId() -1;
        }
        return -1;
    }

    public String assignSpace(Category category, Vehicle vehicle){
          int indexOfVacantspace = findSpaceId(category);
          if(indexOfVacantspace == -1) return "No Space Available for this Category of vehicle";
          Space currentSpace = listOfSpaces.get(indexOfVacantspace);
          currentSpace.fillSpace(vehicle);
          noOfAvailableSpaceForCategory.put(category, noOfAvailableSpaceForCategory.get(category) - 1);
          filledSpaces.put(currentSpace, vehicle);
          return "Space assigned successfully";
    }


}

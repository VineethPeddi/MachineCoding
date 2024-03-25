package ParkingLot.src.Models;

import ParkingLot.src.strategy.AllocateParkingStrategy;
import ParkingLot.src.strategy.EmptyParkingSlot;

import java.util.List;

public class Floor {
    int id;
    List<ParkingSlot> parkingSlotsList;
    int floorNo;

    public Floor(List<ParkingSlot> parkingSlotsList, int floorNo) {
        this.parkingSlotsList = parkingSlotsList;
        this.floorNo = floorNo;
    }

    public ParkingSlot findParkingSlot(String allocationStrategy){
        AllocateParkingStrategy allocateParkingStrategy=getStrategy(allocationStrategy);
        return allocateParkingStrategy.findParkingSlot();

    }

    public AllocateParkingStrategy getStrategy(String allocationStrategy){
        if(allocationStrategy.equals("empty")){
            return new EmptyParkingSlot();
        }
        return null;
    }





}

package ParkingLot.src.Models;

import java.util.List;

public class Floor {
    int id;
    List<ParkingSlot> parkingSlotsList;
    int floorNo;

    public Floor(List<ParkingSlot> parkingSlotsList, int floorNo) {
        this.parkingSlotsList = parkingSlotsList;
        this.floorNo = floorNo;
    }

}

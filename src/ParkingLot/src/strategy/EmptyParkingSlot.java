package ParkingLot.src.strategy;

import ParkingLot.src.Models.ParkingSlot;

public class EmptyParkingSlot implements AllocateParkingStrategy{
    public ParkingSlot findParkingSlot() {
        return null;
    }
}

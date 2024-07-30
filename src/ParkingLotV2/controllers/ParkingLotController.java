package ParkingLotV2.controllers;

import ParkingLotV2.exceptions.InvalidException;
import ParkingLotV2.exceptions.SlotNotAvailableException;
import ParkingLotV2.exceptions.VehicleNotAllowedException;
import ParkingLotV2.models.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLotController {
    public ParkingLot createParkingLot(List<String> allowedVehicles, String fareCalculationStrategy, int numFloors, int numSlotsPerFloor, HashMap<String,Integer> availableSlots,List<String> acceptedPaymentTypes) throws InvalidException {
        return ParkingLot.getBuilder()
                .setAllowedVehicles(allowedVehicles)
                .setAvailableSlotsForVehicleType(availableSlots)
                .setFareCalculationStrategy(fareCalculationStrategy)
                .setNumFloors(numFloors)
                .setNumSlotsPerFloor(numSlotsPerFloor)
                .setPaymentTypes(acceptedPaymentTypes)
                .build();
    }

    public Ticket vehicleEntry(ParkingLot parkingLot,String vehicleNo,int gateNo,String vehicleType,String ownerName) throws InvalidException,VehicleNotAllowedException,SlotNotAvailableException{
        return parkingLot.vehicleEntry(vehicleNo,gateNo,vehicleType,ownerName);
    }

    public Bill vehicleExit(ParkingLot parkingLot,int tokenNumber,int exitGateNo){
        return parkingLot.vehicleExit(tokenNumber,exitGateNo);
    }

    public void displayParkingLot(ParkingLot parkingLot){
        parkingLot.displayParkingLot();
    }

    public void makePayment(){}
}
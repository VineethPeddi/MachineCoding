package ParkingLot.src.Models;

import ParkingLot.src.Exceptions.NoParkingSlotException;

import java.util.List;

public class Vehicle {
    int id;
    VechicleType vehicleType;

    String ownerName;
    String numberPlate;

    ParkingSlot parkingSlot;

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    public void setParkingSlot(ParkingSlot parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

    public Vehicle(VechicleType vehicleType, String ownerName, String numberPlate){
        this.vehicleType=vehicleType;
        this.ownerName=ownerName;
        this.numberPlate=numberPlate;
    }

    public void allocateParking(String allocationStrategy, List<Floor> floors) throws NoParkingSlotException{
        ParkingSlot parkingSlot=null;
        for(Floor floor:floors){
            parkingSlot=floor.findParkingSlot(allocationStrategy);
            if(parkingSlot!=null)break;
        }
        if(parkingSlot==null){
            throw new NoParkingSlotException();
        }
        parkingSlot.setParkingStatus(ParkingStatus.OCCUPIED);
        parkingSlot.setVehicleType(this.vehicleType);
        this.setParkingSlot(parkingSlot);
    }

    public void initExitProcess(){
        this.getParkingSlot().parkingStatus=ParkingStatus.EMPTY;
    }
}

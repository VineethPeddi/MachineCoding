package ParkingLotV2.models;

public class Vehicle {
    String number;
    VehicleType type;
    ParkingSlot parkingSlot;
    String ownerName;

    public Vehicle(String number,VehicleType type,String ownerName,ParkingSlot parkingSlot){
        this.number=number;
        this.type=type;
        this.ownerName=ownerName;
        parkingSlot.status=ParkingStatus.OCCUPIED;
        this.parkingSlot=parkingSlot;
    }

    public String getNumber() {
        return number;
    }

    public void deAllocate(){
        this.parkingSlot.status=ParkingStatus.AVAILABLE;
    }
}

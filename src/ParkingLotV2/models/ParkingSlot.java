package ParkingLotV2.models;


public class ParkingSlot {
    int slotNumber;
    int floor;
    VehicleType vehicleType;
    ParkingStatus status;

    public ParkingSlot(VehicleType vehicleType,int slotNumber,int floor){
        this.vehicleType=vehicleType;
        this.slotNumber=slotNumber;
        this.floor=floor;
        status=ParkingStatus.AVAILABLE;
    }
}

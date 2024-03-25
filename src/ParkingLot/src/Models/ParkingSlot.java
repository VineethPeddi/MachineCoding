package ParkingLot.src.Models;

public class ParkingSlot {
    int id;
    VechicleType vehicleType;
    ParkingStatus parkingStatus;
    int slotNumber;
    Floor floor;

    public ParkingSlot(VechicleType vehicleType, ParkingStatus parkingStatus, int slotNumber) {
        this.vehicleType = vehicleType;
        this.parkingStatus = parkingStatus;
        this.slotNumber = slotNumber;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }
}

package ParkingLot.src.Models;

public class ParkingSlot {
    int id;

    VechicleType vehicleType;
    ParkingStatus parkingStatus;
    int slotNumber;
    Floor floor;

    public Floor getFloor() {
        return floor;
    }

    public ParkingSlot(VechicleType vehicleType, ParkingStatus parkingStatus, int slotNumber) {
        this.vehicleType = vehicleType;
        this.parkingStatus = parkingStatus;
        this.slotNumber = slotNumber;
    }

    public VechicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VechicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public ParkingStatus getParkingStatus() {
        return parkingStatus;
    }

    public void setParkingStatus(ParkingStatus parkingStatus) {
        this.parkingStatus = parkingStatus;
    }


    public void setFloor(Floor floor) {
        this.floor = floor;
    }


}

package ParkingLotV2.strategies;

import ParkingLotV2.models.VehicleType;

public interface FareCalculation {
    int calculateFare(VehicleType vehicleType,String entryTime,String exitTime);
}

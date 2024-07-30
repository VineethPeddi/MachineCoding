package ParkingLotV2.strategies;

import ParkingLotV2.models.VehicleType;

public class FixedFare implements FareCalculation{
    public int calculateFare(VehicleType vehicleType, String entryTime, String exitTime){
        return 0;
    }
}

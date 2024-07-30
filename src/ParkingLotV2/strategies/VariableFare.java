package ParkingLotV2.strategies;

import ParkingLotV2.models.VehicleType;

public class VariableFare implements FareCalculation{
    @Override
    public int calculateFare(VehicleType vehicleType, String entryTime, String exitTime) {
        return 0;
    }
}

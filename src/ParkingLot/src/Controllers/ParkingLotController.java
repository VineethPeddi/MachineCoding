package ParkingLot.src.Controllers;

import ParkingLot.src.Models.Floor;
import ParkingLot.src.Models.Gate;
import ParkingLot.src.Models.ParkingLot;
import ParkingLot.src.Models.VechicleType;

import java.util.List;

public class ParkingLotController {
    public ParkingLot createParkingLot(List<Floor> floorList, List<Gate> gateList, List<VechicleType> allowedVehicles, String allocationStrategy, String feeCalculationStrategy) {
        return new ParkingLot(floorList, gateList, allowedVehicles, allocationStrategy, feeCalculationStrategy);
    }

}

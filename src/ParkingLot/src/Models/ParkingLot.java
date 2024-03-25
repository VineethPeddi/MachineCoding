package ParkingLot.src.Models;

import java.util.List;

public class ParkingLot {
    int id;
    List<Floor> floors;
    List<Gate> gates;
    List<VechicleType> allowedVechicles;
    PLStatus status;
    String allocationStrategy;
    String feeCalculationStrategy;

    public ParkingLot(List<Floor> floors,List<Gate> gates,List<VechicleType> allowedVechicles,String allocationStrategy,String feeCalculationStrategy){
        status=PLStatus.OPERATIONAL;
        this.floors=floors;
        this.gates=gates;
        this.allowedVechicles=allowedVechicles;
        this.allocationStrategy=allocationStrategy;
        this.feeCalculationStrategy=feeCalculationStrategy
    }
}

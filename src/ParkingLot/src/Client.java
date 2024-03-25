package ParkingLot.src;

import ParkingLot.src.Controllers.ParkingLotController;
import ParkingLot.src.Models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        ParkingLotController parkingLotController = new ParkingLotController();

        List<ParkingSlot> parkingSlotList = new ArrayList<>();
        parkingSlotList.add(new ParkingSlot(VechicleType.CAR, ParkingStatus.EMPTY, 1));
        parkingSlotList.add(new ParkingSlot(VechicleType.BIKE, ParkingStatus.EMPTY, 2));

        List<Operator> operatorList = new ArrayList<>();
        operatorList.add(new Operator(1, "Opearator1", 1));
        operatorList.add(new Operator(2, "Opearator2", 2));
        List<Gate> gatesList = new ArrayList<>();
        gatesList.add(new Gate(1, operatorList.get(0), GateStatus.Open, GateType.Entry));
        gatesList.add(new Gate(2, operatorList.get(1), GateStatus.Open, GateType.Exit));

        List<VechicleType> allowedVehicles = List.of(VechicleType.BIKE, VechicleType.CAR);
        String allocationStrategy = "Empty slot";
        String feeCalculationStrategy = "TimeBasedParking";

        ParkingLot pl = parkingLotController.createParkingLot(
                List.of(new Floor(parkingSlotList, 0)),
                gatesList,
                allowedVehicles,
                allocationStrategy,
                feeCalculationStrategy
        );

        System.out.println("Enter vehicle number: ");
        Scanner sc = new Scanner(System.in);
        String vehicleNumber = sc.next();
        System.out.println("Choose Vechicle Type: 1. CAR 2.BIKE");
        VechicleType vechicleType = VechicleType.BIKE;
        String type = sc.next();
        if (type == "CAR") vechicleType = VechicleType.CAR;


    }


}

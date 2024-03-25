package ParkingLot.src;

import ParkingLot.src.Controllers.ParkingLotController;
import ParkingLot.src.Models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws Exception {

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

        ParkingLot parkingLot = parkingLotController.createParkingLot(
                List.of(new Floor(parkingSlotList, 0)),
                gatesList,
                allowedVehicles,
                allocationStrategy,
                feeCalculationStrategy
        );


        while (true) {
            System.out.println("Which operation would you like to choose: 1.Entry 2.Exit 3.Stop");
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            if (option == 3) break;
            if (option == 1) vehicleEntry(parkingLotController,parkingLot);
            else if (option == 2) vehicleExit(parkingLotController,gatesList);
        }
    }

    public static void vehicleEntry(ParkingLotController parkingLotController,ParkingLot parkingLot) throws Exception{
        System.out.println("Enter vehicle number: ");
        Scanner sc = new Scanner(System.in);
        String vehicleNumber = sc.next();
        System.out.println("Choose Vechicle Type: 1. CAR 2.BIKE");
        VechicleType vechicleType = VechicleType.BIKE;
        String type = sc.next();
        if (type == "CAR") vechicleType = VechicleType.CAR;
        System.out.println("Enter owner name");
        String ownerName=sc.next();
        Vehicle vehicle=parkingLotController.registerVehicle(parkingLot,vechicleType,vehicleNumber,ownerName);
        Ticket ticket=parkingLotController.generateTicket(vehicle, parkingLot.getGates().get(0));
        System.out.println("Ticket details: "+ ticket.toString());
    }

    public static void vehicleExit(ParkingLotController parkingLotController,List<Gate> gatesList) throws Exception{
        System.out.println("Enter ticket number");
        Scanner sc=new Scanner(System.in);
        int ticketNumber=sc.nextInt();
        System.out.println("Enter gate number");
        int gateNumber=sc.nextInt();
        Gate gateObj=null;
        for(Gate gate:gatesList){
            if(gate.getGateNumber()==gateNumber)gateObj=gate;
        }
        Bill bill=parkingLotController.exitVehicle(ticketNumber,gateObj);
        System.out.println("Billing amount: "+ bill.getAmount());
    }

}


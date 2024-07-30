package ParkingLotV2;

import ParkingLotV2.controllers.ParkingLotController;
import ParkingLotV2.models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        List<String> allowedVehicles=new ArrayList<>();
        allowedVehicles.add("CAR");
        allowedVehicles.add("BIKE");
        ParkingLotController parkingLotController=new ParkingLotController();
        HashMap<String,Integer> availableSlots=new HashMap<>();
        availableSlots.put("CAR",2);
        availableSlots.put("BIKE",1);
        List<String> acceptedPaymentTypes=new ArrayList<>();
        acceptedPaymentTypes.add("PHONEPE");
        acceptedPaymentTypes.add("CASH");
        acceptedPaymentTypes.add("STRIPE");
        try {
            ParkingLot parkingLot=parkingLotController.createParkingLot(allowedVehicles,"FIXED",1,3,availableSlots,acceptedPaymentTypes);
            while(true){
                System.out.println("Choose one operation: 1.Entry 2.Exit 3.Stop");
                Scanner sc=new Scanner(System.in);
                int operation=sc.nextInt();
                if(operation==3)break;
                if(operation==1){
                    System.out.println("Enter vehicleNo: ");
                    String vehicleNo=sc.next().toUpperCase();

                    System.out.println("Enter entry gate no: ");
                    int gateNo=sc.nextInt();

                    System.out.println("Enter vehicle type: ");
                    String vehicleType=sc.next().toUpperCase();

                    System.out.println("Enter owner name: ");
                    String ownerName=sc.next();

                    try {
                        Ticket ticket=parkingLotController.vehicleEntry(parkingLot, vehicleNo, gateNo, vehicleType, ownerName);
                        System.out.println("\nToken no: "+ticket.getTokenNumber()+"\nEntry Time: "+ticket.getEntryTime()+"\nVehicleNumber: "+ticket.getVehicle().getNumber());
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
                else {
                    System.out.println("Enter token number: ");
                    int tokenNumber=sc.nextInt();
                    System.out.println("Enter exit gate number: ");
                    int exitGateNo=sc.nextInt();
                    Bill bill=parkingLotController.vehicleExit(parkingLot,tokenNumber,exitGateNo);
                    System.out.println("Fare amount: "+bill.getFare());
                }
                parkingLotController.displayParkingLot(parkingLot);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

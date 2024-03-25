package ParkingLot.src.Controllers;

import ParkingLot.src.Models.*;
import ParkingLot.src.Services.ExitService;
import ParkingLot.src.Services.TicketGenerator;

import java.util.List;

public class ParkingLotController {

    TicketGenerator ticketGenerator=new TicketGenerator();
    ExitService exitService=new ExitService();
    public ParkingLot createParkingLot(List<Floor> floorList, List<Gate> gateList, List<VechicleType> allowedVehicles, String allocationStrategy, String feeCalculationStrategy) {
        return new ParkingLot(floorList, gateList, allowedVehicles, allocationStrategy, feeCalculationStrategy);
    }

    public Vehicle registerVehicle(ParkingLot pl,VechicleType vechicleType,String numberPlate,String ownerName) throws Exception{
        return pl.registerVehicle(ownerName,numberPlate,vechicleType);
    }

    public Ticket generateTicket(Vehicle vehicle,Gate gate){
        return ticketGenerator.generateTicket(vehicle,gate);
    }

    public Bill exitVehicle(int ticketNumber,Gate gate) throws Exception{
        return exitService.initExitProcess(ticketNumber,gate);
    }

}

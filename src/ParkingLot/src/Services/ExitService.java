package ParkingLot.src.Services;

import ParkingLot.src.Models.Bill;
import ParkingLot.src.Models.Gate;
import ParkingLot.src.Models.Ticket;
import ParkingLot.src.Models.Vehicle;

public class ExitService {
    public Bill initExitProcess(int ticketNumber, Gate exitGate) throws Exception{
        Ticket ticket=Ticket.deregisterTicket(ticketNumber);
        Vehicle vehicle=ticket.getVehicle();
        vehicle.initExitProcess();
        return Bill.generateBill(ticket,exitGate);
    }
}

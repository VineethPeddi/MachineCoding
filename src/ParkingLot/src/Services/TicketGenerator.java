package ParkingLot.src.Services;

import ParkingLot.src.Models.Gate;
import ParkingLot.src.Models.Ticket;
import ParkingLot.src.Models.Vehicle;

public class TicketGenerator {
    public Ticket generateTicket(Vehicle vehicle, Gate gate){

        return new Ticket(vehicle,gate);
    }
}

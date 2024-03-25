package ParkingLot.src.Models;

public class Ticket {
    int id;
    int ticketNumber;
    String entryTime;
    Vehicle vehicle;
    ParkingSlot parkingSlot;
    Floor floor;

    Gate gate;
    Operator operator;
}

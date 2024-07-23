package ParkingLot.src.Exceptions;

public class TicketNotFoundException extends Exception{
    public TicketNotFoundException(){
        super("Ticket Not Found");
    }
}

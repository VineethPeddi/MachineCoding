package ParkingLot.src.Exceptions;

public class TicketExpiredException extends Exception{
    public TicketExpiredException(){
        super("Ticket already expired");
    }
}

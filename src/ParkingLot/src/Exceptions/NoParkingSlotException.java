package ParkingLot.src.Exceptions;

public class NoParkingSlotException extends Exception{
    public NoParkingSlotException(){
        super("No parking slot available at the moment");
    }
}

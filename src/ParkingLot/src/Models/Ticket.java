package ParkingLot.src.Models;
import ParkingLot.src.Exceptions.TicketExpiredException;
import ParkingLot.src.Exceptions.TicketNotFoundException;
import java.time.LocalTime;
import java.util.HashMap;

public class Ticket {

    static private HashMap<Integer,Ticket> ticketsMap=new HashMap<>();
    static private int counter=0;
    int id;
    int ticketNumber;
    String entryTime;

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    Vehicle vehicle;
    ParkingSlot parkingSlot;
    Floor floor;

    Gate gate;
    Operator operator;

    boolean isActive=true;

    public Ticket(Vehicle vehicle,Gate gate){
        counter++;
        ticketNumber=counter;
        entryTime= String.valueOf(LocalTime.now());
        this.vehicle=vehicle;
        parkingSlot=vehicle.getParkingSlot();
        floor=parkingSlot.getFloor();
        this.gate=gate;
        operator=gate.getOperator();
        this.registerTicketInMap(ticketNumber);
    }
    public void registerTicketInMap(int ticketNumber){
        ticketsMap.put(ticketNumber,this);
    }

    public static Ticket deregisterTicket(int ticketNumber) throws TicketNotFoundException,TicketExpiredException {
        Ticket ticket=ticketsMap.get(ticketNumber);
        if(ticket==null)throw new TicketNotFoundException();
        if(!ticket.isActive)throw new TicketExpiredException();
        ticket.isActive=false;
        return ticket;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", ticketNumber=" + ticketNumber +
                ", entryTime='" + entryTime + '\'' +
                ", vehicle=" + vehicle +
                ", parkingSlot=" + parkingSlot +
                ", floor=" + floor +
                ", gate=" + gate +
                ", operator=" + operator +
                ", isActive=" + isActive +
                '}';
    }
}

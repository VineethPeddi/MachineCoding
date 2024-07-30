package ParkingLotV2.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class Ticket {
    int tokenNumber;
    String entryTime;
    Vehicle vehicle;
    int gateNo;

    private static int counter=0;

    private static HashMap<Integer,Ticket> ticketMap=new HashMap<>();
    public Ticket(Vehicle vehicle,int gateNo){
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        entryTime = currentDateTime.format(formatter);
        this.vehicle=vehicle;
        this.gateNo=gateNo;
        counter++;
        tokenNumber =counter;
        ticketMap.put(tokenNumber,this);
    }

    public static Ticket getTicket(int tokenNumber){
        return ticketMap.get(tokenNumber);
    }
    public Vehicle getVehicle(){
        return vehicle;
    }

    public int getTokenNumber() {
        return tokenNumber;
    }

    public String getEntryTime() {
        return entryTime;
    }

    public int getGateNo() {
        return gateNo;
    }

}

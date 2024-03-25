package ParkingLot.src.Models;

import java.time.LocalTime;
import java.util.List;

public class Bill {
    int id;
    Ticket ticket;
    String exitTime;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    int amount;
    Gate exitGate;
    Operator operator;
    List<Payment> paymentList;

    public Bill(Ticket ticket,Gate exitGate){
        this.ticket=ticket;
        this.exitGate=exitGate;
        this.operator=exitGate.getOperator();
    }
    public static Bill generateBill(Ticket ticket,Gate exitGate){
        Bill bill=new Bill(ticket,exitGate);
        bill.exitTime=String.valueOf(LocalTime.now());
        bill.amount=100;
        return bill;
    }
}

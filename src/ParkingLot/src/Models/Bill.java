package ParkingLot.src.Models;

import java.util.List;

public class Bill {
    int id;
    Ticket ticket;
    String exitTime;
    int amount;
    Gate exitGate;
    Operator operator;
    List<Payment> paymentList;
}

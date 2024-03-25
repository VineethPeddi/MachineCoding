package ParkingLot.src.Models;

public class Gate {
    int id;
    int gateNumber;
    Operator operator;
    GateStatus gateStatus;
    GateType gateType;

    public Gate(int gateNumber, Operator operator, GateStatus gateStatus, GateType gateType) {
        this.gateNumber = gateNumber;
        this.operator = operator;
        this.gateStatus = gateStatus;
        this.gateType = gateType;
    }
}

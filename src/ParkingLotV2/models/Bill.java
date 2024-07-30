package ParkingLotV2.models;

public class Bill {
    int exitGateNo;
    String exitTime;
    String vehicleNumber;
    int fare;
    PaymentType paymentType;

    public Bill(String exitTime,int fare,int exitGateNo){
        this.exitTime=exitTime;
        this.fare=fare;
        this.exitGateNo=exitGateNo;
    }

    public int getFare() {
        return fare;
    }
}

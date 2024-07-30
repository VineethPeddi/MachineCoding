package ParkingLotV2.models;

import ParkingLotV2.exceptions.InvalidException;
import ParkingLotV2.exceptions.SlotNotAvailableException;
import ParkingLotV2.exceptions.VehicleNotAllowedException;
import ParkingLotV2.strategies.FareCalculation;
import ParkingLotV2.strategies.FixedFare;
import ParkingLotV2.strategies.VariableFare;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ParkingLot {
    int numFloors;
    int numSlotsPerFloor;
    List<List<ParkingSlot>> parkingSlotsList;
    HashSet<VehicleType> allowedVehicles=new HashSet<>();
    FareCalculationStrategy fareCalculationStrategy;

    FareCalculation fareCalculationObject;
    HashMap<VehicleType,Integer> availableSlotsForVehicleType;

    List<PaymentType> paymentTypes=new ArrayList<>();

    public static ParkingLotBuilder getBuilder(){
        return new ParkingLotBuilder();
    }

    public static class ParkingLotBuilder{
        int numFloors;
        int numSlotsPerFloor;

        List<String> allowedVehicles;
        String fareCalculationStrategy;
        HashMap<String,Integer> availableSlotsForVehicleType;

        List<String> paymentTypes;

        public ParkingLotBuilder setNumFloors(int numFloors){
            this.numFloors=numFloors;
            return this;
        }
        public ParkingLotBuilder setNumSlotsPerFloor(int numSlotsPerFloor){
            this.numSlotsPerFloor=numSlotsPerFloor;
            return this;
        }

        public ParkingLotBuilder setAllowedVehicles(List<String> allowedVehicles) {
            this.allowedVehicles = allowedVehicles;
            return this;
        }

        public ParkingLotBuilder setFareCalculationStrategy(String fareCalculationStrategy) {
            this.fareCalculationStrategy = fareCalculationStrategy;
            return this;
        }

        public ParkingLotBuilder setAvailableSlotsForVehicleType(HashMap<String, Integer> availableSlotsForVehicleType) {
            this.availableSlotsForVehicleType = availableSlotsForVehicleType;
            return this;
        }

        public ParkingLotBuilder setPaymentTypes(List<String> paymentTypes){
            this.paymentTypes=paymentTypes;
            return this;
        }



        public ParkingLot build() throws InvalidException{
            validate();
            List<VehicleType> allowedVehicles=new ArrayList<>(this.allowedVehicles.size());
            for(String vehicle:this.allowedVehicles){
                allowedVehicles.add(getVehicleType(vehicle));
            }
            FareCalculationStrategy fareCalculationStrategy=null;
            for (FareCalculationStrategy strategy:FareCalculationStrategy.values()){
                if(strategy.toString().equals(this.fareCalculationStrategy)){
                    fareCalculationStrategy=strategy;
                }
            }

            List<PaymentType> paymentTypeList=new ArrayList<>();
            for(String paymentType:paymentTypes){
                boolean found=false;
                for (PaymentType type:PaymentType.values()){
                    if(type.toString().equals(paymentType)){
                        paymentTypeList.add(type);
                        found=true;break;
                    }
                }
                if(!found)throw new InvalidException("Payment Type: " +paymentType+" not supported");
            }
            return new ParkingLot(numFloors,numSlotsPerFloor,allowedVehicles,fareCalculationStrategy,paymentTypeList,getAvailableSlotsForVehicleType());
        }
        public void validate() throws InvalidException{
            if(numFloors<0)throw new InvalidException("Number of floors cannot be less than 0");
            if(numSlotsPerFloor<0) throw new InvalidException("Number of slots in a floor cannot be less than 0");
            boolean found=false;
            for(FareCalculationStrategy strategy:FareCalculationStrategy.values()){
                if (strategy.toString().equals(fareCalculationStrategy)){
                    found=true;
                    break;
                }
            }
            if(!found)throw new InvalidException("Invalid Fare calculation strategy");
            for(String vehicle:allowedVehicles){
                getVehicleType(vehicle);
            }

        }

        public HashMap<VehicleType,Integer> getAvailableSlotsForVehicleType() throws InvalidException{
            int totalAvailableSlots=0;
            HashMap<VehicleType,Integer> availableSlotsForVehicleMap=new HashMap<>();
            for(Map.Entry<String,Integer> entry:availableSlotsForVehicleType.entrySet()){
                String key=entry.getKey();
                VehicleType vehicleType=getVehicleType(key);
                int value=entry.getValue();
                totalAvailableSlots+=value;
                availableSlotsForVehicleMap.put(vehicleType,value);
            }
            if(totalAvailableSlots!=numSlotsPerFloor)throw new InvalidException("Mismatch in number of available slots");
            return availableSlotsForVehicleMap;
        }
    }



    public static VehicleType getVehicleType(String vehicle) throws InvalidException{
        boolean vehicleFound=false;
        VehicleType vehicleType=null;
        for(VehicleType type:VehicleType.values()){
            if(type.toString().equals(vehicle)){
                vehicleType=type;
                vehicleFound=true;break;
            }
        }
        if(!vehicleFound)throw new InvalidException("Vehicle "+vehicle+" is not supported");
        return vehicleType;
    }


    public ParkingLot(int numFloors,int numSlotsPerFloor,List<VehicleType> allowedVehicles,FareCalculationStrategy fareCalculationStrategy,List<PaymentType> paymentTypes,HashMap<VehicleType, Integer> availableSlotsForVehicleType){
        this.numFloors=numFloors;
        this.fareCalculationStrategy=fareCalculationStrategy;
        this.numSlotsPerFloor=numSlotsPerFloor;
        this.allowedVehicles.addAll(allowedVehicles);
        this.paymentTypes=paymentTypes;
        this.availableSlotsForVehicleType=availableSlotsForVehicleType;
        fareCalculationObject=getFareCalculationObject();
        initializeParkingSlots();
    }

    public FareCalculation getFareCalculationObject() {
        if(fareCalculationStrategy==FareCalculationStrategy.FIXED)return new FixedFare();
        return new VariableFare();
    }

    public void initializeParkingSlots(){
        parkingSlotsList=new ArrayList<>(numFloors);
        for(int i=0;i<numFloors;i++){
            ArrayList<ParkingSlot> parkingSlots=new ArrayList<>(this.numSlotsPerFloor);
            int slotNumber=1;
            for(VehicleType vehicleType:allowedVehicles){
                int availableSlots=availableSlotsForVehicleType.get(vehicleType);
                while(availableSlots-->0){
                    parkingSlots.add(new ParkingSlot(vehicleType,slotNumber,i));
                }
            }
            parkingSlotsList.add(parkingSlots);
        }
    }

    public ParkingSlot getAvailableParkingSlot(VehicleType vehicleType){
        for(List<ParkingSlot> parkingSlotsInFloor:parkingSlotsList){
            for(ParkingSlot parkingSlot:parkingSlotsInFloor){
                if(parkingSlot.status==ParkingStatus.AVAILABLE && parkingSlot.vehicleType==vehicleType){
                    return parkingSlot;
                }
            }
        }
        return null;
    }

    public boolean isVehicleTypeAllowed(VehicleType vehicleType){
        return allowedVehicles.contains(vehicleType);
    }

    public Ticket vehicleEntry(String vehicleNo,int gateNo,String vehicleType,String ownerName) throws InvalidException, VehicleNotAllowedException, SlotNotAvailableException {
        VehicleType type=getVehicleType(vehicleType);
        if(!isVehicleTypeAllowed(type))throw new VehicleNotAllowedException("This parking lot does not allow "+vehicleType);
        ParkingSlot parkingSlot=getAvailableParkingSlot(type);
        if(parkingSlot==null)throw new SlotNotAvailableException("Currently, no slot is available for "+vehicleType+"s");
        Vehicle vehicle=new Vehicle(vehicleNo,type,ownerName,parkingSlot);
        return new Ticket(vehicle,gateNo);
    }

    public Bill vehicleExit(int tokenNumber,int exitGateNo){
        Ticket ticket=Ticket.getTicket(tokenNumber);
        Vehicle vehicle=ticket.getVehicle();
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String exitTime = currentDateTime.format(formatter);
        int fare=fareCalculationObject.calculateFare(vehicle.type,ticket.entryTime,exitTime);
        vehicle.deAllocate();
        return new Bill(exitTime,fare,exitGateNo);
    }

    public void displayParkingLot(){
        for (List<ParkingSlot> parkingSlotsInFloor:parkingSlotsList){
            for(ParkingSlot parkingSlot:parkingSlotsInFloor){
                if(parkingSlot.status==ParkingStatus.AVAILABLE) System.out.print(" X ");
                else System.out.print(parkingSlot.vehicleType);
            }
            System.out.println();
        }
    }
}

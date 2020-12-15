package domain;


import java.io.Serializable;

public class Baggage implements Serializable {
    private int id;
    private String FlightID;
    private String FlightCompany;
    private String ActuallyArrive;
    private String BaggagePos;

    public String getActuallyArrive() {
        return ActuallyArrive;
    }

    public void setActuallyArrive(String actuallyArrive) {
        ActuallyArrive = actuallyArrive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFlightID() {
        return FlightID;
    }

    public void setFlightID(String flightID) {
        FlightID = flightID;
    }

    public String getFlightCompany() {
        return FlightCompany;
    }

    public void setFlightCompany(String flightCompany) {
        FlightCompany = flightCompany;
    }

    public String getBaggagePos() {
        return BaggagePos;
    }

    public void setBaggagePos(String baggagePos) {
        BaggagePos = baggagePos;
    }

    @Override
    public String toString() {
        return "{\"FlightID\": \"" + FlightID + "\", " +
                "\"FlightCompany\": \"" + FlightCompany + "\"," +
                "\"ActuallyArrive\": \"" + ActuallyArrive + "\", " +
                "\"BaggagePos\": \"" + BaggagePos + "\"}";
    }
}

package zhm.core.domain;

import java.util.Date;

public class Flight {
    private int id;
    private String FlightID;
    private String FlightCompany;
    private String BeginPos;
    private String DestPos;
    private String Stopover;
    private String PlaneGo;
    private String PlaneArrive;
    private String ActuallyArrive;
    private String FlightBuilding;
    private String GoDoor;
    private String ReadyPos;
    private String FlightState;

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

    public String getBeginPos() {
        return BeginPos;
    }

    public void setBeginPos(String beginPos) {
        BeginPos = beginPos;
    }

    public String getDestPos() {
        return DestPos;
    }

    public void setDestPos(String destPos) {
        DestPos = destPos;
    }

    public String getStopover() {
        return Stopover;
    }

    public void setStopover(String stopover) {
        Stopover = stopover;
    }

    public String getPlaneGo() {
        return PlaneGo;
    }

    public void setPlaneGo(String planeGo) {
        PlaneGo = planeGo;
    }

    public String getPlaneArrive() {
        return PlaneArrive;
    }

    public void setPlaneArrive(String planeArrive) {
        PlaneArrive = planeArrive;
    }

    public String getActuallyArrive() {
        return ActuallyArrive;
    }

    public void setActuallyArrive(String actuallyArrive) {
        ActuallyArrive = actuallyArrive;
    }

    public String getFlightBuilding() {
        return FlightBuilding;
    }

    public void setFlightBuilding(String flightBuilding) {
        FlightBuilding = flightBuilding;
    }

    public String getGoDoor() {
        return GoDoor;
    }

    public void setGoDoor(String goDoor) {
        GoDoor = goDoor;
    }

    public String getReadyPos() {
        return ReadyPos;
    }

    public void setReadyPos(String readyPos) {
        ReadyPos = readyPos;
    }

    public String getFlightState() {
        return FlightState;
    }

    public void setFlightState(String flightState) {
        FlightState = flightState;
    }

    @Override
    public String toString() {
        return "{" +
                "\"FlightID\": \"" + FlightID + "\", " +
                "\"FlightCompany\": \"" + FlightCompany + "\", " +
                "\"BeginPos\": \"" + BeginPos + "\", " +
                "\"DestPos\": \"" + DestPos + "\", " +
                "\"Stopover\": \"" + Stopover + "\", " +
                "\"PlaneGo\": \"" + PlaneGo + "\", " +
                "\"PlaneArrive\": \"" + PlaneArrive + "\", " +
                "\"ActuallyArrive\": \"" + ActuallyArrive + "\", " +
                "\"FlightBuilding\": \"" + FlightBuilding + "\", " +
                "\"GoDoor\": \"" + GoDoor + "\", " +
                "\"ReadyPos\": \"" + ReadyPos + "\", " +
                "\"FlightState\": \"" + FlightState + "\"}";
    }
}

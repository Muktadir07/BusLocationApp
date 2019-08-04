package com.example.buslocation;

public class BusInfo {

    private String busID;
    private String busName;
    private String busPosition;
    private String araival_or_depature;

    public void setBusID(String busID) {
        this.busID = busID;
    }

    public BusInfo(String busID, String busName, String busPosition, String araival_or_depature) {
        this.busID = busID;
        this.busName = busName;
        this.busPosition = busPosition;
        this.araival_or_depature = araival_or_depature;
    }



    public BusInfo(String busName, String busPosition, String araival_or_depature) {
        this.busName = busName;
        this.busPosition = busPosition;
        this.araival_or_depature = araival_or_depature;
    }

    public String getBusName() {
        return busName;
    }

    public String getBusPosition() {
        return busPosition;
    }

    public String getAraival_or_depature() {
        return araival_or_depature;
    }

    public String getBusID() {
        return busID;
    }
}

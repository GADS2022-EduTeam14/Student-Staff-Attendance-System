package com.andela.eduteam14.android_app.core.data.firebase.models;

public class Organization {
    private String Name, Location, Address;

    public Organization () {

    }

    public Organization(String name, String location, String address) {
        Name = name;
        Location = location;
        Address = address;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}

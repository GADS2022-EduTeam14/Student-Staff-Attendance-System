package com.andela.eduteam14.android_app.core.data.firebase.models;

public class School {

    private Integer SchoolCode, SchoolLocation, OrganizationID;
    private String SchoolName, Address;

    public School (){

    }

    public School(Integer schoolCode, Integer schoolLocation, Integer organizationID, String schoolName, String address) {
        SchoolCode = schoolCode;
        SchoolLocation = schoolLocation;
        OrganizationID = organizationID;
        SchoolName = schoolName;
        Address = address;
    }

    public Integer getSchoolCode() {
        return SchoolCode;
    }

    public void setSchoolCode(Integer schoolCode) {
        SchoolCode = schoolCode;
    }

    public Integer getSchoolLocation() {
        return SchoolLocation;
    }

    public void setSchoolLocation(Integer schoolLocation) {
        SchoolLocation = schoolLocation;
    }

    public Integer getOrganizationID() {
        return OrganizationID;
    }

    public void setOrganizationID(Integer organizationID) {
        OrganizationID = organizationID;
    }

    public String getSchoolName() {
        return SchoolName;
    }

    public void setSchoolName(String schoolName) {
        SchoolName = schoolName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }



}

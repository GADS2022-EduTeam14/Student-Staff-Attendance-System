package com.andela.eduteam14.android_app.core.data.firebase.models;

public class OrganizationReport {
    private int Organization_id,students_present_male,students_present_female,students_late_male,students_late_female, students_absent_male,students_absent_female, teahcers_present_male,teahcers_present_female,teahcers_late_male,teahcers_late_female, teahcers_absent_male, teahcers_absent_female ;
    private String Date;


    public OrganizationReport () {

    }

    public OrganizationReport(int organization_id, int students_present_male, int students_present_female, int students_late_male, int students_late_female, int students_absent_male, int students_absent_female, int teahcers_present_male, int teahcers_present_female, int teahcers_late_male, int teahcers_late_female, int teahcers_absent_male, int teahcers_absent_female, String date) {
        Organization_id = organization_id;
        this.students_present_male = students_present_male;
        this.students_present_female = students_present_female;
        this.students_late_male = students_late_male;
        this.students_late_female = students_late_female;
        this.students_absent_male = students_absent_male;
        this.students_absent_female = students_absent_female;
        this.teahcers_present_male = teahcers_present_male;
        this.teahcers_present_female = teahcers_present_female;
        this.teahcers_late_male = teahcers_late_male;
        this.teahcers_late_female = teahcers_late_female;
        this.teahcers_absent_male = teahcers_absent_male;
        this.teahcers_absent_female = teahcers_absent_female;
        Date = date;
    }

    public int getOrganization_id() {
        return Organization_id;
    }

    public void setOrganization_id(int organization_id) {
        Organization_id = organization_id;
    }

    public int getStudents_present_male() {
        return students_present_male;
    }

    public void setStudents_present_male(int students_present_male) {
        this.students_present_male = students_present_male;
    }

    public int getStudents_present_female() {
        return students_present_female;
    }

    public void setStudents_present_female(int students_present_female) {
        this.students_present_female = students_present_female;
    }

    public int getStudents_late_male() {
        return students_late_male;
    }

    public void setStudents_late_male(int students_late_male) {
        this.students_late_male = students_late_male;
    }

    public int getStudents_late_female() {
        return students_late_female;
    }

    public void setStudents_late_female(int students_late_female) {
        this.students_late_female = students_late_female;
    }

    public int getStudents_absent_male() {
        return students_absent_male;
    }

    public void setStudents_absent_male(int students_absent_male) {
        this.students_absent_male = students_absent_male;
    }

    public int getStudents_absent_female() {
        return students_absent_female;
    }

    public void setStudents_absent_female(int students_absent_female) {
        this.students_absent_female = students_absent_female;
    }

    public int getTeahcers_present_male() {
        return teahcers_present_male;
    }

    public void setTeahcers_present_male(int teahcers_present_male) {
        this.teahcers_present_male = teahcers_present_male;
    }

    public int getTeahcers_present_female() {
        return teahcers_present_female;
    }

    public void setTeahcers_present_female(int teahcers_present_female) {
        this.teahcers_present_female = teahcers_present_female;
    }

    public int getTeahcers_late_male() {
        return teahcers_late_male;
    }

    public void setTeahcers_late_male(int teahcers_late_male) {
        this.teahcers_late_male = teahcers_late_male;
    }

    public int getTeahcers_late_female() {
        return teahcers_late_female;
    }

    public void setTeahcers_late_female(int teahcers_late_female) {
        this.teahcers_late_female = teahcers_late_female;
    }

    public int getTeahcers_absent_male() {
        return teahcers_absent_male;
    }

    public void setTeahcers_absent_male(int teahcers_absent_male) {
        this.teahcers_absent_male = teahcers_absent_male;
    }

    public int getTeahcers_absent_female() {
        return teahcers_absent_female;
    }

    public void setTeahcers_absent_female(int teahcers_absent_female) {
        this.teahcers_absent_female = teahcers_absent_female;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}

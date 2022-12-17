package com;

public class person extends data{
    private String name;
    private String sex;
    private String ID;
    private String startDay;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }
//    public person(int year,int month,int day){
//        this.setStartDay(new String(this.setYear(year)) + new String(this.setMonth(month)) + new String(this.setDay(day)));
//    }
}

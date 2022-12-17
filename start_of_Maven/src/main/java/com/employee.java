package com;

class employee extends person{
    private String gNumber;
    private String telNumber;
    private String kWhere;
    private String  money;

    public String getgNumber() {
        return gNumber;
    }

    public void setgNumber(String gNumber) {
        this.gNumber = gNumber;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getkWhere() {
        return kWhere;
    }

    public void setkWhere(String kWhere) {
        this.kWhere = kWhere;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public  employee(String name, String sex, String ID, String startDay){
        this.setName(name);
        this.setSex(sex);
        this.setID(ID);
        this.setStartDay(startDay);
    }

    @Override
    public String toString() {
        return this.getName() + ',' +this.getSex() +  ',' +this.getID() + ',' +this.getStartDay() +  ',' +this.getgNumber() + ',' +this.getTelNumber()
                + ',' + this.getkWhere() + ',' + this.getMoney();
    }
}

package com;

import java.util.Calendar;

public class ces {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(calendar.YEAR);
        System.out.println(year);
        System.out.println("下一个断点");
        System.out.println("第二个断点");
    }
}

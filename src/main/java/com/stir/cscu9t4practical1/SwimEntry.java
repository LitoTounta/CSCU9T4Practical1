package com.stir.cscu9t4practical1;

import java.util.Calendar;

public class SwimEntry extends Entry {
    private String where;
    //public SwimEntry(String alice, int i, int i1, int i2, int i3, int i4, int i5, int i6, String outdoors) {
    //}
    public SwimEntry(String n, int d, int m, int y, int h, int min, int s, float dist, String wh) {
        //super();
        name = n;
        Calendar inst = Calendar.getInstance();
        inst.set(y,m-1,d,h,min,s);
        dateAndTime = inst;
        distance = dist;
        where = wh;
    }

    public String getWhere(){
        return where;
    }
}

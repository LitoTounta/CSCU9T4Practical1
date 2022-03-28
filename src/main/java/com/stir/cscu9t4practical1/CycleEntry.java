package com.stir.cscu9t4practical1;

import java.util.Calendar;

public class CycleEntry extends Entry {
    private String terrain;
    private String tempo;
    //public CycleEntry(String alice, int i, int i1, int i2, int i3, int i4, int i5, int i6, String asphalt, String moderate) {
    //}
    public CycleEntry(String n, int d, int m, int y, int h, int min, int s, float dist, String ter, String tem) {
        //super();
        name = n;
        Calendar inst = Calendar.getInstance();
        inst.set(y,m-1,d,h,min,s);
        dateAndTime = inst;
        distance = dist;
        terrain = ter;
        tempo = tem;
    }

    public String getTerrain(){
        return terrain;
    }
    public String getTempo(){
        return tempo;
    }
}


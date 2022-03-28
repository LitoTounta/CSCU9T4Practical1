package com.stir.cscu9t4practical1;

import java.util.Calendar;

/**public class SprintEntry extends Entry {
    public SprintEntry(String alice, int i, int i1, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        super();
    }
}
*/
//import com.stir.cscu9t4practical1.Entry;

public class SprintEntry extends Entry {
    private int repetitions;
    private int recoveries;

    public SprintEntry(String n, int d, int m, int y, int h, int min, int s, float dist, int rep, int rec) {
        name = n;
        Calendar inst = Calendar.getInstance();
        inst.set(y,m-1,d,h,min,s);
        dateAndTime = inst;
        distance = dist;
        repetitions = rep;
        recoveries = rec;
    }

    public int getRepetitions(){
        return repetitions;
    }

    public int getRecovery() {
        return recoveries;
    }

}
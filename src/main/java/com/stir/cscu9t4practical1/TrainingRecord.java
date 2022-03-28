// An implementation of a Training Record as an ArrayList
package com.stir.cscu9t4practical1;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;


public class TrainingRecord {
    private List<Entry> tr;

    public TrainingRecord() {
        tr = new ArrayList<Entry>();
    } //constructor

    // add a record to the list
    public void addEntry(Entry e) {
        //check if it is unique before adding
        tr.add(e);

    } // addClass

    // look up the entry of a given day and month
    public String lookupEntry(int d, int m, int y) {
        ListIterator<Entry> iter = tr.listIterator();
        String result = "No entries found";
        while (iter.hasNext()) {
            Entry current = iter.next();
            if (current.getDay() == d && current.getMonth() == m && current.getYear() == y)
                result = current.getEntry();
        }
        return result;
    } // lookupEntry

    //Task 2
    public String lookupallEntry(int d, int m, int y) {
        String result = "";
        ListIterator<Entry> iter = tr.listIterator();
        while (iter.hasNext()) {
            Entry current = iter.next();
            if (current.getDay() == d && current.getMonth() == m && current.getYear() == y) {
                result = result + current.getEntry();
            }
        }
        if(result != ""){
            return result;
        }
        else{
            result = "Sorry couldn't find anything for this date";
            return result;
        }
    }


    // Count the number of entries
    public int getNumberOfEntries() {
        return tr.size();
    }

    // Clear all entries
    public void clearAllEntries() {
        tr.clear();
    }


    //Check if the athlete is unique
    public boolean isUnique(String name, int d, int m, int y) {
        boolean bool = true;
        ListIterator<Entry> iter = tr.listIterator();
        while (iter.hasNext()) {
            Entry current = iter.next();
            if (current.getName().equals(name) && current.getDay() == d && current.getMonth() == m && current.getYear() == y) {
                bool = false;
                break;
            }
        }
        return bool;
    }


    //Remove athlete
    public void removeAthlete(String name, int d, int m, int y) {
        ListIterator<Entry> iter = tr.listIterator();
        while (iter.hasNext()) {
            Entry current = iter.next();
            if (current.getName().equals(name) && current.getDay() == d && current.getMonth() == m && current.getYear() == y) {
                iter.remove();
            }
        }
    }


} // TrainingRecord
// An implementation of a Training Record as an ArrayList
package com.stir.cscu9t4practical1;




import java.util.*;


public class TrainingRecord {
    private List<Entry> tr;
    
    public TrainingRecord() {
        tr = new ArrayList<Entry>();
    } //constructor
    
    // add a record to the list
   public void addEntry(Entry e){
       tr.add(e);

   } // addClass
   
   // look up the entry of a given day and month
   public String lookupEntry (int d, int m, int y) {
       ListIterator<Entry> iter = tr.listIterator();
       String result = "No entries found";
       while (iter.hasNext()) {
          Entry current = iter.next();
          if (current.getDay()==d && current.getMonth()==m && current.getYear()==y) 
             result = current.getEntry();
            }
       return result;
   } // lookupEntry

    //Task 2
    public String lookupallEntry (int d, int m, int y){
        String result = "";
        ListIterator<Entry> iter = tr.listIterator();
        while (iter.hasNext()){
            Entry current = iter.next();
            if (current.getDay()==d && current.getMonth()==m && current.getYear()==y);
            result = result + current.getEntry();
        }
        return result;
    }



    //here is going to be the method for findAllByDateEntry
    //public String findAllByDateEntry(...);
    //I need to implement a method from task 2, and call this method 2 for my task 3 method

   
   // Count the number of entries
   public int getNumberOfEntries(){
       return tr.size();
   }
   // Clear all entries
   public void clearAllEntries(){
       tr.clear();
   }
   
} // TrainingRecord
// GUI and main program for the Training Record
package com.stir.cscu9t4practical1;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;

public class TrainingRecordGUI extends JFrame implements ActionListener {


    private JTextField name = new JTextField(20);
    private JTextField day = new JTextField(2);
    private JTextField month = new JTextField(2);
    private JTextField year = new JTextField(4);
    private JTextField hours = new JTextField(2);
    private JTextField mins = new JTextField(2);
    private JTextField secs = new JTextField(2);
    private JTextField dist = new JTextField(4);
    private JTextField reps = new JTextField(4);
    private JTextField rec = new JTextField(4);
    private JTextField ter = new JTextField(10);
    private JTextField tem = new JTextField(12);
    private JTextField wh = new JTextField(12);
    private JLabel labn = new JLabel(" Name:");
    private JLabel labd = new JLabel(" Day:");
    private JLabel labm = new JLabel(" Month:");
    private JLabel laby = new JLabel(" Year:");
    private JLabel labh = new JLabel(" Hours:");
    private JLabel labmm = new JLabel(" Mins:");
    private JLabel labs = new JLabel(" Secs:");
    private JLabel labdist = new JLabel(" Distance (km):");
    private JLabel labr = new JLabel("Reps:");
    private JLabel labrec = new JLabel("Recoveries:");
    private JLabel labt = new JLabel("Terrain:");
    private JLabel labtem = new JLabel("Tempo:");
    private JLabel labw = new JLabel("Where:");
    private JButton addR = new JButton("Add");
    private JButton lookUpByDate = new JButton("Look Up");
    //find all by date button
    private JButton findAllByDate = new JButton("Find All By Date");

    //Sprint button
    private JButton sprint = new JButton("Sprint");

    //Cycle button
    private JButton cycle = new JButton("Cycle");

    //Swim button
    private JButton swim = new JButton("Swim");

    //Remove button;
    private JButton rem = new JButton("Remove");

    private TrainingRecord myAthletes = new TrainingRecord();

    private JTextArea outputArea = new JTextArea(5, 50);

    public static void main(String[] args) {
        TrainingRecordGUI applic = new TrainingRecordGUI();
    } // main

    // set up the GUI 
    public TrainingRecordGUI() {
        super("Training Record");
        setLayout(new FlowLayout());
        add(labn);
        add(name);
        name.setEditable(true);
        add(labd);
        add(day);
        day.setEditable(true);
        add(labm);
        add(month);
        month.setEditable(true);
        add(laby);
        add(year);
        year.setEditable(true);
        add(labh);
        add(hours);
        hours.setEditable(true);
        add(labmm);
        add(mins);
        mins.setEditable(true);
        add(labs);
        add(secs);
        secs.setEditable(true);
        add(labdist);
        add(dist);
        dist.setEditable(true);
        add(labr);
        add(reps);
        reps.setEditable(true);
        add(labrec);
        add(rec);
        rec.setEditable(true);
        add(labt);
        add(ter);
        ter.setEditable(true);
        add(labtem);
        add(tem);
        tem.setEditable(true);
        add(labw);
        add(wh);
        wh.setEditable(true);


        add(addR);
        addR.addActionListener(this);
        add(lookUpByDate);
        lookUpByDate.addActionListener(this);

        //find all by date button
        add(findAllByDate);
        findAllByDate.addActionListener(this);

        //sprint entry button
        add(sprint);
        sprint.addActionListener(this);

        //cycle entry button
        add(cycle);
        cycle.addActionListener(this);

        //swim entry button
        add(swim);
        swim.addActionListener(this);

        //remove entry button
        add(rem);
        rem.addActionListener(this);

        add(outputArea);
        outputArea.setEditable(false);
        setSize(720, 250);
        setVisible(true);
        blankDisplay();

        // To save typing in new entries while testing, uncomment
        // the following lines (or add your own test cases)

    } // constructor

    // listen for and respond to GUI events 
    public void actionPerformed(ActionEvent event) {
        String message = "";
        if (event.getSource() == addR) {
            message = addEntry("generic");
        }
        if (event.getSource() == lookUpByDate) {
            message = lookupEntry();
        }
        //Find all by date button
        if (event.getSource() == findAllByDate) {
            message = findAllByDateEntry();
        }

        //Sprint button
        if (event.getSource() == sprint){
            message = SprintEn("sprint");
        }

        //Cycle button
        if (event.getSource() == cycle){
            message = CycleEn("cycle");
        }

        //Swim button
        if (event.getSource() == swim){
            message = SwimEn("swim");
        }

        //Remove Button
        if (event.getSource() == rem){
            RemoveEn();
        }


        outputArea.setText(message);
        blankDisplay();
    } // actionPerformed

    public String addEntry(String what) {
        String message ="";
        String n = name.getText();
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        float km = java.lang.Float.parseFloat(dist.getText());
        int h = Integer.parseInt(hours.getText());
        int mm = Integer.parseInt(mins.getText());
        int s = Integer.parseInt(secs.getText());

        Entry e = new Entry(n, d, m, y, h, mm, s, km);
        boolean check = myAthletes.isUnique(n, d, m ,y);
        if(check==true){
            myAthletes.addEntry(e);
            message = "Record added\n";
            System.out.println("Adding "+what+" entry to the records");
        }
        else{
            message = "Already exists";
        }
        //int num = myAthletes.getNumberOfEntries();
        //System.out.println(num);
        return message;
    }

    public void RemoveEn(){
        String message ="Removing Athlete";
        String n = name.getText();
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        myAthletes.removeAthlete(n, d, m, y);

    }

    //Sprint entry
    public String SprintEn(String what){
        String message = "Record added\n";
        System.out.println("Adding "+what+" entry to the records");
        String n = name.getText();
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        float km = java.lang.Float.parseFloat(dist.getText());
        int h = Integer.parseInt(hours.getText());
        int mm = Integer.parseInt(mins.getText());
        int s = Integer.parseInt(secs.getText());
        int r = Integer.parseInt(reps.getText());
        int recov = Integer.parseInt(rec.getText());

        Entry e = new SprintEntry(n, d, m, y, h, mm, s, km, r, recov);

        myAthletes.addEntry(e);
        return message;
    }

    //Cycle Entry
    public String CycleEn(String what){
        String message = "Record added\n";
        System.out.println("Adding "+what+" entry to the records");
        String n = name.getText();
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        float km = java.lang.Float.parseFloat(dist.getText());
        int h = Integer.parseInt(hours.getText());
        int mm = Integer.parseInt(mins.getText());
        int s = Integer.parseInt(secs.getText());
        String t = ter.getText();
        String te = tem.getText();
        Entry e = new CycleEntry(n, d, m, y, h, mm, s, km, t, te);
        myAthletes.addEntry(e);
        return message;
    }


    //Swim Entry
    //Cycle Entry
    public String SwimEn(String what){
        String message = "Record added\n";
        System.out.println("Adding "+what+" entry to the records");
        String n = name.getText();
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        float km = java.lang.Float.parseFloat(dist.getText());
        int h = Integer.parseInt(hours.getText());
        int mm = Integer.parseInt(mins.getText());
        int s = Integer.parseInt(secs.getText());
        String w = wh.getText();
        Entry e = new SwimEntry(n, d, m, y, h, mm, s, km, w);
        myAthletes.addEntry(e);
        return message;
    }

    public String lookupEntry() {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");
        String message = myAthletes.lookupEntry(d, m, y);
        return message;
    }

    //Find all by date button
    public String findAllByDateEntry() {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up for records...");
        String message = myAthletes.lookupallEntry(d, m, y);
        return message;
    }


    public void blankDisplay() {
        name.setText("");
        day.setText("");
        month.setText("");
        year.setText("");
        hours.setText("");
        mins.setText("");
        secs.setText("");
        dist.setText("");
        reps.setText("");
        rec.setText("");
        tem.setText("");
        ter.setText("");
        wh.setText("");

    }// blankDisplay
    // Fills the input fields on the display for testing purposes only
    public void fillDisplay(Entry ent) {
        name.setText(ent.getName());
        day.setText(String.valueOf(ent.getDay()));
        month.setText(String.valueOf(ent.getMonth()));
        year.setText(String.valueOf(ent.getYear()));
        hours.setText(String.valueOf(ent.getHour()));
        mins.setText(String.valueOf(ent.getMin()));
        secs.setText(String.valueOf(ent.getSec()));
        dist.setText(String.valueOf(ent.getDistance()));
    }

} // TrainingRecordGUI


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servei;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.primefaces.util.ArrayUtils;

/**
 *
 * @author nasty
 */
@Named
@SessionScoped
public class Tornservei implements Serializable {

    private List<Torn> torns;
    private List<Torn> tornMod;
    private int any=Calendar.getInstance().get(Calendar.YEAR);
    private int diaTornComença;

    @PostConstruct
    public void init() {
        torns = new ArrayList(6);
        tornMod = new ArrayList(6);
        torns.add(new Torn(new char[]{'O', 'O', 'O', 'O', 'X', 'X', 'R', 'R', 'R', 'R', 'R', 'X', 'X', 'M', 'M', 'T', 'T', 'N', 'N', 'N', 'X', 'X', 'M', 'M', 'T', 'T', 'T', 'N', 'N', 'X', 'X', 'M', 'M', 'M', 'T', 'T', 'N', 'N', 'X', 'X', 'X', 'O'}));
        torns.add(new Torn(new char[]{'R', 'R', 'R', 'R', 'X', 'X', 'M', 'M', 'T', 'T', 'N', 'N', 'N', 'X', 'X', 'M', 'M', 'T', 'T', 'T', 'N', 'N', 'X', 'X', 'M', 'M', 'M', 'T', 'T', 'N', 'N', 'X', 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'X', 'X', 'R'}));
        torns.add(new Torn(new char[]{'X', 'M', 'M', 'T', 'T', 'T', 'N', 'N', 'X', 'X', 'M', 'M', 'M', 'T', 'T', 'N', 'N', 'X', 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'X', 'X', 'R', 'R', 'R', 'R', 'R', 'X', 'X', 'M', 'M', 'T', 'T', 'N', 'N', 'N', 'X'}));
        torns.add(new Torn(new char[]{'N', 'X', 'X', 'M', 'M', 'M', 'T', 'T', 'N', 'N', 'X', 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'X', 'X', 'R', 'R', 'R', 'R', 'R', 'X', 'X', 'M', 'M', 'T', 'T', 'N', 'N', 'N', 'X', 'X', 'M', 'M', 'T', 'T', 'T', 'N'}));
        torns.add(new Torn(new char[]{'T', 'N', 'N', 'X', 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'X', 'X', 'R', 'R', 'R', 'R', 'R', 'X', 'X', 'M', 'M', 'T', 'T', 'N', 'N', 'N', 'X', 'X', 'M', 'M', 'T', 'T', 'T', 'N', 'N', 'X', 'X', 'M', 'M', 'M', 'T'}));
        torns.add(new Torn(new char[]{'M', 'T', 'T', 'N', 'N', 'N', 'X', 'X', 'M', 'M', 'T', 'T', 'T', 'N', 'N', 'X', 'X', 'M', 'M', 'M', 'T', 'T', 'N', 'N', 'X', 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'X', 'X', 'R', 'R', 'R', 'R', 'R', 'X', 'X', 'M'}));
        torn1(any);
    }

    public List<Torn> getTorns() {
        return torns;
    }

    public List<Torn> getTornMod() {
        return tornMod;
    }

    public int getAny() {
        return any;
    }

    public void setAny(int any) {
        this.any = any;
        init();
    }    

    public String torn1(int any) {
        GregorianCalendar anyInicial = new GregorianCalendar(2008, 0, 1);
        GregorianCalendar anyFinal = new GregorianCalendar();
        GregorianCalendar anyTrespas = new GregorianCalendar();

        anyFinal.set(any, 0, 1);
        //anyFinal.set(2017, 0, 1);
        long dies = (anyFinal.getTimeInMillis() - anyInicial.getTimeInMillis()) / (1000 * 3600 * 24);

        diaTornComença = (int) dies % 42;
        
        char[] tornA = torns.get(0).getSeq();
        char[] tornA1 = Arrays.copyOfRange(tornA, diaTornComença, 42);
        char[] tornA2 = Arrays.copyOfRange(tornA, 0, diaTornComença);

        StringBuilder sb1 = new StringBuilder(42);
        sb1.append(tornA1);
        sb1.append(tornA2);

        tornA = sb1.toString().toCharArray();

        tornMod.add(new Torn(tornA));
        
        char[] tornB = torns.get(1).getSeq();
        char[] tornB1 = Arrays.copyOfRange(tornB, diaTornComença, 42);
        char[] tornB2 = Arrays.copyOfRange(tornB, 0, diaTornComença);
        
        StringBuilder sb2 = new StringBuilder(42);
        sb2.append(tornB1);
        sb2.append(tornB2);

        tornB = sb2.toString().toCharArray();

        tornMod.add(new Torn(tornB));
        
        char[] tornC = torns.get(2).getSeq();
        char[] tornC1 = Arrays.copyOfRange(tornC, diaTornComença, 42);
        char[] tornC2 = Arrays.copyOfRange(tornC, 0, diaTornComença);

        StringBuilder sb3 = new StringBuilder(42);
        sb3.append(tornC1);
        sb3.append(tornC2);

        tornC = sb3.toString().toCharArray();

        tornMod.add(new Torn(tornC));
        
        char[] tornD = torns.get(3).getSeq();
        char[] tornD1 = Arrays.copyOfRange(tornD, diaTornComença, 42);
        char[] tornD2 = Arrays.copyOfRange(tornD, 0, diaTornComença);

        StringBuilder sb4 = new StringBuilder(42);
        sb4.append(tornD1);
        sb4.append(tornD2);

        tornD = sb4.toString().toCharArray();

        tornMod.add(new Torn(tornD));
        
        char[] tornE = torns.get(4).getSeq();
        char[] tornE1 = Arrays.copyOfRange(tornE, diaTornComença, 42);
        char[] tornE2 = Arrays.copyOfRange(tornE, 0, diaTornComença);

        StringBuilder sb5 = new StringBuilder(42);
        sb5.append(tornE1);
        sb5.append(tornE2);

        tornE = sb5.toString().toCharArray();

        tornMod.add(new Torn(tornE));
        
        char[] tornF = torns.get(5).getSeq();
        char[] tornF1 = Arrays.copyOfRange(tornF, diaTornComença, 42);
        char[] tornF2 = Arrays.copyOfRange(tornF, 0, diaTornComença);

        StringBuilder sb6 = new StringBuilder(42);
        sb6.append(tornF1);
        sb6.append(tornF2);

        tornF = sb6.toString().toCharArray();

        tornMod.add(new Torn(tornF));
        
        return "index";
    }

}

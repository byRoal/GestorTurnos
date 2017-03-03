/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servei;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author nasty
 */
@Named
@ViewScoped
public class TornServei implements Serializable {

    private char[] tornA = {'O', 'O', 'O', 'O', 'X', 'X', 'R', 'R', 'R', 'R', 'R', 'X', 'X', 'M', 'M', 'T', 'T', 'N', 'N', 'N', 'X', 'X', 'M', 'M', 'T', 'T', 'T', 'N', 'N', 'X', 'X', 'M', 'M', 'M', 'T', 'T', 'N', 'N', 'X', 'X', 'X', 'O'};
    private char[] tornB = {'R', 'R', 'R', 'R', 'X', 'X', 'M', 'M', 'T', 'T', 'N', 'N', 'N', 'X', 'X', 'M', 'M', 'T', 'T', 'T', 'N', 'N', 'X', 'X', 'M', 'M', 'M', 'T', 'T', 'N', 'N', 'X', 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'X', 'X', 'R'};
    private char[] tornC = {'X', 'M', 'M', 'T', 'T', 'T', 'N', 'N', 'X', 'X', 'M', 'M', 'M', 'T', 'T', 'N', 'N', 'X', 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'X', 'X', 'R', 'R', 'R', 'R', 'R', 'X', 'X', 'M', 'M', 'T', 'T', 'N', 'N', 'N', 'X'};
    private char[] tornD = {'N', 'X', 'X', 'M', 'M', 'M', 'T', 'T', 'N', 'N', 'X', 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'X', 'X', 'R', 'R', 'R', 'R', 'R', 'X', 'X', 'M', 'M', 'T', 'T', 'N', 'N', 'N', 'X', 'X', 'M', 'M', 'T', 'T', 'T', 'N'};
    private char[] tornE = {'T', 'N', 'N', 'X', 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'X', 'X', 'R', 'R', 'R', 'R', 'R', 'X', 'X', 'M', 'M', 'T', 'T', 'N', 'N', 'N', 'X', 'X', 'M', 'M', 'T', 'T', 'T', 'N', 'N', 'X', 'X', 'M', 'M', 'M', 'T'};
    private char[] tornF = {'M', 'T', 'T', 'N', 'N', 'N', 'X', 'X', 'M', 'M', 'T', 'T', 'T', 'N', 'N', 'X', 'X', 'M', 'M', 'M', 'T', 'T', 'N', 'N', 'X', 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'X', 'X', 'R', 'R', 'R', 'R', 'R', 'X', 'X', 'M'};

    private char[] seq1 = new char[366];
    private char[] seq2 = new char[366];
    private char[] seq3 = new char[366];
    private char[] seq4 = new char[366];
    private char[] seq5 = new char[366];
    private char[] seq6 = new char[366];

    GregorianCalendar anyInicial = new GregorianCalendar(2008, 0, 1);
    GregorianCalendar anyFinal = new GregorianCalendar();
    GregorianCalendar anyTrespas = new GregorianCalendar();

    private List<DiesTorns> diesTorns;
    private List<Torn> torns;
    private int any = Calendar.getInstance().get(Calendar.YEAR);

    private int diaTornComença;
    private boolean primer = true;

    @PostConstruct
    public void init() {
        torns = new ArrayList(6);
        diesTorns = new ArrayList(6);
        diesTorns.add(new DiesTorns(1, 2, 3, 4, 5, 6));
        if (primer) {
            torn1(any);
            primer = false;
        }
    }

    public List<Torn> getTorns() {
        return torns;
    }

    public int getAny() {
        return any;
    }

    public void setAny(int any) {
        this.any = any;
        init();
    }

    public List<DiesTorns> getDiesTorns() {
        return diesTorns;
    }

    public void torn2(int any1) {
        torn1(any1);
        any = any + 1;
    }

    public void torn3(int any1) {
        torn1(any1);
        any = any - 1;
    }

    public void torn1(int any) {

        anyFinal.set(any, 0, 1);
        //anyFinal.set(2017, 0, 1);
//        System.out.println("passa");
        long dies = (anyFinal.getTimeInMillis() - anyInicial.getTimeInMillis()) / (1000 * 3600 * 24);
//        System.out.println(dies);

        diaTornComença = (int) dies % 42;
        System.out.println(diaTornComença);

        for (int i = 0; i < 366; i++) {
            if (i == 59) {
                if (anyTrespas.isLeapYear(any)) {
                    seq1[i] = tornA[diaTornComença];
                    seq2[i] = tornB[diaTornComença];
                    seq3[i] = tornC[diaTornComença];
                    seq4[i] = tornD[diaTornComença];
                    seq5[i] = tornE[diaTornComença];
                    seq6[i] = tornF[diaTornComença];
                } else {
                    seq1[i] = ' ';
                    seq2[i] = ' ';
                    seq3[i] = ' ';
                    seq4[i] = ' ';
                    seq5[i] = ' ';
                    seq6[i] = ' ';
                }
            } else {

                seq1[i] = tornA[diaTornComença];
                seq2[i] = tornB[diaTornComença];
                seq3[i] = tornC[diaTornComença];
                seq4[i] = tornD[diaTornComença];
                seq5[i] = tornE[diaTornComença];
                seq6[i] = tornF[diaTornComença];
                diaTornComença++;
                if (diaTornComença == 42) {
                    diaTornComença = 0;
                }
            }
        }
        torns.add(new Torn(seq1));
        torns.add(new Torn(seq2));
        torns.add(new Torn(seq3));
        torns.add(new Torn(seq4));
        torns.add(new Torn(seq5));
        torns.add(new Torn(seq6));

    }

    public String capSetmana(int dia, int mes) {
        GregorianCalendar finde = new GregorianCalendar();
        finde.set(any, mes, dia);
        int day = finde.get(Calendar.DAY_OF_WEEK);
//        int month = finde.get(Calendar.DAY_OF_MONTH);
        if (dia == 29 && mes == 1 && !anyTrespas.isLeapYear(any)) {
            return "negre";
        } else if (day == Calendar.SATURDAY || day == Calendar.SUNDAY) {
//            System.out.println("vermell");
            return "vermell";
        } else {
//            System.out.println("negre "  +dia +" " +mes);
            return "negre";
        }
    }

}

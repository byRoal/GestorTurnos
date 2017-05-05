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
import static java.util.Collections.list;
import java.util.GregorianCalendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.ToggleEvent;
import org.primefaces.model.Visibility;
import domini.Diasfestivos;
import java.util.Date;

/**
 *
 * @author nasty
 */
@Named
@ViewScoped
public class TornServei1 implements Serializable {

    @Inject
    private DiasFestivosServei serveiDiasFestivos;

    //declaramos las sequencias correspondientes de cada turno que hay
    private char[] tornA = {'O', 'O', 'O', 'O', 'X', 'X', 'R', 'R', 'R', 'R', 'R', 'X', 'X', 'M', 'M', 'T', 'T', 'N', 'N', 'N', 'X', 'X', 'M', 'M', 'T', 'T', 'T', 'N', 'N', 'X', 'X', 'M', 'M', 'M', 'T', 'T', 'N', 'N', 'X', 'X', 'X', 'O'};
    private char[] tornB = {'R', 'R', 'R', 'R', 'X', 'X', 'M', 'M', 'T', 'T', 'N', 'N', 'N', 'X', 'X', 'M', 'M', 'T', 'T', 'T', 'N', 'N', 'X', 'X', 'M', 'M', 'M', 'T', 'T', 'N', 'N', 'X', 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'X', 'X', 'R'};
    private char[] tornC = {'X', 'M', 'M', 'T', 'T', 'T', 'N', 'N', 'X', 'X', 'M', 'M', 'M', 'T', 'T', 'N', 'N', 'X', 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'X', 'X', 'R', 'R', 'R', 'R', 'R', 'X', 'X', 'M', 'M', 'T', 'T', 'N', 'N', 'N', 'X'};
    private char[] tornD = {'N', 'X', 'X', 'M', 'M', 'M', 'T', 'T', 'N', 'N', 'X', 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'X', 'X', 'R', 'R', 'R', 'R', 'R', 'X', 'X', 'M', 'M', 'T', 'T', 'N', 'N', 'N', 'X', 'X', 'M', 'M', 'T', 'T', 'T', 'N'};
    private char[] tornE = {'T', 'N', 'N', 'X', 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'X', 'X', 'R', 'R', 'R', 'R', 'R', 'X', 'X', 'M', 'M', 'T', 'T', 'N', 'N', 'N', 'X', 'X', 'M', 'M', 'T', 'T', 'T', 'N', 'N', 'X', 'X', 'M', 'M', 'M', 'T'};
    private char[] tornF = {'M', 'T', 'T', 'N', 'N', 'N', 'X', 'X', 'M', 'M', 'T', 'T', 'T', 'N', 'N', 'X', 'X', 'M', 'M', 'M', 'T', 'T', 'N', 'N', 'X', 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'X', 'X', 'R', 'R', 'R', 'R', 'R', 'X', 'X', 'M'};

    //declaramos los arrays donde almacenaremos toda la sequencia de cada turno de un año entero
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
    private List<HoresTorns> horesTorns;
    private List<Torn> torns;
    List<Diasfestivos> llistaDies;

    private int any = Calendar.getInstance().get(Calendar.YEAR);

    private int diaTornComença;
    private boolean primer = true;
    private int horesAny = 1712;
    private int diesAny = horesAny / 8;

    /**
     * función que se incia antes de cargar la página para mostrar los datos
     */
    @PostConstruct
    public void init() {
        llistaDies = serveiDiasFestivos.llistarDiasFestivos();
        torns = new ArrayList(6);
        diesTorns = new ArrayList(6);
        horesTorns = new ArrayList(6);
        torn1(any);
    }

    public int getHoresAny() {
        return horesAny;
    }

    public int getDiesAny() {
        return diesAny;
    }

    public List<Torn> getTorns() {
        return torns;
    }

    public int getAny() {
        return any;
    }

    public void setAny(int any) {
        //No se puede poner un año menor a 2008
        if (any < 2008) {
            any = 2008;
        }
        this.any = any;

    }

    public List<DiesTorns> getDiesTorns() {
        return diesTorns;
    }

    public List<HoresTorns> getHoresTorns() {
        return horesTorns;
    }

    public void torn2(int any1) {
        any = any + 1;
        torn1(any1);

    }

    public void torn3(int any1) {
        //No se puede poner un año menor a 2008
        if (any1 < 2008) {
            any = 2008;
            any1 = 2008;
        } else {
            any = any - 1;
        }

        torn1(any1);

    }

    public void torn1(int any) {
        torns.clear();
        anyFinal.set(any, 0, 1);

        //anyFinal.set(2017, 0, 1);
        //System.out.println("passa");
        long dies = (anyFinal.getTimeInMillis() - anyInicial.getTimeInMillis()) / (1000 * 3600 * 24);
        //System.out.println(dies + "---");

        diaTornComença = (int) dies % 42;
        //System.out.println(diaTornComença);

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

        diesTorns.clear();
        horesTorns.clear();

        contaDies(seq1);
        contaDies(seq2);
        contaDies(seq3);
        contaDies(seq4);
        contaDies(seq5);
        contaDies(seq6);
    }

    public String capSetmana(int dia, int mes) {
        GregorianCalendar finde = new GregorianCalendar();

        boolean trobat = false;
        boolean curs = false;
        int i = 0;

        finde.set(any, mes, dia);
        Date data = new Date(any - 1900, mes, dia);
        while (trobat == false && i < llistaDies.size()) {
            if (llistaDies.get(i).getFechaFestivo().equals(data)) {
                trobat = true;

                if (llistaDies.get(i).getEsCursillo() == true) {
                    curs = true;
                }

            }
            i++;
        }

        int day = finde.get(Calendar.DAY_OF_WEEK);
        int month = finde.get(Calendar.DAY_OF_MONTH);
        if (curs == true) {
            return "verd";
        } else if (trobat == true) {
            return "vermell";
        } else if (dia == 29 && mes == 1 && !anyTrespas.isLeapYear(any)) {
            //System.out.println("vermell " + dia + " " + mes);
            return "negre ";
        } else if (day == Calendar.SATURDAY || day == Calendar.SUNDAY) {
//            System.out.println("negre "  +dia +" " +mes);
            return "vermell";
        } else {
            return "negre";
        }
    }

    private void contaDies(char[] seq) {
        final int HORES = 8;
        int diesM = 0, diesT = 0, diesN = 0, diesR = 0, diesMTNR = 0, diesTOT = 0, diesRF = 0, diesX = 0, diesO = 0, diesCurs = 10, diesRPres = 0;
        int horesM = 0, horesT = 0, horesN = 0, horesR = 0, horesMTNRC = 0, horesTOT = 0, horesX = 0, horesO = 0, horesCurs = 0, horesVac = 0, horesDif = 0;

        for (int i = 0; i < seq.length; i++) {
            switch (seq[i]) {
                case 'M':
                    diesM = diesM + 1;
                    break;
                case 'T':
                    diesT = diesT + 1;
                    break;
                case 'N':
                    diesN = diesN + 1;
                    break;
                case 'R':
                    diesR = diesR + 1;
                    break;
                case 'X':
                    diesX = diesX + 1;
                    break;
                case 'O':
                    diesO = diesO + 1;
                    break;
            }
        }

        diesTOT = diesM + diesT + diesN;
        diesMTNR = diesM + diesT + diesN + diesR;
        diesRF = diesMTNR - diesAny;
        diesRPres = diesR - (diesRF + diesCurs);
        horesM = diesM * HORES;
        horesT = diesT * HORES;
        horesN = diesN * HORES;
        horesR = diesR * HORES;
        horesMTNRC = (diesMTNR + diesCurs) * HORES;
        horesX = diesX * HORES;
        horesO = diesO * HORES;
        horesCurs = diesCurs * HORES;
        horesTOT = horesM + horesT + horesN;
        horesVac = diesRPres * 8;
        horesDif = horesAny - (horesMTNRC - horesVac);

        diesTorns.add(new DiesTorns(diesM, diesT, diesN, diesR, diesMTNR, diesTOT, diesRF, diesX, diesO, diesCurs, diesRPres));
        horesTorns.add(new HoresTorns(horesM, horesT, horesN, horesR, horesMTNRC, horesTOT, horesX, horesO, horesCurs, horesVac, horesDif));

    }
    private List<Boolean> list = Arrays.asList(true, true, true, true, true, true, true, true, true, true, true, true);

    public List<Boolean> getList() {
        return list;
    }

    public void onToggle(ToggleEvent e) {
        list.set((Integer) e.getData(), e.getVisibility() == Visibility.VISIBLE);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servei;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author ND17613
 */
@Named
@SessionScoped
public class QuadrantServei implements Serializable {

     List<String> llist;
     
    char[] torn = new char[]{};
    char[] tornA = new char[]{'O', 'O', 'O', 'O', 'X', 'X', 'R', 'R', 'R', 'R', 'R', 'X', 'X', 'M', 'M', 'T', 'T', 'N', 'N', 'N', 'X', 'X', 'M', 'M', 'T', 'T', 'T', 'N', 'N', 'X', 'X', 'M', 'M', 'M', 'T', 'T', 'N', 'N', 'X', 'X', 'X', 'O'};
    char[] tornB = new char[]{'R', 'R', 'R', 'R', 'X', 'X', 'M', 'M', 'T', 'T', 'N', 'N', 'N', 'X', 'X', 'M', 'M', 'T', 'T', 'T', 'N', 'N', 'X', 'X', 'M', 'M', 'M', 'T', 'T', 'N', 'N', 'X', 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'X', 'X', 'R'};
    char[] tornC = new char[]{'X', 'M', 'M', 'T', 'T', 'T', 'N', 'N', 'X', 'X', 'M', 'M', 'M', 'T', 'T', 'N', 'N', 'X', 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'X', 'X', 'R', 'R', 'R', 'R', 'R', 'X', 'X', 'M', 'M', 'T', 'T', 'N', 'N', 'N', 'X'};
    char[] tornD = new char[]{'N', 'X', 'X', 'M', 'M', 'M', 'T', 'T', 'N', 'N', 'X', 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'X', 'X', 'R', 'R', 'R', 'R', 'R', 'X', 'X', 'M', 'M', 'T', 'T', 'N', 'N', 'N', 'X', 'X', 'M', 'M', 'T', 'T', 'T', 'N'};
    char[] tornE = new char[]{'T', 'N', 'N', 'X', 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'X', 'X', 'R', 'R', 'R', 'R', 'R', 'X', 'X', 'M', 'M', 'T', 'T', 'N', 'N', 'N', 'X', 'X', 'M', 'M', 'T', 'T', 'T', 'N', 'N', 'X', 'X', 'M', 'M', 'M', 'T'};
    char[] tornF = new char[]{'M', 'T', 'T', 'N', 'N', 'N', 'X', 'X', 'M', 'M', 'T', 'T', 'T', 'N', 'N', 'X', 'X', 'M', 'M', 'M', 'T', 'T', 'N', 'N', 'X', 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'X', 'X', 'R', 'R', 'R', 'R', 'R', 'X', 'X', 'M'};

    int diaTorn = 0, z = 0, diaAny = 0, diesMes = 0, mes = 0, any, diaTornComença;
    String tornInt;

    public char tornB() {
        GregorianCalendar anyInicial = new GregorianCalendar(2008, 0, 1);
        GregorianCalendar anyFinal = new GregorianCalendar();
        GregorianCalendar anyTrespas = new GregorianCalendar();

        //anyFinal.set(any, 0, 1);
        anyFinal.set(2017, 0, 1);
        long dies = (anyFinal.getTimeInMillis() - anyInicial.getTimeInMillis()) / (1000 * 3600 * 24);

        diaTornComença = (int) dies % 42;
        diaTorn = diaTornComença;

        diaTorn++;
        diaAny++;
        z++;
        if (diaTorn == 42) {
            diaTorn = 0;
        }
        
        
        return tornA[diaTorn];
    }

    public QuadrantServei(List<String> llist) {
        this.llist = llist;
        llist.add("a");
        llist.add("b");
        llist.add("c");
        llist.add("d");
        
    }

    public List<String> getLlist() {
        return llist;
    }
    
    
    

    
    
    
    

    
    
    

    
    
    

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servei;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ND17613
 */
public class LlistaPoli {
    List<String[]> llistaP;
    String dowID;

    public LlistaPoli() {
    }

    public LlistaPoli(List<String[]> llistaP, String dowID) {
        this.llistaP = llistaP;
        this.dowID = dowID;
    }
    
    public List<String[]> getLlistaP() {
        return llistaP;
    }

    public void setLlistaP(List<String[]> llistaP) {
        this.llistaP = llistaP;
    }

    public String getDowID() {
        return dowID;
    }

    public void setDowID(String dowID) {
        this.dowID = dowID;
    }

    @Override
    public String toString() {
        return "LlistaPoli{" + "llistaP=" + llistaP.toString() + ", dowID=" + dowID + '}';
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servei;

/**
 *
 * @author ND17613
 */
public class DiesTorns {
    private int diesM;
    private int diesT;
    private int diesN;
    private int diesR;
    private int diesMTNR;
    private int diesTOT;
    private int diesRF;
    private int diesX;
    private int diesO;
    private int diesCurs;
    private int diesRPres;

    public DiesTorns(int diesM, int diesT, int diesN, int diesR, int diesMTNR, int diesTOT, int diesRF, int diesX, int diesO, int diesCurs, int diesRPres) {
        this.diesM = diesM;
        this.diesT = diesT;
        this.diesN = diesN;
        this.diesR = diesR;
        this.diesMTNR = diesMTNR;
        this.diesTOT = diesTOT;
        this.diesRF = diesRF;
        this.diesX = diesX;
        this.diesO = diesO;
        this.diesCurs = diesCurs;
        this.diesRPres = diesRPres;
    }

    

    public int getDiesM() {
        return diesM;
    }

    public void setDiesM(int diesM) {
        this.diesM = diesM;
    }

    public int getDiesT() {
        return diesT;
    }

    public void setDiesT(int diesT) {
        this.diesT = diesT;
    }

    public int getDiesN() {
        return diesN;
    }

    public void setDiesN(int diesN) {
        this.diesN = diesN;
    }

    public int getDiesR() {
        return diesR;
    }

    public void setDiesR(int diesR) {
        this.diesR = diesR;
    }

    public int getDiesMTNR() {
        return diesMTNR;
    }

    public void setDiesMTNR(int diesMTNR) {
        this.diesMTNR = diesMTNR;
    }

    public int getDiesTOT() {
        return diesTOT;
    }

    public void setDiesTOT(int diesTOT) {
        this.diesTOT = diesTOT;
    }

    public int getDiesRF() {
        return diesRF;
    }

    public void setDiesRF(int diesRF) {
        this.diesRF = diesRF;
    }

    public int getDiesX() {
        return diesX;
    }

    public void setDiesX(int diesX) {
        this.diesX = diesX;
    }

    public int getDiesO() {
        return diesO;
    }

    public void setDiesO(int diesO) {
        this.diesO = diesO;
    }

    public int getDiesCurs() {
        return diesCurs;
    }

    public void setDiesCurs(int diesCurs) {
        this.diesCurs = diesCurs;
    }

    public int getDiesRPres() {
        return diesRPres;
    }

    public void setDiesRPres(int diesRPres) {
        this.diesRPres = diesRPres;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.diesM;
        hash = 59 * hash + this.diesT;
        hash = 59 * hash + this.diesN;
        hash = 59 * hash + this.diesR;
        hash = 59 * hash + this.diesMTNR;
        hash = 59 * hash + this.diesTOT;
        hash = 59 * hash + this.diesRF;
        hash = 59 * hash + this.diesX;
        hash = 59 * hash + this.diesO;
        hash = 59 * hash + this.diesCurs;
        hash = 59 * hash + this.diesRPres;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DiesTorns other = (DiesTorns) obj;
        if (this.diesM != other.diesM) {
            return false;
        }
        if (this.diesT != other.diesT) {
            return false;
        }
        if (this.diesN != other.diesN) {
            return false;
        }
        if (this.diesR != other.diesR) {
            return false;
        }
        if (this.diesMTNR != other.diesMTNR) {
            return false;
        }
        if (this.diesTOT != other.diesTOT) {
            return false;
        }
        if (this.diesRF != other.diesRF) {
            return false;
        }
        if (this.diesX != other.diesX) {
            return false;
        }
        if (this.diesO != other.diesO) {
            return false;
        }
        if (this.diesCurs != other.diesCurs) {
            return false;
        }
        if (this.diesRPres != other.diesRPres) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DiesTorns{" + "diesM=" + diesM + ", diesT=" + diesT + ", diesN=" + diesN + ", diesR=" + diesR + ", diesMTNR=" + diesMTNR + ", diesTOT=" + diesTOT + ", diesRF=" + diesRF + ", diesX=" + diesX + ", diesO=" + diesO + ", diesCurs=" + diesCurs + ", diesRPres=" + diesRPres + '}';
    }
    
    
}

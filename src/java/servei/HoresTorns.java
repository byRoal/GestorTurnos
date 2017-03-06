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
public class HoresTorns {
    private int horesM;
    private int horesT;
    private int horesN;
    private int horesR;
    private int horesMTNRC;
    private int horesTOT;
    private int horesRF;
    private int horesX;
    private int horesO;
    private int horesCurs;
    private int horesVac;
    private int horesDif;

    public HoresTorns(int horesM, int horesT, int horesN, int horesR, int horesMTNRC, int horesTOT, int horesX, int horesO, int horesCurs, int horesVac, int horesDif) {
        this.horesM = horesM;
        this.horesT = horesT;
        this.horesN = horesN;
        this.horesR = horesR;
        this.horesMTNRC = horesMTNRC;
        this.horesTOT = horesTOT;        
        this.horesX = horesX;
        this.horesO = horesO;
        this.horesCurs = horesCurs;
        this.horesVac = horesVac;
        this.horesDif = horesDif;
    }

    public int getHoresM() {
        return horesM;
    }

    public void setHoresM(int horesM) {
        this.horesM = horesM;
    }

    public int getHoresT() {
        return horesT;
    }

    public void setHoresT(int horesT) {
        this.horesT = horesT;
    }

    public int getHoresN() {
        return horesN;
    }

    public void setHoresN(int horesN) {
        this.horesN = horesN;
    }

    public int getHoresR() {
        return horesR;
    }

    public void setHoresR(int horesR) {
        this.horesR = horesR;
    }

    public int getHoresMTNRC() {
        return horesMTNRC;
    }

    public void setHoresMTNRC(int horesMTNRC) {
        this.horesMTNRC = horesMTNRC;
    }

    public int getHoresTOT() {
        return horesTOT;
    }

    public void setHoresTOT(int horesTOT) {
        this.horesTOT = horesTOT;
    }

    public int getHoresRF() {
        return horesRF;
    }

    public void setHoresRF(int horesRF) {
        this.horesRF = horesRF;
    }

    public int getHoresX() {
        return horesX;
    }

    public void setHoresX(int horesX) {
        this.horesX = horesX;
    }

    public int getHoresO() {
        return horesO;
    }

    public void setHoresO(int horesO) {
        this.horesO = horesO;
    }

    public int getHoresCurs() {
        return horesCurs;
    }

    public void setHoresCurs(int horesCurs) {
        this.horesCurs = horesCurs;
    }

    public int getHoresVac() {
        return horesVac;
    }

    public void setHoresVac(int horesVac) {
        this.horesVac = horesVac;
    }

    public int getHoresDif() {
        return horesDif;
    }

    public void setHoresDif(int horesDif) {
        this.horesDif = horesDif;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.horesM;
        hash = 71 * hash + this.horesT;
        hash = 71 * hash + this.horesN;
        hash = 71 * hash + this.horesR;
        hash = 71 * hash + this.horesMTNRC;
        hash = 71 * hash + this.horesTOT;
        hash = 71 * hash + this.horesRF;
        hash = 71 * hash + this.horesX;
        hash = 71 * hash + this.horesO;
        hash = 71 * hash + this.horesCurs;
        hash = 71 * hash + this.horesVac;
        hash = 71 * hash + this.horesDif;
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
        final HoresTorns other = (HoresTorns) obj;
        if (this.horesM != other.horesM) {
            return false;
        }
        if (this.horesT != other.horesT) {
            return false;
        }
        if (this.horesN != other.horesN) {
            return false;
        }
        if (this.horesR != other.horesR) {
            return false;
        }
        if (this.horesMTNRC != other.horesMTNRC) {
            return false;
        }
        if (this.horesTOT != other.horesTOT) {
            return false;
        }
        if (this.horesRF != other.horesRF) {
            return false;
        }
        if (this.horesX != other.horesX) {
            return false;
        }
        if (this.horesO != other.horesO) {
            return false;
        }
        if (this.horesCurs != other.horesCurs) {
            return false;
        }
        if (this.horesVac != other.horesVac) {
            return false;
        }
        if (this.horesDif != other.horesDif) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "HoresTorns{" + "horesM=" + horesM + ", horesT=" + horesT + ", horesN=" + horesN + ", horesR=" + horesR + ", horesMTNRC=" + horesMTNRC + ", horesTOT=" + horesTOT + ", horesRF=" + horesRF + ", horesX=" + horesX + ", horesO=" + horesO + ", horesCurs=" + horesCurs + ", horesVac=" + horesVac + ", horesDif=" + horesDif + '}';
    }
        
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servei;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author nasty
 */
public class Torn implements Serializable {

    private char[] seq;

    public Torn(char[] seq) {
        this.seq = seq;
    }

    public char[] getSeq() {
        return seq;
    }

    public void setSeq(char[] seq) {
        this.seq = seq;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Arrays.hashCode(this.seq);
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
        final Torn other = (Torn) obj;
        if (!Arrays.equals(this.seq, other.seq)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Torn{" + "seq=" + seq + '}';
    }

}

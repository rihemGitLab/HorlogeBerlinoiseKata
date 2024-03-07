package org.horlogeberlinoise.lampe;

public class LampeAllumee implements Lampe {
    @Override
    public String etat() {
        return "Y";
    }
    @Override
    public CouleurLampeEnum getColor() {
        return CouleurLampeEnum.YELLOW;
    }
}
package org.horlogeberlinoise.lampe;

public class LampeEteinte implements Lampe {
    @Override
    public String etat() {
        return "O";
    }
    @Override
    public CouleurLampeEnum getColor() {
        return CouleurLampeEnum.OFF;
    }
}

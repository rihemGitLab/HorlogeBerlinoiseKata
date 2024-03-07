package org.horlogeberlinoise.lampe;

public enum CouleurLampeEnum {
    YELLOW("Y"),
    RED("R"),
    OFF("O");

    private final String couleur;

    CouleurLampeEnum(String couleur) {
        this.couleur = couleur;
    }

    public String getCouleur() {
        return couleur;
    }
}
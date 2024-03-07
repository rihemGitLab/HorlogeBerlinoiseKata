package org.horlogeberlinoise.composite;


public enum PartieHorlogeEnum {
    HEURES("Heures"),
    MINUTES("Minutes"),
    SECONDES("Secondes");

    private final String nom;

    PartieHorlogeEnum(String nom) {
        this.nom = nom;
    }

    // Méthode pour obtenir le nom de la partie
    public String getNom() {
        return nom;
    }
}

package org.horlogeberlinoise.convertisseur;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConvertisseurHeureSimpleTest {
    @Test
    public void testConvertirHeureImpaire() {
        ConvertisseurHeure convertisseur = new ConvertisseurHeureSimple();
        String resultat = String.valueOf(convertisseur.convertir(9));
        assertEquals("9", resultat);
    }

    @Test
    public void testConvertirHeurePaire() {
        ConvertisseurHeure convertisseur = new ConvertisseurHeureSimple();
        String resultat = convertisseur.convertir(14).toString();
        assertEquals("14", resultat);
    }

    @Test
    public void testConvertirHeureLimiteSuperieure() {
        ConvertisseurHeure convertisseur = new ConvertisseurHeureSimple();
        String resultat = convertisseur.convertir(23).toString();
        assertEquals("23", resultat);
    }

    @Test
    public void testConvertirHeureLimiteInferieure() {
        ConvertisseurHeure convertisseur = new ConvertisseurHeureSimple();
        String resultat = convertisseur.convertir(1).toString();
        assertEquals("1", resultat);
    }
}
package org.horlogeberlinoise.composite;

import org.horlogeberlinoise.exception.HorlogeVideException;
import org.horlogeberlinoise.exception.LampeNullException;
import org.horlogeberlinoise.lampe.CouleurLampeEnum;
import org.horlogeberlinoise.lampe.Lampe;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HorlogeCompositeTest {

    @Test
    public void testAfficherAvecLampeNull() {
        HorlogeComposite horloge = new HorlogeComposite();
        assertThrows(LampeNullException.class, () -> horloge.ajouterLampe(null));

    }

    @Test
    public void testAfficherHorlogeVide() {
        HorlogeComposite horloge = new HorlogeComposite();

        // Verifier si une exception HorlogeVideException est levee lorsque l'horloge est vide
        assertThrows(HorlogeVideException.class, () -> horloge.afficher());
    }

    @Test
    public void testAfficherAvecLampesAllumees() {
        // Créer une horloge composite
        HorlogeComposite horloge = new HorlogeComposite();

        // Créer des lampes simulées allumées
        Lampe lampe1 = mock(Lampe.class);
        Lampe lampe2 = mock(Lampe.class);

        // Définir le comportement attendu pour les lampes simulées allumées
        when(lampe1.etat()).thenReturn("Y");
        when(lampe1.getColor()).thenReturn(CouleurLampeEnum.valueOf("YELLOW"));
        when(lampe2.etat()).thenReturn("Y");
        when(lampe2.getColor()).thenReturn(CouleurLampeEnum.valueOf("YELLOW"));

        // Ajouter les lampes simulées à l'horloge composite
        horloge.ajouterLampe(Collections.singletonList(lampe1));
        horloge.ajouterLampe(Collections.singletonList(lampe2));

        // Vérifier si la méthode afficher() retourne le résultat attendu
        assertEquals("Y (YELLOW) Y (YELLOW)", horloge.afficher());
    }

    @Test
    public void testAfficherAvecLampesEteintes() {
        // Créer une horloge composite
        HorlogeComposite horloge = new HorlogeComposite();

        // Créer des lampes simulées éteintes
        Lampe lampe1 = mock(Lampe.class);
        Lampe lampe2 = mock(Lampe.class);

        // Définir le comportement attendu pour les lampes simulées éteintes
        when(lampe1.etat()).thenReturn("O");
        when(lampe1.getColor()).thenReturn(CouleurLampeEnum.valueOf("OFF"));
        when(lampe2.etat()).thenReturn("O");
        when(lampe2.getColor()).thenReturn(CouleurLampeEnum.valueOf("OFF"));

        // Ajouter les lampes simulées à l'horloge composite
        horloge.ajouterLampe(Collections.singletonList(lampe1));
        horloge.ajouterLampe(Collections.singletonList(lampe2));

        // Vérifier si la méthode afficher() retourne le résultat attendu
        assertEquals("O (OFF) O (OFF)", horloge.afficher());
    }
}

package org.horlogeberlinoise;

import org.horlogeberlinoise.exception.LampeNullException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HorlogeBerlinoiseTest {

    @Test
    public void testMettreAJourHorloge_Minuit() {
        // Arrange
        HorlogeBerlinoise horloge = new HorlogeBerlinoise();

        // Act
        horloge.mettreAJourHorloge(0, 0, 0);

        // Assert
        assertEquals("OOOO:OOOO:YOOO", horloge.afficher());
    }

    @Test
    public void testMettreAJourHorloge_12Heures30Minutes() {
        // Arrange
        HorlogeBerlinoise horloge = new HorlogeBerlinoise();

        // Act
        horloge.mettreAJourHorloge(12, 30, 0);

        // Assert
        assertEquals("RRRO:OOOO:OOOO", horloge.afficher());
    }

    @Test
    public void testMettreAJourHorloge_20Heures15Minutes45Secondes() {
        // Arrange
        HorlogeBerlinoise horloge = new HorlogeBerlinoise();

        // Act
        horloge.mettreAJourHorloge(20, 15, 45);

        // Assert
        assertEquals("RRRO:ROOO:RRRO", horloge.afficher());
    }

    @Test
    public void testMettreAJourHorloge_InvalidInput() {
        // Arrange
        HorlogeBerlinoise horloge = new HorlogeBerlinoise();

        // Act & Assert
        assertThrows(LampeNullException.class, () -> horloge.mettreAJourHorloge(-1, 0, 0));
        assertThrows(LampeNullException.class, () -> horloge.mettreAJourHorloge(24, 0, 0));
        assertThrows(LampeNullException.class, () -> horloge.mettreAJourHorloge(12, -1, 0));
        assertThrows(LampeNullException.class, () -> horloge.mettreAJourHorloge(12, 60, 0));
        assertThrows(LampeNullException.class, () -> horloge.mettreAJourHorloge(12, 0, -1));
        assertThrows(LampeNullException.class, () -> horloge.mettreAJourHorloge(12, 0, 60));
    }
}

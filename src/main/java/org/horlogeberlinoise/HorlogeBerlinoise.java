package org.horlogeberlinoise;

import org.horlogeberlinoise.composite.HorlogeComposite;
import org.horlogeberlinoise.convertisseur.ConvertisseurHeure;
import org.horlogeberlinoise.convertisseur.ConvertisseurHeureSimple;
import org.horlogeberlinoise.convertisseur.ConvertisseurMinuteComposite;
import org.horlogeberlinoise.convertisseur.ConvertisseurSecondeSimple;
import org.horlogeberlinoise.exception.LampeNullException;
import org.horlogeberlinoise.lampe.Lampe;

import java.util.List;

public class HorlogeBerlinoise {
    private HorlogeComposite horlogeComposite;
    private ConvertisseurHeure convertisseurHeure;
    private ConvertisseurMinuteComposite convertisseurMinute;
    private ConvertisseurSecondeSimple convertisseurSeconde;

    public HorlogeBerlinoise() {
        this.horlogeComposite = new HorlogeComposite();
        this.convertisseurHeure = new ConvertisseurHeureSimple();
        this.convertisseurMinute = new ConvertisseurMinuteComposite();
        this.convertisseurSeconde = new ConvertisseurSecondeSimple();
    }

    public void mettreAJourHorloge(int heures, int minutes, int secondes) {
        List<Lampe> heuresLampes = convertisseurHeure.convertir(heures);
        List<Lampe> minutesLampes = convertisseurMinute.convertir(minutes);
        List<Lampe> secondesLampes = convertisseurSeconde.convertir(secondes);

        ajouterLampesNonNull(heuresLampes);
        ajouterLampesNonNull(minutesLampes);
        ajouterLampesNonNull(secondesLampes);
    }

    private void ajouterLampesNonNull(List<Lampe> lampes) {
        if (lampes == null) {
            throw new LampeNullException("La liste de lampes ne peut pas être null");
        }
        horlogeComposite.ajouterLampe(lampes);
    }

    public String afficher() {
        return horlogeComposite.afficher();
    }
}

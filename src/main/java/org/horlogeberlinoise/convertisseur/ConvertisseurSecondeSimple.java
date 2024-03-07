package org.horlogeberlinoise.convertisseur;

import org.horlogeberlinoise.exception.NegativeException;
import org.horlogeberlinoise.lampe.Lampe;
import org.horlogeberlinoise.lampe.LampeAllumee;
import org.horlogeberlinoise.lampe.LampeEteinte;

import java.util.ArrayList;
import java.util.List;

public class ConvertisseurSecondeSimple implements ConvertisseurHeure {
    @Override
    public List<Lampe> convertir(int seconde) {
        if (seconde < 0) {
            throw new NegativeException("La valeur de la seconde ne peut pas être négative");
        }

        List<Lampe> lampes = new ArrayList<>();
        Lampe lampe = seconde % 2 == 0 ? new LampeAllumee() : new LampeEteinte();
        for (int i = 0; i < 4; i++) {
            lampes.add(lampe);
        }

        return lampes;
    }
}
package org.horlogeberlinoise.convertisseur;

import org.horlogeberlinoise.lampe.Lampe;

import java.util.List;

public interface ConvertisseurHeure {
    List<Lampe> convertir(int heure);
}

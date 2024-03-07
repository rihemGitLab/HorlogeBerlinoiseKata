package org.horlogeberlinoise.convertisseur;

import org.horlogeberlinoise.exception.NegativeException;
import org.horlogeberlinoise.lampe.Lampe;
import org.horlogeberlinoise.lampe.LampeAllumee;
import org.horlogeberlinoise.lampe.LampeEteinte;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConvertisseurMinuteComposite implements ConvertisseurHeure {
    @Override
    public List<Lampe> convertir(int minute) {
        if (minute < 0) {
            throw new NegativeException("La valeur de la minute ne peut pas être négative : " + minute);
        }

        int minutesJaunes = minute % 5;
        int quarts = minute / 15;

        List<Lampe> lampes = new ArrayList<>();

        // Ajouter les lampes jaunes
        lampes.addAll(IntStream.range(0, minutesJaunes)
                .mapToObj(i -> new LampeAllumee())
                .collect(Collectors.toList()));

        // Ajouter les lampes rouges pour les quarts
        lampes.addAll(IntStream.range(0, quarts * 3)
                .mapToObj(i -> new LampeEteinte())
                .collect(Collectors.toList()));

        // Ajouter les lampes éteintes pour les quarts manquants
        lampes.addAll(IntStream.range(0, 3 - quarts)
                .mapToObj(i -> new LampeEteinte())
                .collect(Collectors.toList()));

        return lampes;
    }
}

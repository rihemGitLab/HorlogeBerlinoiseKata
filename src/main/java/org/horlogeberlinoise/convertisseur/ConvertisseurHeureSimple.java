package org.horlogeberlinoise.convertisseur;

import org.horlogeberlinoise.lampe.Lampe;
import org.horlogeberlinoise.lampe.LampeAllumee;
import org.horlogeberlinoise.lampe.LampeEteinte;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ConvertisseurHeureSimple implements ConvertisseurHeure {
    @Override
    public List<Lampe> convertir(int heure) {
        if (heure < 0) {
            throw new IllegalArgumentException("L'heure ne peut pas être négative");
        }

        int heuresRouges = heure / 5;
        int heuresJaunes = heure % 5;

        List<Lampe> lampesRouges = IntStream.range(0, heuresRouges)
                .mapToObj(i -> new LampeEteinte())
                .collect(Collectors.toList());

        List<Lampe> lampesJaunes = IntStream.range(0, 4 - heuresJaunes)
                .mapToObj(i -> new LampeAllumee())
                .collect(Collectors.toList());

        return Stream.concat(lampesRouges.stream(), lampesJaunes.stream())
                .collect(Collectors.toList());
    }
}

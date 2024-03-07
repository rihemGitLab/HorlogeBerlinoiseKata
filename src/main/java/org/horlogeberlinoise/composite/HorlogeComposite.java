package org.horlogeberlinoise.composite;

import org.horlogeberlinoise.exception.HorlogeVideException;
import org.horlogeberlinoise.exception.LampeNullException;
import org.horlogeberlinoise.lampe.Lampe;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HorlogeComposite {
    private List<Lampe> lampes;

    public HorlogeComposite() {
        this.lampes = new ArrayList<>();
    }


    public void ajouterLampe(List<Lampe> nouvellesLampes) {
        if (nouvellesLampes == null) {
            throw new LampeNullException("La liste de lampes ne peut pas être null");
        }
        List<Lampe> nonNullLampes = nouvellesLampes.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        if (nonNullLampes.isEmpty()) {
            throw new LampeNullException("La liste de lampes ne peut pas être vide après filtrage");
        }
        this.lampes.addAll(nonNullLampes);
    }

    public String afficher() {
        String affichage = lampes.stream()
                .map(lampe -> lampe.getColor().getCouleur())
                .collect(Collectors.joining());

        // Vérifier si la longueur de la chaîne est valide pour découper en sous-chaînes de 4 caractères
        if (affichage.length() % 4 != 0) {
            throw new IllegalStateException("La longueur de la chaîne d'affichage n'est pas valide");
        }

        // Ajouter les séparateurs ":" selon le modèle d'affichage
        StringJoiner joiner = new StringJoiner(":");
        for (int i = 0; i < affichage.length() / 4; i++) {
            joiner.add(affichage.substring(i * 4, (i + 1) * 4));
        }
        return joiner.toString();
    }


}
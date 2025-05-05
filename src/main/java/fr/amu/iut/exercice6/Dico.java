package fr.amu.iut.exercice6;

import java.util.ArrayList;


class Dico {
    private final String[] mots = {"ordinateur","erreur","programmation","java","developpeur"};

    public String getMot() {
        return mots[(int)(Math.random()*mots.length)];
    }

    public ArrayList<Integer> getPositions(char lettre, String mot) {
        ArrayList<Integer> l = new ArrayList<>();
        for (int i = 0; i < mot.length(); i++)
            if (mot.charAt(i) == lettre) l.add(i);
        return l;
    }
}


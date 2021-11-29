package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.HashSet;

public class Manager extends Employe{

    private HashSet<Technicien> equipe = new HashSet<>();

    public Manager() {

    }

    public Manager(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, HashSet<Technicien> equipe) {
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.equipe = equipe;
    }

    @Override
    public Double getPrimeAnnuelle(){
        return Entreprise.primeAnnuelleBase() + Entreprise.PRIME_MANAGER_PAR_TECHNICIEN*equipe.size();
    }

    public void ajoutTechnicienEquipe(Technicien technicien){
        equipe.add(technicien);
    }

    public void ajoutTechnicienEquipe(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Integer grade){
        equipe.add(new Technicien(nom, prenom, matricule, dateEmbauche, salaire, grade));
    }

    public HashSet<Technicien> getEquipe() {
        return equipe;
    }

    public void setEquipe(HashSet<Technicien> equipe) {
        this.equipe = equipe;
    }

    @Override
    public void setSalaire(Double salaire){
        super.setSalaire(salaire*Entreprise.INDICE_MANAGER + 0.1*salaire*equipe.size());
    }

    private void augmenterSalaireEquipe(Double pourcentage){
        for(Technicien technicien : equipe){
            try {
                technicien.augmenterSalaire(pourcentage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void augmenterSalaire(Double pourcentage){
        augmenterSalaireEquipe(pourcentage);
        try {
            super.augmenterSalaire(pourcentage);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

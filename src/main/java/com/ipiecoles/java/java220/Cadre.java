package com.ipiecoles.java.java220;

import java.util.Objects;

public class Cadre extends Employe{

    private Double coefficient = 1d;


    @Override
    public Double getPrimeAnnuelle() {
        return Entreprise.primeAnnuelleBase()*coefficient;
    }

    public Integer getNbConges(){
        return super.getNbConges() + (int)Math.round(coefficient);
    }

    public Double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Double coefficient) {
        this.coefficient = coefficient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cadre cadre = (Cadre) o;
        return Objects.equals(coefficient, cadre.coefficient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), coefficient);
    }

    @Override
    public String toString() {
        return "Cadre{" +
                "coefficient=" + coefficient +
                "} " + super.toString();
    }
}

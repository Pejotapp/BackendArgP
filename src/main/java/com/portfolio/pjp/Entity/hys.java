
package com.portfolio.pjp.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

@Entity
public class hys {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotBlank
    private String nombreSkill;
    @Range(min = 0, max = 100, message = "Por favor, ingrese valores positivos entre 0 y 100.")
    private int porcentaje;

    public hys() {
    }

    public hys(String nombre, int porcentaje) {
        this.nombreSkill = nombre;
        this.porcentaje = porcentaje;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreSkill() {
        return nombreSkill;
    }

    public void setNombreSkill(String nombreSkill) {
        this.nombreSkill = nombreSkill;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

   
    
    
}

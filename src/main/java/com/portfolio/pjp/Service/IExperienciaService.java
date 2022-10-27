/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.pjp.Service;

import com.portfolio.pjp.Entity.Experiencia;
import java.util.List;

/**
 *
 * @author pagua
 */
public interface IExperienciaService {
    
     public List<Experiencia> getExperiencia();
    public void saveExperiencia(Experiencia experiencia);
    public void deleteExperiencia(int id);
    public Experiencia findExperiencia(int id);

   
    
}

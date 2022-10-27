/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.pjp.Service;

import com.portfolio.pjp.Entity.Educacion;
import java.util.List;

/**
 *
 * @author pagua
 */
public interface IEduS {
    
     public List<Educacion> getEducacion();

    public void saveEducacion(Educacion educacion);

    public void deleteEducacion(int id);

    public Educacion findEducacion(int id);
}

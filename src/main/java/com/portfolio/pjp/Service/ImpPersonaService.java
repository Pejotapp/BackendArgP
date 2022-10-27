/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.pjp.Service;

import com.portfolio.pjp.Entity.Persona;
import com.portfolio.pjp.Repository.IPersonaRepository;
import javax.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpPersonaService implements IPersonaService{

    @Autowired
    IPersonaRepository ipersonaRepository;

     @Override
    public List<Persona> getPersona() {
        List<Persona> persona = ipersonaRepository.findAll();
        return persona;
    }
    
    @Override
    public void deletePersona(int id){
    ipersonaRepository.deleteById(id);}
    
 
    @Override
    public void savePersona(Persona persona){
    ipersonaRepository.save(persona);
    }
    
     @Override
    public Persona traerPersona(int id) {
        return ipersonaRepository.getById(id);
    }
    
 
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    


package com.portfolio.pjp.Service;

import com.portfolio.pjp.Entity.Experiencia;
import com.portfolio.pjp.Repository.RExperiencia;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SExperiencia implements IExperienciaService{
    @Autowired
    RExperiencia rExperiencia;
    
     
    @Override
    public void deleteExperiencia(int id) {
        rExperiencia.deleteById(id);

    }

    @Override
    public Experiencia findExperiencia(int id) {
        Experiencia expe = rExperiencia.findById(id).orElse(null);
        return expe;
    }

    @Override
    public List<Experiencia> getExperiencia(){
        List<Experiencia> experiencias = rExperiencia.findAll();
        return experiencias;
    }

    @Override
    public void saveExperiencia(Experiencia experiencia) {

        rExperiencia.save(experiencia);

    }
    
    
}

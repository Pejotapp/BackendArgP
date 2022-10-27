
package com.portfolio.pjp.Service;

import com.portfolio.pjp.Entity.Educacion;
import com.portfolio.pjp.Repository.REducacion;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SEducacion implements IEduS {
    @Autowired
    REducacion rEducacion;
    
    @Override
    public void deleteEducacion(int id) {
        rEducacion.deleteById(id);
    }

    @Override
    public Educacion findEducacion(int id) {
        Educacion edu = rEducacion.findById(id).orElse(null);
        return edu;
    }

    @Override
    public List<Educacion> getEducacion() {
        List<Educacion> educaciones = rEducacion.findAll();
        return educaciones;
    }

    @Override
    public void saveEducacion(Educacion educacion) {

        rEducacion.save(educacion);

    }
}

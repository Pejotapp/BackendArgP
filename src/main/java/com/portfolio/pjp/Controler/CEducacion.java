
package com.portfolio.pjp.Controler;

import com.portfolio.pjp.Entity.Educacion;
import com.portfolio.pjp.Service.IEduS;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/educacion")
@CrossOrigin(origins = {"https://frontendargppjp.web.app"})
public class CEducacion {
    
    @Autowired
    IEduS iEduS;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> lista() {
        List<Educacion> listaEducacion = iEduS.getEducacion();
        return new ResponseEntity<>(listaEducacion, HttpStatus.OK);
    }

    @GetMapping("/traer/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        Educacion educacion = iEduS.findEducacion(id);
        if (educacion == null) {
            return new ResponseEntity<>("Educacion no encontrada", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(educacion, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> addEducacion(@RequestBody Educacion educacion) {
        if (StringUtils.isBlank(educacion.getNombreEdu())
                && StringUtils.isBlank(educacion.getDescripcionEdu())
          ) {
            return new ResponseEntity<>("Hay campos obligatorios sin completar.", HttpStatus.BAD_REQUEST);

        }
        
        iEduS.saveEducacion(educacion);
        return new ResponseEntity<>(educacion, HttpStatus.OK);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editarEducacion(@PathVariable int id, @RequestBody Educacion educacion) {

        Educacion educacionEditada = iEduS.findEducacion(id);

        if (educacionEditada == null) {
            return new ResponseEntity<>("Educación no encontrada.", HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(educacion.getNombreEdu())
                && StringUtils.isBlank(educacion.getDescripcionEdu())
             ) {
            return new ResponseEntity<>("Hay campos obligatorios sin completar.", HttpStatus.BAD_REQUEST);
        }

        educacionEditada.setNombreEdu(educacion.getNombreEdu());
        educacionEditada.setDescripcionEdu(educacion.getDescripcionEdu());
        

        iEduS.saveEducacion(educacionEditada);
        return new ResponseEntity<>(educacionEditada, HttpStatus.OK);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {

        if (iEduS.findEducacion(id) == null) {
            return new ResponseEntity<>("Educacion no encontrada", HttpStatus.BAD_REQUEST);
        }
        iEduS.deleteEducacion(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    }
    


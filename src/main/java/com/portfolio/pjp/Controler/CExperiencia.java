
package com.portfolio.pjp.Controler;

import com.portfolio.pjp.Entity.Experiencia;
import com.portfolio.pjp.Service.IExperienciaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/explab")
@CrossOrigin(origins = {"https://frontendargppjp.web.app/#"})
public class CExperiencia {
    @Autowired
    IExperienciaService iexperienciaService;
    
    
   @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list() {
        List<Experiencia> listaExpe = iexperienciaService.getExperiencia();
        return new ResponseEntity<>(listaExpe, HttpStatus.OK);
    }

    @GetMapping("/traer/{id}")
    public ResponseEntity<?> mostrarExperiencia(@PathVariable int id) {

        Experiencia expe = iexperienciaService.findExperiencia(id);
        if (expe == null) {
            return new ResponseEntity<>("Experiencia no encontrada", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(expe, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> agregarExperiencia(@RequestBody Experiencia expe) {
        if (StringUtils.isBlank(expe.getNombreExp())
                && StringUtils.isBlank(expe.getDescripcionExp()) ){
            return new ResponseEntity<>("Hay campos obligatorios sin completar.", HttpStatus.BAD_REQUEST);

        }
        iexperienciaService.saveExperiencia(expe);
        return new ResponseEntity<>(expe, HttpStatus.OK);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editarExperiencia(@PathVariable int id, @RequestBody Experiencia experiencia) {
        if (iexperienciaService.findExperiencia(id) == null) {
            return new ResponseEntity<>("Experiencia no encontrada", HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(experiencia.getNombreExp())
                && StringUtils.isBlank(experiencia.getDescripcionExp())){
            return new ResponseEntity<>("Hay campos obligatorios sin completar.", HttpStatus.BAD_REQUEST);
        }

        Experiencia experienciaEditada = iexperienciaService.findExperiencia(id);

        experienciaEditada.setNombreExp(experiencia.getNombreExp());
        experienciaEditada.setDescripcionExp(experiencia.getDescripcionExp());
       
        iexperienciaService.saveExperiencia(experienciaEditada);

        return new ResponseEntity<>(experienciaEditada, HttpStatus.OK);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrarExperiencia(@PathVariable int id) {

        if (iexperienciaService.findExperiencia(id) == null) {
            return new ResponseEntity<>("Experiencia no encontrada", HttpStatus.BAD_REQUEST);
        }
        iexperienciaService.deleteExperiencia(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
  
   


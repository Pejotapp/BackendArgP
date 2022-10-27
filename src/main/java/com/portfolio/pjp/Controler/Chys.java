package com.portfolio.pjp.Controler;

import com.portfolio.pjp.Entity.hys;
import com.portfolio.pjp.Service.IhysS;
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
@CrossOrigin(origins = {"https://frontendargppjp.web.app/#","http://localhost:4200"})
@RequestMapping("/skill")
public class Chys {

    @Autowired
    IhysS ihysS;

     @GetMapping("/lista")
    public ResponseEntity<List<hys>> mostrarSkills() {
        List<hys> listaSkills = ihysS.traerSkills();
        return new ResponseEntity<>(listaSkills, HttpStatus.OK);
    }

    @GetMapping("/traer/{id}")
    public ResponseEntity<?> mostrarSkillporId(@PathVariable int id) {

        hys skill = ihysS.traerSkillsPorId(id);
        if (skill == null) {
            return new ResponseEntity<>("Skill no encontrada", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(skill, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> agregarSkilll(@RequestBody hys skill) {
        if (StringUtils.isBlank(skill.getNombreSkill())
               
                && skill.getPorcentaje() <= 0) {
            return new ResponseEntity<>("Campos obligatorios vacios o incorrectos.", HttpStatus.BAD_REQUEST);

        }
        ihysS.saveSkills(skill);
        return new ResponseEntity<>(skill, HttpStatus.OK);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editarSkills(@PathVariable int id, @RequestBody hys skill) {
        if (ihysS.traerSkillsPorId(id) == null) {
            return new ResponseEntity<>("Skills no encontrada", HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(skill.getNombreSkill())
    
                && skill.getPorcentaje() <= 0) {

            return new ResponseEntity<>("Campos obligatorios vacios o incorrectos.", HttpStatus.BAD_REQUEST);
        }

        hys nuevaSkill = ihysS.traerSkillsPorId(id);

        nuevaSkill.setNombreSkill(skill.getNombreSkill());
        nuevaSkill.setPorcentaje(skill.getPorcentaje());
    

        ihysS.saveSkills(nuevaSkill);

        return new ResponseEntity<>(nuevaSkill, HttpStatus.OK);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrarSkills(@PathVariable int id) {

        if (ihysS.traerSkillsPorId(id) == null) {
            return new ResponseEntity<>("Skill no encontrada", HttpStatus.NOT_FOUND);
        }
        ihysS.deleteSkills(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

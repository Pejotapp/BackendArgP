
package com.portfolio.pjp.Service;

import com.portfolio.pjp.Entity.hys;
import com.portfolio.pjp.Repository.Rhys;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Transactional
@Service
public class Shys implements IhysS{
    @Autowired
    Rhys rhys;
    
@Override
    public void deleteSkills(int id) {
        rhys.deleteById(id);
    }

    @Override
    public void saveSkills(hys skill) {
        rhys.save(skill);   
    }

    @Override
    public List<hys> traerSkills() {
        List<hys> skills = rhys.findAll();
        return skills;
    }

    @Override
    public hys traerSkillsPorId(int id) {
        hys skill = rhys.findById(id).orElse(null);
        return skill;
    }
    
}

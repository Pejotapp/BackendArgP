
package com.portfolio.pjp.Service;

import com.portfolio.pjp.Entity.hys;
import java.util.List;


public interface IhysS {
    
    public void saveSkills(hys skills);

    public void deleteSkills(int id);

    public List<hys> traerSkills();

    public hys traerSkillsPorId(int id);

    
    
}

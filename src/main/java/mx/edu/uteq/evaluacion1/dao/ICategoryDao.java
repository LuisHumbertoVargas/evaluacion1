
package mx.edu.uteq.evaluacion1.dao;

import mx.edu.uteq.evaluacion1.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryDao extends JpaRepository<Category, Long>{
    
}

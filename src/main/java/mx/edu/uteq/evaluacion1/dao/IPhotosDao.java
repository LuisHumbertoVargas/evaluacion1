
package mx.edu.uteq.evaluacion1.dao;

import mx.edu.uteq.evaluacion1.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPhotosDao extends JpaRepository<Photo, Long>{
    
}

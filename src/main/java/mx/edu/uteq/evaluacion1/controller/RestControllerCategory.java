
package mx.edu.uteq.evaluacion1.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import mx.edu.uteq.evaluacion1.dao.ICategoryDao;
import mx.edu.uteq.evaluacion1.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/")
public class RestControllerCategory {
    
    @Autowired
    private ICategoryDao categoryDao;
    
    @GetMapping("/categorias")
    public List<Category> list() {
        return categoryDao.findAll();
    }
    
    @GetMapping("/categorias/{id}")
    public Category get(@PathVariable Long id) {
        return categoryDao.findById(id).orElse(null);
    }
    
    @PutMapping("/categorias/{id}")
    public ResponseEntity<Category> put(@PathVariable Long id, @RequestBody Category category) {
        
        Category currentCategory = categoryDao.findById(id).orElse(null);
        
        if (currentCategory == null) {
            return new ResponseEntity<>(currentCategory, HttpStatus.NOT_FOUND);
        }
        
        currentCategory.setNameCategory(category.getNameCategory());
        currentCategory.setStatus(true);
        
        Category updatedCategory = categoryDao.save(currentCategory);
        HttpStatus generatedStatus = HttpStatus.CREATED;
        
        return new ResponseEntity<>(updatedCategory, generatedStatus);
    }
    
    @PostMapping("/categorias")
    public ResponseEntity<Category> post(@RequestBody Category category) {
        return new ResponseEntity<>(categoryDao.save(category), HttpStatus.CREATED);
    }
    
    @DeleteMapping("/categorias/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
    
}

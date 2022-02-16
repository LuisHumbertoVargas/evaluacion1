
package mx.edu.uteq.evaluacion1.controller;

import java.util.Date;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import mx.edu.uteq.evaluacion1.dao.IPhotosDao;
import mx.edu.uteq.evaluacion1.model.Photo;
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
public class RestControllerPhoto {
    
    @Autowired
    private IPhotosDao photoDao;
    
    @GetMapping("/fotos")
    public List<Photo> list() {
        return photoDao.findAll();
    }
    
    @GetMapping("/fotos/{id}")
    public Photo get(@PathVariable Long id) {
        return photoDao.findById(id).orElse(null);
    }
    
    @PutMapping("/fotos/{id}")
    public ResponseEntity<Photo> put(@PathVariable Long id, @RequestBody Photo photo) {
        
        Photo currentPhoto = photoDao.findById(id).orElse(null);
        
        if (currentPhoto == null) {
            return new ResponseEntity<>(currentPhoto, HttpStatus.NOT_FOUND);
        }
        
        currentPhoto.setTitle(photo.getTitle());
        currentPhoto.setUrl(photo.getUrl());
        currentPhoto.setStatus(true);
        currentPhoto.setLastTime(new Date());
        
        Photo updatedPhoto = photoDao.save(currentPhoto);
        HttpStatus generatedStatus = HttpStatus.CREATED;
        
        return new ResponseEntity<>(updatedPhoto, generatedStatus);
    }
    
    @PostMapping("/fotos")
    public ResponseEntity<Photo> post(@RequestBody Photo photo) {
        return new ResponseEntity<>(photoDao.save(photo), HttpStatus.CREATED);
    }
    
    @DeleteMapping("/fotos/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        photoDao.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
    
}

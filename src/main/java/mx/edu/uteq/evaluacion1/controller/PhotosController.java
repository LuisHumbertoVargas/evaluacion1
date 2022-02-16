
package mx.edu.uteq.evaluacion1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
public class PhotosController {
    
    @RequestMapping("/photos")
    public String page(Model model) {
        //model.addAttribute("attribute", "value");
        return "/views/photos";
    }
    
    @ExceptionHandler({Exception.class})
    public String databaseError() {
        return "/helpers/error";
    }
    
}

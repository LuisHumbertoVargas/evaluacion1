
package mx.edu.uteq.evaluacion1.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name = "category")
public class Category implements Serializable {

    static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_category")
    private Long idCategory;
    
    @NotNull
    @Min(2)
    @Size(max = 50)
    @Column(name = "nameCategory")
    private String nameCategory;
    
    @Column(name = "status")
    private boolean status;


}

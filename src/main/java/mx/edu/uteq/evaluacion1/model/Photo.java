
package mx.edu.uteq.evaluacion1.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "photo")
public class Photo implements Serializable {
    
    static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id;
    
    @NotEmpty
    @Min(2)
    @Size(max = 50)
    @Column(name = "title")
    private String title;

    @NotEmpty
    @Min(1)
    @Size(max = 255)
    @Column(name = "url")
    private String url;
    
    @Column(name = "status")
    private boolean status;
    
    @Column(name = "lastTime")
    @Temporal(TemporalType.DATE)
    private Date lastTime;
    
    @PrePersist
    public void prePersist() {
        lastTime = new Date();
    }
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_category")
    private Category category;

    
}

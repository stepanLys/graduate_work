package stepan.lys.gw.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;


@Setter
@Getter
@NoArgsConstructor

@Entity
public class Book extends Basic {

//    {
//        "title":"test title",
//        "author":"test author",
//        "price":179.99,
//        "description":"it is just description about book"
//    }

    private String title;
    private String author;
    private BigDecimal price;
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "image_url")
    private String imageUrl;
}

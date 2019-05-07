package stepan.lys.gw.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;


@Setter
@Getter
@NoArgsConstructor

@Entity
@Table
public class Book extends Basic {

//    {
//        "title":"test title 2",
//            "price":179.99,
//            "description":"it is just description about book",
//
//            "author": {
//        "id": 2,
//                "firstName": "name",
//                "lastName": "last name"
//    }
//    }

    private String title;
    private BigDecimal price;
    private String description;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "book_category",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"))
    private Set<Category> categories = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false, updatable = false)
    private Author author;
}

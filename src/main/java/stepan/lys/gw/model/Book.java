package stepan.lys.gw.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Setter
@Getter
@NoArgsConstructor

@ToString
@EqualsAndHashCode(exclude = "genres", callSuper = true)

@Entity
@Table
public class Book extends Basic {

//    {
//        "title":"test tit1le 2",
//            "price":179.99,
//            "description":"it is just description about book",
//            "genresId": [1],
//        "author":{
//        "id":1
//    }
//    }

    @NotNull
    private String title;
    @NotNull
    private BigDecimal price;
    @NotNull
    private String description;

//    @NotNull
//    @ElementCollection(targetClass = Genre.class)
//    @Column(name = "genre_id")
//    private Set<Genre> genres = new HashSet<>();

    @NotNull
    @ManyToMany
    @JoinTable(name = "book_genre",
        joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<Genre> genres = new HashSet<>();

    @NotNull
    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false, updatable = false)
    private Author author;

    public Book(@NotNull String title,
                @NotNull BigDecimal price,
                @NotNull String description,
                @NotNull Author author,
                @NotNull Genre... genres) {

        this.title = title;
        this.price = price;
        this.description = description;
        this.author = author;

        this.genres = Stream.of(genres).collect(Collectors.toSet());
        this.genres.forEach(x -> x.getBooks().add(this));
    }
}

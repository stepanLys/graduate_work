package stepan.lys.gw.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@ToString


@Entity
public class Genre extends Basic{

    @NotNull
    @Column(unique = true)
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "genres")
    private Set<Book> books;
}

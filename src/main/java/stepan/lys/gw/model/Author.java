package stepan.lys.gw.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table
public class Author extends Basic {

    @NotNull
    private String name;
    @NotNull
    private String surname;

}

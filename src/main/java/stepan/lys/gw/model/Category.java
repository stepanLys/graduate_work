package stepan.lys.gw.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Setter
@Getter
@NoArgsConstructor

@Entity
public class Category extends Basic{

    private String name;

}

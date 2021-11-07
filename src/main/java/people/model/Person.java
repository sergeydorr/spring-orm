package people.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// BEGIN
@Entity
@Table(name = "person")
// END
public class Person {

    // BEGIN
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private Long id;
    // END

    @Getter @Setter private String firstName;
    @Getter @Setter private String lastName;
}

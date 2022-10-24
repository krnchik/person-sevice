package liga.medical.personservice.core.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "contact")
public class Contact {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "email", length = 32, nullable = false)
    private String phoneNumber;

    @Column(name = "email", length = 128, nullable = false)
    private String email;

    @Column(name = "profile_link")
    private String profileLink;

    @OneToMany(mappedBy = "address")
    private List<Address> addresses;

    @OneToMany(mappedBy = "person_data")
    private List<PersonData> personData;
}

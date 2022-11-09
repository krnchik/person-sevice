package liga.medical.personservice.core.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "contact", schema = "medical")
public class Contact {

    @Id
    private long id;

    @Column(name = "phone_number", length = 32)
    private String phoneNumber;

    @Column(name = "email", length = 128)
    private String email;

    @Column(name = "profile_link")
    private String profileLink;

    @OneToMany(mappedBy = "contact")
    private List<Address> addresses;

    @OneToMany(mappedBy = "contact")
    private List<PersonData> personData;
}

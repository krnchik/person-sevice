package liga.medical.personservice.core.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.GeneratedValue;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "person_data")
public class PersonData {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "birth_dt", nullable = false)
    private java.sql.Date birthDt;

    @Column(name = "age", nullable = false)
    private long age;

    @Column(name = "sex", nullable = false)
    private String sex;

    @ManyToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;

    @ManyToOne
    @JoinColumn(name = "medical_card_id")
    private MedicalCard medicalCard;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private PersonData personData;

    @OneToMany(mappedBy = "person_data")
    private List<PersonData> personDatalist;
}

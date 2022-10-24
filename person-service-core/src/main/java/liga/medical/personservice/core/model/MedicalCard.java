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
@Table(name = "medical_card")
public class MedicalCard {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "client_status", nullable = false)
    private String clientStatus;

    @Column(name = "med_status")
    private String medStatus;

    @Column(name = "registry_dt", nullable = false)
    private java.sql.Date registryDt;

    @Column(name = "comment")
    private String comment;

    @OneToMany(mappedBy = "illness")
    private List<Illness> illnesses;

    @OneToMany(mappedBy = "person_data")
    private List<PersonData> personData;
}

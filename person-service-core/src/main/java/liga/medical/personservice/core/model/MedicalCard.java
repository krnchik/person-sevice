package liga.medical.personservice.core.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "medical_card", schema = "medical")
public class MedicalCard {

    @Id
    private long id;

    @Column(name = "client_status", length = 1)
    private String clientStatus;

    @Column(name = "med_status", length = 1)
    private String medStatus;

    @Column(name = "registry_dt")
    private java.sql.Date registryDt;

    @Column(name = "comment")
    private String comment;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "medicalCard")
    private Set<Illness> illnesses;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "medicalCard")
    private Set<PersonData> personData;
}

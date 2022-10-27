package liga.medical.personservice.core.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@Table(name = "illness")
public class Illness {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "type_id")
    private long typeId;

    @Column(name = "heaviness")
    private String heaviness;

    @Column(name = "appearance_dttm")
    private java.sql.Timestamp appearanceDttm;

    @Column(name = "recovery_dt")
    private java.sql.Date recoveryDt;

    @ManyToOne
    @JoinColumn(name = "medical_card_id", referencedColumnName = "id")
    private MedicalCard medicalCard;
}

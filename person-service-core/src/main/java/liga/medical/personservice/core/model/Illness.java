package liga.medical.personservice.core.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.GeneratedValue;

@Entity
@Data
@NoArgsConstructor
@Table(name = "illness")
public class Illness {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "type_id", nullable = false)
    private long typeId;

    @Column(name = "heaviness", nullable = false)
    private String heaviness;

    @Column(name = "appearance_dttm", nullable = false)
    private java.sql.Timestamp appearanceDttm;

    @Column(name = "recovery_dt", nullable = false)
    private java.sql.Date recoveryDt;

    @ManyToOne
    @JoinColumn(name = "medical_card_id")
    private MedicalCard medicalCard;
}

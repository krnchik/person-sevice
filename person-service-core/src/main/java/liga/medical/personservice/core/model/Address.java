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
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "country_id", nullable = false)
    private long countryId;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "index", nullable = false)
    private long index;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "building", nullable = false, length = 32)
    private String building;

    @Column(name = "flat", length = 32)
    private String flat;

    @ManyToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;
}

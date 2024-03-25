package ru.popov.customerservice.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.popov.customerservice.converters.SexConverter;
import ru.popov.customerservice.support.Sex;
import jakarta.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull(message = "You should specify registred address")
    @JoinColumn(name = "registred_address_id", referencedColumnName = "id", nullable = false)
    private Address registredAddress;

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull(message = "You should specify actual address")
    @JoinColumn(name = "actual_address_id", referencedColumnName = "id", nullable = false)
    private Address actualAddress;

    @Column(name="first_name")
    @NotNull(message = "You should specify first name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="middle_name")
    private String middleName;

    @Column(name="sex")
    @NotNull(message = "You should specify sex")
    @Convert(converter = SexConverter.class)
    private Sex sex;
}
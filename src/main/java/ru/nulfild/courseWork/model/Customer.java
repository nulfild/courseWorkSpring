package ru.nulfild.courseWork.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "сustomers")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Customer {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @ManyToOne
    @JoinColumn(name = "laundress_id", referencedColumnName = "id")
    @JsonBackReference
    private Laundress laundress;


    @ManyToOne
    @JoinColumn(name = "personalManager_id", referencedColumnName = "id")
    @JsonBackReference
    private PersonalManager personalManager;


    @NotEmpty(message = "Имя не должно быть пустым")
    @Column(name = "full_name")
    private String fullName;

    @NotEmpty(message = "Дата рождения не должна быть пустой")
    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @OneToOne(mappedBy = "customer")
    @JsonBackReference
    private Subscription subscription;

    public Customer(Laundress laundress, PersonalManager personalManager, String fullName, String dateOfBirth) {
        this.laundress = laundress;
        this.personalManager = personalManager;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
    }
}

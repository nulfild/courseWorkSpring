package ru.nulfild.courseWork.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "personal_managers")
@Setter
@Getter
@NoArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class PersonalManager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Имя не должно быть пустым")
    @Column(name = "full_name")
    private String fullName;


    @Column(name = "academic_rank")
    private String rating;


    @OneToMany(mappedBy = "personalManager", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Customer> customers;

    public PersonalManager(String fullName, String rating) {
        this.fullName = fullName;
        this.rating = rating;
    }
}

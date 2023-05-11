package ru.nulfild.courseWork.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Laundress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Имя не должно быть пустым")
    @Column(name = "full_name")
    private String fullName;

    @NotEmpty(message = "Дата рождения не должна быть пустой")
    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Column(name = "work_experience")
    private int workExp;

    @Column(name = "level")
    private String level;
    @JsonManagedReference
    @OneToMany(mappedBy = "laundress", fetch = FetchType.LAZY)
    private List<Customer> customers;

    public Laundress(String fullName, String dateOfBirth, int workExp, String level) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.workExp = workExp;
        this.level = level;
    }
}

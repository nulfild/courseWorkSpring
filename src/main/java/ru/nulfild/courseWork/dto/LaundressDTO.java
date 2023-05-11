package ru.nulfild.courseWork.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

@Setter
@Getter
public class LaundressDTO {
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
}


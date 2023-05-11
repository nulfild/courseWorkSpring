package ru.nulfild.courseWork.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Setter
@Getter
public class CustomerDTO {

    private int laundressId;

    private int personalManagerId;
    @NotEmpty(message = "Имя не должно быть пустым")
    private String fullName;

    @NotEmpty(message = "Дата рождения не должна быть пустой")
    private String dateOfBirth;


    @Override
    public String toString() {
        return "ClientDTO{" +
                "laundressId=" + laundressId +
                ", personalManagerId=" + personalManagerId +
                ", fullName='" + fullName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }
}


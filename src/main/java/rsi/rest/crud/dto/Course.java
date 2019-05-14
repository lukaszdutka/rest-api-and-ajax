package rsi.rest.crud.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
class Course {

    private String name;

    private String description;

    private int ectsPoints;
}

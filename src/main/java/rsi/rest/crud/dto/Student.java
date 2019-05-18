package rsi.rest.crud.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {

    private Long id;

    private String firstName;

    private String lastName;

}

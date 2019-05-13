package rsi.rest.crud.to;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
class Spell {

    private final String name;

    private final String description;

    private final int power;
}

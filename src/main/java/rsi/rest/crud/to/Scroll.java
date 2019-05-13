package rsi.rest.crud.to;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Scroll {

    private Long id;

    private List<Spell> spells = new ArrayList<>();
}

package com.beleco.gameofwar.rest.util;

import com.beleco.gameofwar.domain.domain.Dot;
import org.springframework.stereotype.Component;

/**
 * Created by Everdark on 24.06.2017.
 */
@Component
public class DotRandomizer extends EnumRandomizer<Dot>{
    public DotRandomizer() {
        super(Dot.class);
    }
}

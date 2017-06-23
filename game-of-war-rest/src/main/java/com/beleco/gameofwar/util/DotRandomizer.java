package com.beleco.gameofwar.util;

import com.beleco.gameofwar.domain.game.Dot;
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

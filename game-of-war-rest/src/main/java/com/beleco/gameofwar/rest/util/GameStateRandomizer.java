package com.beleco.gameofwar.rest.util;

import com.beleco.gameofwar.domain.domain.GameState;
import org.springframework.stereotype.Component;

/**
 * Created by Everdark on 24.06.2017.
 */
@Component
public class GameStateRandomizer extends EnumRandomizer<GameState.GameStateEnumerable>{
    public GameStateRandomizer() {
        super(GameState.GameStateEnumerable.class);
    }
}

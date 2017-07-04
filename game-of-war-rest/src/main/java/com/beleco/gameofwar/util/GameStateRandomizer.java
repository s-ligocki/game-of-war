package com.beleco.gameofwar.util;

import com.beleco.gameofwar.domain.game.GameState;
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

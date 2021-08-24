package ru.alexn.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;


import ru.alexn.base.Sprite;
import ru.alexn.math.Rect;

public class GameOver extends Sprite {

    private  static  final  float HEIGHT=0.08f;
    private static final float BOTTOM_MARGIN=0.009f;

    public GameOver(TextureAtlas atlas) {
        super(atlas.findRegion("message_game_over"));
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(HEIGHT);
        setBottom(BOTTOM_MARGIN);
    }
}

package ru.alexn.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.alexn.base.Sprite;
import ru.alexn.math.Rect;

public class Logo extends Sprite {

    private  static  final  float V_LEN=0.001f;

    private Vector2 touch;
    private Vector2 v;



    public Logo(Texture texture) {
        super (new TextureRegion(texture));
        this.touch=new Vector2();
        this.v=new Vector2();
    }

    @Override
    public void update(float delta) {
        if(touch.dst(pos)>V_LEN) {
            pos.add(v);
        }else{
            pos.set(touch);
        }
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.3f);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        this.touch.set(touch);
        v.set(touch.cpy().sub(pos)).setLength(V_LEN);
        return false;
    }
}

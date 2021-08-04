package ru.alexn.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;


import ru.alexn.base.BaseScreen;

public class MenuScreen extends BaseScreen {

    private static  final float V_LEN = 0.65f;

    private Texture img;
    private Vector2 touch;
    private Vector2 pos;
    private Vector2 v;
    private Vector2 tmp;


    @Override
    public void show() {
        super.show();
        img = new Texture("badlogic.jpg");
        touch = new Vector2();
        pos = new Vector2();
        v = new Vector2();
        tmp = new Vector2();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        batch.draw(img,pos.x,pos.y);
        batch.end();
        tmp.set(touch);
        if(tmp.sub(pos).len()>V_LEN){
            pos.add(v);
        }else {
            pos.set(touch);
        }

    }

    @Override
    public void dispose() {
        super.dispose();
        img.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        touch.set(screenX, Gdx.graphics.getHeight()-screenY);
        v.set(touch.cpy().sub(pos)).setLength(V_LEN);
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        pos.set(screenX, Gdx.graphics.getHeight() - screenY);
        return false;
    }
}

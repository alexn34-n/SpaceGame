package ru.alexn.screen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.alexn.base.BaseScreen;
import ru.alexn.math.Rect;
import ru.alexn.sprite.Background;
import ru.alexn.sprite.Logo;

public class MenuScreen extends BaseScreen {

    private Texture bg;
    private Background background;

    private Texture img;
    private Logo logo;

    //private Vector2 pos;

    @Override
    public void show() {
        super.show();
        bg = new Texture("textures/bg.png");
        background = new Background(bg);
        img=new Texture("badlogic.jpg");
        logo=new Logo(img);
        //pos = new Vector2();
    }

    @Override
    public void resize(Rect worldBounds) {
        background.resize(worldBounds);
        logo.resize(worldBounds);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update(delta);
        draw();

    }

    @Override
    public void dispose() {
        super.dispose();
        bg.dispose();
        img.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        logo.touchDown(touch,pointer,button);
        return false;
    }

    private void  update (float delta){
        logo.update(delta);
    }

    private  void  draw(){
        batch.begin();
        background.draw(batch);
        logo.draw(batch);
        batch.end();
    }
}

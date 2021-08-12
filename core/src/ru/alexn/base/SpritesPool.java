package ru.alexn.base;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

public abstract class SpritesPool<T extends Sprite> {

    protected final List<T> activeSprites = new ArrayList<>();
    protected final List<T> freeSprites = new ArrayList<>();

    protected abstract T newSprite();

    public T obtain() {
        T sprite;
        if (freeSprites.isEmpty()) {
            sprite = newSprite();
        } else {
            sprite = freeSprites.remove(freeSprites.size() - 1);
        }
        activeSprites.add(sprite);
        System.out.println(getClass().getName() + " active/free : " + activeSprites.size() + "/" + freeSprites.size());
        return sprite;
    }

    public void updateActiveSprites(float delta) {
        for (Sprite sprite : activeSprites) {
            if (!sprite.isDestroyed()) {
                sprite.update(delta);
            }
        }
    }

    public void drawActiveSprites(SpriteBatch batch) {
        for (Sprite sprite : activeSprites) {
            if (!sprite.isDestroyed()) {
                sprite.draw(batch);
            }
        }
    }

    public void freeAllDestroyedActiveSprites() {
        for (int i = 0; i < activeSprites.size(); i++) {
            T sprite = activeSprites.get(i);
            if (sprite.isDestroyed()) {
                free(sprite);
                i--;
                sprite.flushDestroy();
            }
        }
    }

    private void free(T sprite) {
        if (activeSprites.remove(sprite)) {
            freeSprites.add(sprite);
            System.out.println(getClass().getName() + " active/free : " + activeSprites.size() + "/" + freeSprites.size());
        }
    }

    public void dispose() {
        activeSprites.clear();
        freeSprites.clear();
    }

    public List<T> getActiveSprites() {
        return activeSprites;
    }

}
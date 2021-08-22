package ru.alexn.pool;

import ru.alexn.base.SpritesPool;
import ru.alexn.sprite.Bullet;

public class BulletPool extends SpritesPool<Bullet> {

    @Override
    protected Bullet newSprite() {
        return new Bullet();
    }
}
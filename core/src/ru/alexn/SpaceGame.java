package ru.alexn;

import com.badlogic.gdx.Game;

import ru.alexn.screen.MenuScreen;

public class SpaceGame extends Game {
	
	@Override
	public void create () {
		setScreen(new MenuScreen());
	}

}

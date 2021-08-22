package ru.alexn;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

public class SpaceGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	TextureRegion region;


//	private int  x=0;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
	//	region=new TextureRegion(img,25,25,100,50);

		Vector2 v1= new Vector2(3,3);
		Vector2 v2= new Vector2();
		v2.set(2,1);

		v1.add(v2);
		System.out.println("v1.add(v2),v1.x= "+v1.x+" v1.y= "+v1.y);


		v1.set(7,7);
		v2.set(3,1);
		v1.sub(v2);

		System.out.println("v1.sub(v2),v1.x= "+v1.x+" v1.y= "+v1.y);
		System.out.println("v1.len()= "+v1.len());

		v1.scl(0.5f);
		System.out.println("v1.len() after scl = "+v1.len());
		v1.nor();
		System.out.println("v1.len() after nor = "+v1.len());

		System.out.println("v2.x= "+v2.x+" v2.y= "+v2.y);
		v2.cpy().add(v1);
		System.out.println("v2.x= "+v2.x+" v2.y= "+v2.y);

		v1.set(1,1);
		v2.set(-1,1);
		v1.nor();
		v2.nor();
		System.out.println(Math.acos(v1.dot(v2)));
	}

	@Override
	public void render () {
		//x++;
		ScreenUtils.clear(0.4f, 0.24f, 0.51f, 1);
		batch.begin();
		batch.draw(img, 0, 0);
	    //batch.setColor(0.56f,0.32f,0.67f,0.5f);
		batch.draw(img,0,0,0,0);
	//	batch.setColor(1f,1f,1f,1f);
		//batch.draw(region,230,50,100,50);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}

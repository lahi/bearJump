package com.soo.bearJump.core;

import static playn.core.PlayN.*;

import playn.core.Game;
import playn.core.ImmediateLayer;

import playn.core.Surface;
import playn.core.Pointer;

public class BearGame implements Game {
	private ImmediateLayer gameLayer;
	private BearWorld world;
	
	private float frameAlpha;
	private BearObject catGirl;
	
	private boolean controlJump;
	
  @Override
  public void init() {
	
	//drag
	pointer().setListener(new Pointer.Listener() {
	      @Override
	      public void onPointerEnd(Pointer.Event event) {
	        controlJump = true;
	      }
	      @Override
	      public void onPointerCancel(Pointer.Event event) {
	       
	      }
	      @Override
	      public void onPointerDrag(Pointer.Event event) {
	        
	      }
	      @Override
	      public void onPointerStart(Pointer.Event event) {
	        
	      }
	    });
	  
	// create world
	world = new BearWorld(60, 16);
	
	// Grass.
    for (int y = 0; y < 16; ++y) {
      for (int x = 0; x < 60; ++x) {
        world.addTile(x, y, 0);	//0은 타일 타입 
      }
    }
    
    // create an immediate layer that handles all of our rendering
    gameLayer = graphics().createImmediateLayer(new ImmediateLayer.Renderer() {
      public void render(Surface surface) {
        world.setViewOrigin(catGirl.x(frameAlpha), catGirl.y(frameAlpha), catGirl.z(frameAlpha));
        surface.clear();
        world.paint(surface, frameAlpha);
      }
    });
    graphics().rootLayer().add(gameLayer);

    initStuff();
  }
  
  private void initStuff ()
  {
	  catGirl = new BearObject(assets().getImage("images/character_cat_girl.png"));
	  catGirl.setPos(2, 4, 1);
	  catGirl.r = 0.3;
	  world.addObject(catGirl);
	  
	  //block
	  world.addTile(6, 4, 1);
	  world.addTile(17, 4, 1);
	  world.addTile(20, 4, 1);
	  world.addTile(30, 4, 1);
	  world.addTile(50, 4, 1);
  }

  @Override
  public void paint(float alpha) {
	frameAlpha = 1;
	  
    // the background automatically paints itself, so no need to do anything here!
  }

  @Override
  public void update(float delta) {
	  if (world == null) {
	      return;
	    }

	   catGirl.setAcceleration(0, 0, 0);
	   catGirl.ax = 1.0;
	   
	    // Jump Control.
	    if (controlJump) {
	      catGirl.vz = 0.2;
	      controlJump = false;
	    }
	      
	   world.updatePhysics(delta / 1000);
  }

  @Override
  public int updateRate() {
    return 40;
  }
}

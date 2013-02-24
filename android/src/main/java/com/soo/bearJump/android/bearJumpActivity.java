package com.soo.bearJump.android;

import playn.android.GameActivity;
import playn.core.PlayN;

import com.soo.bearJump.core.BearGame;

public class bearJumpActivity extends GameActivity {

  @Override
  public void main(){
    platform().assets().setPathPrefix("com/soo/bearJump/resources");
    PlayN.run(new BearGame());
  }
}

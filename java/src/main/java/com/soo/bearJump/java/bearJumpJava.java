package com.soo.bearJump.java;

import playn.core.PlayN;
import playn.java.JavaPlatform;

import com.soo.bearJump.core.BearGame;

public class bearJumpJava {

  public static void main(String[] args) {
    JavaPlatform platform = JavaPlatform.register();
    platform.assets().setPathPrefix("com/soo/bearJump/resources");
    PlayN.run(new BearGame());
  }
}

package com.soo.bearJump.html;

import playn.core.PlayN;
import playn.html.HtmlGame;
import playn.html.HtmlPlatform;

import com.soo.bearJump.core.BearGame;

public class bearJumpHtml extends HtmlGame {

  @Override
  public void start() {
    HtmlPlatform platform = HtmlPlatform.register();
    platform.assets().setPathPrefix("bearJump/");
    PlayN.run(new BearGame());
  }
}

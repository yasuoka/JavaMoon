/*
 * MoonCalc.java
 * Copyright (c) 1996 M.Yasuoka all rights reserved.
 * 
 * Permission to use, copy, modify, distribute, and sell this software and its
 * documentation for any purpose is hereby granted without fee, provided that
 * the above copyright notice appear in all copies and that both that
 * copyright notice and this permission notice appear in supporting
 * documentation, and that the name of Waseda University not be used
 * in advertising or publicity pertaining to distribution of
 * the software without specific, written prior permission.
 * Waseda University makes no representations about the
 * suitability of this software for any purpose.  It is provided "as is"
 * without express or implied warranty.
 *
 */


import java.applet.*;
import java.awt.*;
import java.util.*;
import MoonCalc;

public class Moon extends Applet
{
  Image image;
  double frac, theta;
  MoonCalc mc;
  boolean mdate=false;
	
  public void init(){
    //setFont(new Font("Helvetica", Font.PLAIN, 20));

    mc = new MoonCalc(MoonCalc.jtime(MoonCalc.getGMT()));

    theta = Math.PI * mc.angle * 2;
    frac  = Math.cos(theta);	

    setForeground(Color.white);
    setBackground(Color.black);

    image = getImage(getDocumentBase(), "moon.gif");
    try {
      MediaTracker trkR = new MediaTracker(this);
      trkR.addImage(image, 1);
      trkR.waitForID(1);
    } catch (Exception e){ };
  }

  public boolean mouseDown(Event e, int x, int y) {
    mdate = true;
    repaint();
    return true;
  }

  public boolean mouseUp(Event e, int x, int y) {
    mdate = false;
    repaint();
    return true;
  }

   public void update(Graphics g){
    paint(g);
  }


  public void destroy() {
    image.flush();
  }

  public void paint(Graphics g){
    int cy;

    if (mdate == true) {
      g.clearRect(0, 0, 256, 256);
      // g.drawString("Moon age is " +  mc.mage, 10, 128);
      g.drawString("åéóÓÇÕÅA" +  mc.mage + "ì˙Ç≈Ç∑", 10, 128);

      return;
    }
    g.drawImage(image, 0, 0, this);		
    
    g.setColor(Color.black);
    for (cy=0; cy < 256; cy++) {
      double y  = 128.0 - cy;
      double x  = frac*Math.sqrt(16384.0 - y*y);
      Double ox = new Double(x);
      
      if (Math.sin(theta) >= 0) {
	g.drawLine(0, cy, ox.intValue() + 128, cy);
      } else {
	g.drawLine(128-ox.intValue(), cy, 256, cy);
      }  
    }
  }
}

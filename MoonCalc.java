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

import java.util.*;

class MoonCalc {
  private final static double epoch    = 2444238.5;
  private final static double synmonth = 29.53058868;
  private final static double mmlong   = 64.975464;
  private final static double mmlongp  = 349.383063;
  private final static double elonge   = 278.833540;
  private final static double elongp   = 282.596403;
  private final static double EPSILON  = 1.0E-6;
  private final static double eccent   = 0.016718;
  public static double pphase;
  public static double mage;
  public static double angle;

  private static double fixangle(double a) {
    return a - 360 * (Math.floor(a  / 360));
  }

  private static double torad(double d) {
    return d * (Math.PI / 180.0);
  }

  private static double todeg(double r) {
    return r * (180 / Math.PI);
  }

  private static double kepler(double m, double ecc) {
    double e, delta;
    
    e = m = torad(m);
    do {
      delta = e - ecc * Math.sin(e) - m;
      e -= delta / (1 - ecc * Math.cos(e));
    } while (Math.abs(delta) > EPSILON);
    return e;
  }

  public MoonCalc (double pdate) {
    double Day, M, N, Lambdasun, ml, MM, Ec, Ev, Ae, MmP, mEc, A3, A4, lP, V,
           lPP, MoonAge;

    Day  = pdate - epoch;
    N   = fixangle((360.0 / 365.2422) * Day);
    M   = fixangle(N + elonge - elongp);
    Ec  = kepler(M, eccent);
    Ec  = Math.sqrt((1 + eccent) / (1 - eccent)) * Math.tan(Ec / 2);
    Ec  = 2 * todeg(Math.atan(Ec));
    Lambdasun = fixangle(Ec + elongp);
    ml  = fixangle(13.1763966 * Day + mmlong);
    MM  = fixangle(ml - 0.1114041 * Day - mmlongp);
    Ev  = 1.2739 * Math.sin(torad(2 * (ml - Lambdasun) - MM));
    Ae  = 0.1858 * Math.sin(torad(M));
    A3  = 0.37 * Math.sin(torad(M));
    MmP = MM + Ev - Ae - A3;
    mEc = 6.2886 * Math.sin(torad(MmP));
    A4  = 0.214 * Math.sin(torad(2 * MmP));
    lP  = ml + Ev + mEc - Ae + A4;
    V   = 0.6583 * Math.sin(torad(2 * (lP - Lambdasun)));
    lPP = lP + V;
    MoonAge   = lPP - Lambdasun;

    pphase = (1 - Math.cos(torad(MoonAge))) / 2;
    mage = synmonth * (fixangle(MoonAge) / 360.0);
    angle = fixangle(MoonAge) / 360.0;
  }

  public static Date getGMT() {
    // GMT ¤òµá¤á¤ë
    Date gmt = new Date();
    int tz = (gmt.getTimezoneOffset()-1)/60;
    gmt.setHours(gmt.getHours()+tz);
    return gmt;
  }

  public static long jdate(Date gmt) {
    long c, m, y;

    y = gmt.getYear() + 1900;
    m = gmt.getMonth() + 1;
    if (m > 2)
      m -= 3;
    else {
      m += 9;
      y--;
    }
    c = y / 100L;     // Compute century
    y -= 100L * c;
    return gmt.getDate() + (c * 146097L) / 4 + (y * 1461L) / 4 +
      (m * 153L + 2) / 5 + 1721119L;
  }

  public static double jtime(Date gmt) {
    return (jdate(gmt) - 0.5) + 
	   (gmt.getSeconds() + 60 * (gmt.getMinutes() + 60 *
				     gmt.getHours()))
	     / 86400.0;
  }
}

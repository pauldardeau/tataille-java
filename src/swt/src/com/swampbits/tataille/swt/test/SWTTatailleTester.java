/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swampbits.tataille.swt.test;

import com.swampbits.tataille.swt.SWTDisplayEngine;
import com.swampbits.tataille.test.TatailleTester;


/**
 *
 * @author paul
 */
public class SWTTatailleTester extends TatailleTester {

   public SWTTatailleTester(SWTDisplayEngine de) {
      super(de);
   }
   
   public static void main(String[] args) {
      int width = 650;
      int height = 450;
      String title = "SWTTatailleTester";
      
      SWTTatailleTester tester =
              new SWTTatailleTester(new SWTDisplayEngine(width, height, title));
      tester.run();
   }
}

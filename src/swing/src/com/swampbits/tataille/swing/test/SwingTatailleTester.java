/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swampbits.tataille.swing.test;

import com.swampbits.tataille.swing.SwingDisplayEngine;
import com.swampbits.tataille.test.TatailleTester;


/**
 *
 * @author paul
 */
public class SwingTatailleTester extends TatailleTester {

   public SwingTatailleTester(SwingDisplayEngine de) {
      super(de);
   }
   
   public static void main(String[] args) {
      int width = 650;
      int height = 450;
      String title = "SwingTatailleTester";
      
      SwingTatailleTester tester =
              new SwingTatailleTester(new SwingDisplayEngine(width, height, title));
      tester.run();
   }
}

package com.dydko.treedatastructure.swing;

import javax.swing.*;
class Tree{
   public static void main(String args[]){
      JFrame frame = new JFrame("Collections");


      String[] branches = {"Sets", "Lists", "Queue"};
      JTree MyTree = new JTree(branches);


      frame.add(MyTree);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(400,400);  
      frame.setVisible(true);
   }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hectorJogo;

import hectorJogo.Modelo.Fase;
import hectorJogo.Modelo.Player;
import javax.swing.JFrame;

/**
 *
 * @author user
 */
public class Base extends JFrame {
   
    public Base() {
    add(new Fase());
    setTitle("Hector's Game");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    setSize(1024, 720);
    this.setResizable(false);
    setVisible(true);
}
    public static void main(String[] args) {
        new Base();
    }

    private void add(Player player) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

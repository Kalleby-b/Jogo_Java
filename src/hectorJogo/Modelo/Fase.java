/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hectorJogo.Modelo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Fase extends JPanel implements ActionListener{
    private Image fundo;
    private Player player;
    private Timer timer;

    
    public Fase() {
       setFocusable(true);
       setDoubleBuffered(true);
        
       ImageIcon imagens = new ImageIcon("imagens\\Black.png");
       fundo = imagens.getImage();
       
       player = new Player();
       player.roupa();
       
       addKeyListener(new TecladoAdapter());
       
       timer = new Timer(5 , this);
       timer.start();
    }
    public void paint (Graphics g){
        Graphics2D graficos = (Graphics2D) g;
        graficos.drawImage(fundo, 0, 0, null);
        graficos.drawImage(player.getImage(), player.getXm(), player.getYm(), this);

        List<Tiro> tiros = player.getTiros();
        for(int i = 0; i< tiros.size(); i++ ){
           Tiro n = tiros.get(i);
           n.load();
           graficos.drawImage(n.getImagem(), n.getX(), n.getY(), this);
                }

        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       player.mover();
      
       List<Tiro> tiros = player.getTiros();
        for(int i = 0; i< tiros.size();i++){
            Tiro m = tiros.get(i);
                if (m.Isvisible() == true){
                    m.update();
                }else{
                    tiros.remove(i);
                }

        }
       repaint();
    }
    
    
    private class TecladoAdapter extends KeyAdapter{
        
        @Override
        public void keyPressed(KeyEvent e){
            player.teclaPressionada(e);
        }
        
        @Override
        public void keyReleased(KeyEvent f){
            player.teclaLivre(f);
        }
        
        
    }
}
    

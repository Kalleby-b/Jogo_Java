/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hectorJogo.Modelo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Fase extends JPanel implements ActionListener{
    private Image fundo;
    private Player player;
    private Timer timer;
    private List<Inimigo> inimigos;
    private boolean EmJogo;

    
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

       IniciaInimigo();
       EmJogo = true;


    }

    public void IniciaInimigo(){
        int coordenadas []= new int[40];
        inimigos = new ArrayList<Inimigo>();

        for(int i = 0; i < coordenadas.length; i ++){
            int x = (int) (Math.random() * 8000 +1024);
            int y = (int) (Math.random() * 650  +30);
            inimigos.add(new Inimigo(x , y));
        }

    }


    public void paint (Graphics g){
        Graphics2D graficos = (Graphics2D) g;
        if (EmJogo == true){

            graficos.drawImage(fundo, 0, 0, null);
            graficos.drawImage(player.getImage(), player.getXm(), player.getYm(), this);

            List<Tiro> tiros = player.getTiros();
            for(int i = 0; i< tiros.size(); i++ ){
                Tiro n = tiros.get(i);
                n.load();
                graficos.drawImage(n.getImagem(), n.getX(), n.getY(), this);
            }

            for(int o = 0; o< inimigos.size(); o++){
                Inimigo in = inimigos.get(o);
                in.load();
                graficos.drawImage(in.getImagem(), in.getX(), in.getY(), this);
            }

        }
        else{
            ImageIcon fimJogo = new ImageIcon("imagens\\JavaWins.png");
            graficos.drawImage(fimJogo.getImage(), 0, 0, null);
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
        
        for(int o = 0; o< inimigos.size(); o++){
            Inimigo in = inimigos.get(o);
            if (in.Isvisible() == true){
                in.update();
            }
            else{
                inimigos.remove(o);
            }
        }
        ChecarColisoes();
        repaint();
    }
    public void ChecarColisoes(){
        Rectangle formajogador = player.getBount();
        Rectangle formainimigo;
        Rectangle formatiro;

        for(int i = 0; i< inimigos.size(); i++){
            Inimigo tempInimigo = inimigos.get(i);
            formainimigo = tempInimigo.getBount();
                if(formajogador.intersects(formainimigo)){
                    player.setVisivel(false);
                    tempInimigo.setVisivel(false);
                        EmJogo = false;
                }
        }
        List<Tiro> tiros = player.getTiros();
        for(int p = 0; p< tiros.size(); p++){
            Tiro tempTiro = tiros.get(p);
            formatiro = tempTiro.getBount();
            for(int o = 0; o < inimigos.size(); o++){
                Inimigo tempInimigo = inimigos.get(o);
                formainimigo = tempInimigo.getBount();
                if (formatiro.intersects(formainimigo)){
                    tempInimigo.setVisivel(false);
                    tempTiro.setVisivel(false);
                }

            }
        }
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
    

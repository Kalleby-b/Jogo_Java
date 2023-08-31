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
    private Boss boss;
    private boolean EmJogo;
    private boolean FimdeJogo;
    private  int contador = (int) 0;
    private int vidaJogador = 3;
    private int vidaBoss = 2020;
    
    
    public Fase() {
        setFocusable(true);
        setDoubleBuffered(true);
        
        ImageIcon imagens = new ImageIcon("imagens\\Black.png");
        fundo = imagens.getImage();
       
        player = new Player();
        player.roupa();

        boss = new Boss();
        boss.roupa();
       
        addKeyListener(new TecladoAdapter());
       
        timer = new Timer(5 , this);
        timer.start();
        IniciaInimigo();
        EmJogo = true;
        FimdeJogo = true;
        
              

    }

    

    public void IniciaInimigo(){
        int coordenadas []= new int[60];
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

            if(contador > 100){
                graficos.drawImage(boss.getImage(), boss.getXm(), boss.getYm(), this);
                List<TiroBoss> tros = boss.getTiros();
                for(int i = 0; i< tros.size(); i++ ){
                    TiroBoss n = tros.get(i);
                    n.load();
                    graficos.drawImage(n.getImagem(), n.getX(), n.getY(), this);
            }
            }

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
        else if( FimdeJogo == false){
            ImageIcon fimJogo = new ImageIcon("imagens\\PythonWins.png");
            graficos.drawImage(fimJogo.getImage(), 0, 0, null);

        }
        else{
            ImageIcon fimJogo = new ImageIcon("imagens\\JavaWins.png");
            graficos.drawImage(fimJogo.getImage(), 0, 0, null);
        }
        
        if(vidaJogador == 3){
            ImageIcon vida1 = new ImageIcon("imagens\\vida.png");
            graficos.drawImage(vida1.getImage(), 10, 10, this);

            ImageIcon vida2 = new ImageIcon("imagens\\vida.png");
            graficos.drawImage(vida2.getImage(), 60, 10, this);

            ImageIcon vida3 = new ImageIcon("imagens\\vida.png");
            graficos.drawImage(vida3.getImage(), 110, 10, this);
        }if(vidaJogador == 2){
            ImageIcon vida1 = new ImageIcon("imagens\\vida.png");
            graficos.drawImage(vida1.getImage(), 10, 10, this);

            ImageIcon vida2 = new ImageIcon("imagens\\vida.png");
            graficos.drawImage(vida2.getImage(), 60, 10, this);

        }if(vidaJogador == 1){
            ImageIcon vida1 = new ImageIcon("imagens\\vida.png");
            graficos.drawImage(vida1.getImage(), 10, 10, this);
        }
        
         ImageIcon fb = new ImageIcon("imagens\\fundobra.png");
        graficos.drawImage(fb.getImage(), 300, 10, this);
        graficos.drawString(Integer.toString(contador),300, 20);


        
        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       player.mover();
       boss.mover(); 
      
       List<Tiro> tiros = player.getTiros();
        for(int i = 0; i< tiros.size();i++){
            Tiro m = tiros.get(i);
                if (m.Isvisible() == true){
                    m.update();
                }else{
                    tiros.remove(i);
                }

        }
        List<TiroBoss> tros = boss.getTiros();
        for(int i = 0; i< tros.size();i++){
            TiroBoss m = tros.get(i);
                if (m.Isvisible() == true){
                    m.update();
                }else{
                    tros.remove(i);
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
        Rectangle formaTiroBoss;
        Rectangle formaBoss = boss.getBount();

        

        for(int i = 0; i< inimigos.size(); i++){
            Inimigo tempInimigo = inimigos.get(i);
            formainimigo = tempInimigo.getBount();
                if(formajogador.intersects(formainimigo)){
                    player.setVisivel(false);
                    tempInimigo.setVisivel(false);
                    if(vidaJogador == 0){
                        EmJogo = false;
                    }else{
                        vidaJogador--;
                    }
                  
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
                    contador = contador+ 5;
                }
            

            }
        }
        List<Tiro> disparos = player.getTiros();
        for(int p = 0; p< disparos.size(); p++){
            Tiro tempTiro = disparos.get(p);
            formatiro = tempTiro.getBount();
            if(formatiro.intersects(formaBoss)){
                boss.setVisivel(false);
                if (vidaBoss == 0){
                    FimdeJogo = false;
                }else{
                    vidaBoss -- ;
                }
            }
        }

        List<TiroBoss> tros = boss.getTiros();
        for(int p = 0; p< tros.size(); p++){
            TiroBoss tempTirob = tros.get(p);
            formaTiroBoss = tempTirob.getBount();
            for(int o = 0; o < inimigos.size(); o++){
                Inimigo tempInimigo = inimigos.get(o);
                formainimigo = tempInimigo.getBount();
                if (formaTiroBoss.intersects(formajogador)){
                    if(vidaJogador == 0){
                        EmJogo = false;
                    }else{
                        vidaJogador--;
                    }
                }
            

            }
        }
            


    }
    
    private class TecladoAdapter extends KeyAdapter{
        
        @Override
        public void keyPressed(KeyEvent e){
            player.teclaPressionada(e);
            boss.teclaPressionad(e);
        }

        
        @Override
        public void keyReleased(KeyEvent f){
            player.teclaLivre(f);
            boss.teclaLivr(f);

        }
        
        
    }
}
    

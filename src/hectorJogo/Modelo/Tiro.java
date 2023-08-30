/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hectorJogo.Modelo;

import java.awt.Image;

import javax.swing.ImageIcon;


/**
 *
 * @author user
 */
public class Tiro {
    private Image imagem;
    private int x1, y1;
    private int largura, altura;
    private boolean inVisivel;
    
    private static final int LARGURA = 938;
    private static int VELOCIDADE = 2;
    
    
    public Tiro(int x, int y){
        this.x1 = x;
        this.y1 = y;
        inVisivel = true;
    }


    public void load(){
        ImageIcon referencia = new ImageIcon("imagens\\TiroSimples.png");
        imagem = referencia.getImage();

        this.largura = imagem.getWidth(null);
        this.altura = imagem.getHeight(null);
    }


    public void update(){
        this.x1 += VELOCIDADE;
        if(this.x1 > LARGURA){
            inVisivel = false;
        }


    }


    public  int getX(){
        return x1;
    }
    public  int getY(){
        return y1;
    }
    public boolean Isvisible(){
        return inVisivel ;
    }
    public void setVisivel(boolean inVisivel){
        this.inVisivel = inVisivel;
    }
    public static int getVELOCIDADE(){
        return VELOCIDADE;
    }
    public void setVELOCIDADE(int vELOCIDADE){
        VELOCIDADE = vELOCIDADE;
    }
    public Image getImagem(){
        return imagem;
    }
   
}

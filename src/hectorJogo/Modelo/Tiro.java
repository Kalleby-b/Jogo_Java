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
    private int x, y, largura, altura;
    private boolean inVisivel;
    
    private static final int LARGURA = 938;
    private static int VELOCIDADE = 2;
    
    
    public Tiro(int x, int y){
        this.x = x;
        this.y = y;
        inVisivel = true;
    }
    public void load(){
        ImageIcon referencia = new ImageIcon("imagens\\Tiro.png");
        imagem = referencia.getImage();

        this.largura = imagem.getWidth(null);
        this.altura = imagem.getHeight(null);
    }
    public void update(){
        this.x += VELOCIDADE;

        if(this.x > LARGURA){
            inVisivel = false;
        }
    }

    public  int getX(){
        return x;
    }
    public  int getY(){
        return y;
    }
    public boolean getIsvisible(){
        return inVisivel ;
    }
    public void setinVisivel(boolean inVisivel){
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

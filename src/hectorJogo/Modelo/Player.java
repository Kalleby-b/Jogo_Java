/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hectorJogo.Modelo;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import java.awt.Rectangle;

/**
 *
 * @author user
 */
public class Player {
    private int x ,y, dx, dy;
    private Image imagem;
    private int altura ,largura;
    private List <Tiro> tiros;
    private boolean IsVisible;


    public Player(){
    this.x = 100;
    this.y = 100;
    tiros = new ArrayList<Tiro>();
    IsVisible = true;

}
    public void roupa(){
        ImageIcon personagem = new ImageIcon("imagens\\Python.png");
        imagem = personagem.getImage();


        altura = imagem.getHeight(null);
        largura = imagem.getWidth(null);
    }

    public void mover(){
        x += dx;
        y+= dy;
    }

    public void tiroSimples(){
        this.tiros.add(new Tiro(x + largura, y + (altura/2)));
    }

    public Rectangle getBount(){
        return new Rectangle(x, y, largura, altura);
    }

    public void teclaPressionada(KeyEvent tecla){
        int botao = tecla.getKeyCode();
        if (botao == KeyEvent.VK_SPACE){
            tiroSimples();
        }
        if (botao == KeyEvent.VK_UP){
            dy = -3;
        }
        else if(botao == KeyEvent.VK_DOWN){
            dy = 3;
        }
        else if (botao == KeyEvent.VK_RIGHT){
            dx = 3;
        }
        else if (botao == KeyEvent.VK_LEFT){
            dx = -3;
        }
        
    }
    public void teclaLivre(KeyEvent tecla){
        int botao = tecla.getKeyCode();
        
        if (botao == KeyEvent.VK_UP){
            dy = 0;
        }
        else if(botao == KeyEvent.VK_DOWN){
            dy = 0;
        }
        else if (botao == KeyEvent.VK_RIGHT){
            dx = 0;
        }
        else if (botao == KeyEvent.VK_LEFT){
            dx = 0;
    
        }
        
    
    }
    
    public Image getImage(){
        return imagem;
    }    
    public int getXm(){
        return x;
    }     
    public int getYm(){
        return y;
    }     
    public List<Tiro> getTiros(){
        return tiros;
    }
    public boolean getIsvisivel(){
        return IsVisible;
    }
    public void setVisivel(boolean isVisible){
        IsVisible = isVisible;
    }
}

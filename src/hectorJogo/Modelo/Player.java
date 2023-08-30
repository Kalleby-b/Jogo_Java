/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hectorJogo.Modelo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author user
 */
public class Player {
    private int x ,y, dx, dy;
    private Image imagem;
    private int altura ,largura;
    
    public Player(){
    this.x = 100;
    this.y = 100;
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
    public void teclaPressionada(KeyEvent tecla){
        int botao = tecla.getKeyCode();
        
        if (botao == KeyEvent.VK_UP){
            dy = 8;
        }
        else if(botao == KeyEvent.VK_DOWN){
            dy = -8;
        }
        else if (botao == KeyEvent.VK_RIGHT){
            dx = -8;
        }
        else if (botao == KeyEvent.VK_LEFT){
            dx = 8;
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
    public int getX(){
        return x;
    }     
    public int getY(){
        return y;
    }     

}

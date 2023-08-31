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
public class Boss {
    private int x ,y, dy;
    private Image imagem;
    private int altura ,largura;
    private List <TiroBoss> tros;
    private boolean IsVisible;
    

    public Boss(){
    this.x = 800;
    this.y = 500;
    tros = new ArrayList<TiroBoss>();
    IsVisible = true;

}
    public void roupa(){
        ImageIcon personagem = new ImageIcon("imagens\\Boss.png");
        imagem = personagem.getImage();


        altura = imagem.getHeight(null);
        largura = imagem.getWidth(null);
    }

    public void mover(){
        y+= dy;
    }

    public void tiroSimples(){
        this.tros.add(new TiroBoss(x + (largura/2), y + (altura/2)));
    }

    public Rectangle getBount(){
        return new Rectangle(x, y, largura, altura);
    }

    public void teclaPressionad(KeyEvent tecla){
        int botao = tecla.getKeyCode();
        if (botao == KeyEvent.VK_SPACE){
            tiroSimples();
        }
        if (botao == KeyEvent.VK_UP){
            dy = 9;
        }
        else if(botao == KeyEvent.VK_DOWN){
            dy = -9;
        }
        
        
    }
    public void teclaLivr(KeyEvent tecla){
        int botao = tecla.getKeyCode();
        
        if (botao == KeyEvent.VK_UP){
            dy = 0;
        }
        else if(botao == KeyEvent.VK_DOWN){
            dy = 0;
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
    public List<TiroBoss> getTiros(){
        return tros;
    }
    public boolean getIsvisivel(){
        return IsVisible;
    }
    public void setVisivel(boolean isVisible){
        IsVisible = isVisible;
    }
}

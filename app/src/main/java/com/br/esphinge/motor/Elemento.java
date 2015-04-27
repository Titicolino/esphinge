package com.br.esphinge.motor;

import android.graphics.Canvas;

/**
 * Created by Tiago on 20/04/2015.
 */
public abstract class Elemento {

    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected String nomeImagem;

    public Elemento(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Elemento(String nome, int x, int y, int width, int height){
        this.nomeImagem = nome;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    protected Elemento() {
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getNomeImagem() {
        return nomeImagem;
    }

    public void setNomeImagem(String nomeImagem) {
        this.nomeImagem = nomeImagem;
    }

    public void deslocarEmX(int deslocamento){
        this.x += deslocamento;
    }

    public void deslocarEmY(int deslocamento){
        this.y += deslocamento;
    }

    public abstract void desenha(Canvas canvas);

    public boolean foiTocado(float posx, float posy) {

        if ((posx >= x) && (posx <= x + width) && (posy >= y)
                && (posy <= y + height)) {
            return true;
        } else {
            return false;
        }
    }

}

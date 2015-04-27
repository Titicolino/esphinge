package com.br.esphinge.motor;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;

import com.br.esphinge.enumerados.FlipEffect;

/**
 * Created by Tiago on 20/04/2015.
 */
public class Imagem extends Elemento{

    private Drawable imagem;
    private Context context;
    private Matrix matriz;

    public Imagem(Context contexto, int imagem, int x, int y, int width, int height){
        this.context = contexto;
        this.imagem = context.getResources().getDrawable(imagem);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.matriz = new Matrix();
        matriz.setScale(-1.0f, -1.0f);
    }

    public Imagem(String nomeImagem, Context contexto, int imagem, int x, int y, int width, int height){
        this(contexto, imagem, x, y, width, height);
        this.nomeImagem = nomeImagem;
    }

    public void desenha(Canvas canvas) {
        this.imagem.setBounds(this.x, this.y, this.width + this.x, this.height + this.y);
        this.imagem.draw(canvas);
    }

    public void desenha(Canvas canvas, FlipEffect effect) {

        if (effect == FlipEffect.NONE) {

            imagem.setBounds(this.x, this.y, this.width + this.x, this.height
                    + this.y);
            imagem.draw(canvas);

        } else {

            imagem.setBounds(-this.width - this.x, this.y, -this.x, this.height
                    + this.y);
            canvas.save();

            canvas.setMatrix(matriz);

            imagem.draw(canvas);
            canvas.restore();

        }
    }
}

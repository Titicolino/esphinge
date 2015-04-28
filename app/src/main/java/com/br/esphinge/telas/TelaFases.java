package com.br.esphinge.telas;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

import com.br.esphinge.R;
import com.br.esphinge.motor.DimensoesTela;
import com.br.esphinge.motor.Imagem;


/**
 * Created by Tiago on 20/04/2015.
 */
public class TelaFases {
    private Context context;
    private DimensoesTela dimensoesTela;
    private Imagem background;

    //Controla o scroll da imagem.
    private GestureDetector scrollGestureDetector;

    public TelaFases(final Context context) {
        this.context = context;
        this.dimensoesTela = new DimensoesTela(context);
        this.background = new Imagem("background_tela_fases", context, R.drawable.mundo_principal, 0, 0, 4*dimensoesTela.getLargura(), dimensoesTela.getAltura());
        scrollGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onScroll(MotionEvent down, MotionEvent up, float distanceX, float distanceY) {
                boolean podeDeslocar = true;
                //Se houve um evento de slide...
                if(down != null && up != null){
                    //...e o slide foi para esquerda
                    if(down.getX() < up.getX()){
                        podeDeslocar = background.getX() - distanceX < 0;
                        if(podeDeslocar) {
                            background.deslocarEmX((int) -distanceX);
                        }
                    }else{//..ou para direita
                        podeDeslocar = Math.abs(background.getX()+ background.getWidth() + distanceX) <= background.getX() + background.getWidth();

                        Log.i("Validacao: ", String.valueOf(podeDeslocar));
                        Log.i("Largura da imagem: ", String.valueOf(background.getX() + background.getWidth()));
                        Log.i("X inicial: ", String.valueOf(Math.abs(background.getX())));
                        Log.i("X final: ", String.valueOf(Math.abs(background.getX() + background.getWidth() + distanceX)));
                        if(podeDeslocar) {
                            background.deslocarEmX((int)-distanceX);
                        }
                    }
                }
                return true;
            }
        });
    }

    public void desenha(Canvas canvas) {
        background.desenha(canvas);
    }

    public void onTouch(MotionEvent event) {
        scrollGestureDetector.onTouchEvent(event);
    }
}

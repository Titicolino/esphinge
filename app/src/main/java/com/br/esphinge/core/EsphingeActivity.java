package com.br.esphinge.core;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.br.esphinge.enumerados.EstadoDoJogo;

/**
 * Created by Tiago on 06/04/2015.
 */
public class EsphingeActivity extends SurfaceView implements Runnable {

    private EstadoDoJogo estadoDoJogo;

    private Esphinge jogo;

    private Thread thread = null;
    private SurfaceHolder surfaceHolder;
    private boolean running = false;
    private Context context;

    public EsphingeActivity(Context context) {
        super(context);

        jogo = new Esphinge(context);
        this.context = context;
        surfaceHolder = getHolder();

        setFocusable(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Update();
        canvas.drawColor(Color.BLACK);

        jogo.desenha(canvas);
    }

    public void Update()
    {
        jogo.atualiza();
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        jogo.onTouch(event);

        return true;
    }

    @Override
    public void run() {

        while(running){

            if(surfaceHolder.getSurface().isValid()){
                Canvas canvas = surfaceHolder.lockCanvas();


                onDraw(canvas);

                surfaceHolder.unlockCanvasAndPost(canvas);
            }
        }
    }


    public void onExitGame()
    {
        jogo.onExitGame();
    }


    public void resumeGame()
    {
        estadoDoJogo = EstadoDoJogo.JOGANDO;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public void pauseGame()
    {
        estadoDoJogo = EstadoDoJogo.PAUSADO;

        boolean retry = true;
        running = false;
        while(retry){
            try {
                thread.join();
                retry = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public int defineTelaAVoltar() {
       return jogo.defineTelaAVoltar();
    }
}

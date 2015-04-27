package com.br.esphinge.core;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;

import com.br.esphinge.enumerados.EstadoDoJogo;


public class MainActivity extends Activity {

    private EsphingeActivity jogo;
    private EstadoDoJogo estadoDoJogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        jogo = new EsphingeActivity(this);
        estadoDoJogo = EstadoDoJogo.JOGANDO;
        setContentView(jogo);
    }

    //Forca a ser landscape
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        // ignore orientation/keyboard change
        super.onConfigurationChanged(newConfig);
    }

    //Define o fluxo de telas
    @Override
    public void onBackPressed() {
        int retornoDeTela = jogo.defineTelaAVoltar();

        if(retornoDeTela == -1){
            super.finish();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        jogo.resumeGame();
    }

    @Override
    protected void onPause() {
        super.onPause();
        jogo.pauseGame();
    }
}

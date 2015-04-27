package com.br.esphinge.core;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;

import com.br.esphinge.enumerados.TelasDoJogo;
import com.br.esphinge.telas.TelaAdivinhacao;
import com.br.esphinge.telas.TelaFases;
import com.br.esphinge.telas.TelaMenuPrincipal;

import static com.br.esphinge.enumerados.TelasDoJogo.Tela;

/**
 * Created by Tiago on 20/04/2015.
 */
public class Esphinge {
    private Context context;

    /*
    Cada nova tela do jogo deve ser declarada nesta classe.
    Adicionalmente, deve ser criada no enumerador de classes para o fluxo de telas.
     */
    private TelaMenuPrincipal telaMenuPrincipal;
    private TelaFases telaFases;
    private TelaAdivinhacao telaAdivinhacao;

    public Esphinge(Context context) {
        this.context = context;

        telaAdivinhacao = new TelaAdivinhacao(context);
        telaFases = new TelaFases(context);
        telaMenuPrincipal = new TelaMenuPrincipal(context);
        TelasDoJogo.telaAtual = Tela.TELA_MENU_PRINCIPAL;
    }

    public void desenha(Canvas canvas) {
        switch (TelasDoJogo.telaAtual){
            case TELA_ADIVINHACAO:
                telaAdivinhacao.desenha(canvas);
                break;
            case TELA_FASES:
                telaFases.desenha(canvas);
                break;
            case TELA_MENU_PRINCIPAL:
                telaMenuPrincipal.desenha(canvas);
                break;
        }
    }

    public void onTouch(MotionEvent event) {
        switch (TelasDoJogo.telaAtual){
            case TELA_ADIVINHACAO:
                telaAdivinhacao.onTouch(event);
                break;
            case TELA_FASES:
                telaFases.onTouch(event);
                break;
            case TELA_MENU_PRINCIPAL:
                telaMenuPrincipal.onTouch(event);
                break;
        }
    }

    public void atualiza() {
        switch (TelasDoJogo.telaAtual){
            case TELA_ADIVINHACAO:
                break;
            case TELA_FASES:
                break;
            case TELA_MENU_PRINCIPAL:
                break;
        }
    }

    public void onExitGame() {
    }

    public int defineTelaAVoltar() {
        int retorno = 0;
        switch (TelasDoJogo.telaAtual){
            case TELA_ADIVINHACAO:
                retorno = 0;
                TelasDoJogo.telaAtual = Tela.TELA_FASES;
                break;
            case TELA_FASES:
                retorno = 0;
                TelasDoJogo.telaAtual = Tela.TELA_MENU_PRINCIPAL;
                break;
            case TELA_MENU_PRINCIPAL:
                retorno = -1;
                break;
            default:
                retorno = -1;
        }
        return retorno;
    }
}
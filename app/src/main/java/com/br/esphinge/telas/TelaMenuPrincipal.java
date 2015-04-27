package com.br.esphinge.telas;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.widget.Toast;

import com.br.esphinge.R;
import com.br.esphinge.enumerados.TelasDoJogo;
import com.br.esphinge.motor.DimensoesTela;
import com.br.esphinge.motor.Imagem;

/**
 * Created by Tiago on 20/04/2015.
 */
public class TelaMenuPrincipal {

    private Imagem background;
    private Imagem btnOpcoes;
    private Imagem btnJogar;
    private DimensoesTela dimensoesTela;
    private int tamanho_botao_opcoes;
    private int tamanho_botao_jogar;
    private Context context;

    public TelaMenuPrincipal(Context context) {
        this.context = context;
        this.dimensoesTela = new DimensoesTela(context);
        this.tamanho_botao_opcoes = 2*context.getResources().getDrawable(R.drawable.botao_opcoes).getIntrinsicHeight();
        this.tamanho_botao_jogar = 2*context.getResources().getDrawable(R.drawable.botao_jogar).getIntrinsicHeight();
        this.background = new Imagem("background_tela_principal", context, R.drawable.background, 0, 0, dimensoesTela.getLargura(), dimensoesTela.getAltura());
        this.btnOpcoes = new Imagem("btn_opcoes", context, R.drawable.botao_opcoes,0,dimensoesTela.getAltura() - tamanho_botao_opcoes, dimensoesTela.getLargura(),tamanho_botao_opcoes);
        this.btnJogar = new Imagem("btn_jogar", context, R.drawable.botao_jogar,0,btnOpcoes.getY() - tamanho_botao_jogar, dimensoesTela.getLargura(),tamanho_botao_jogar);
    }

    public void desenha(Canvas canvas) {
        background.desenha(canvas);
        btnOpcoes.desenha(canvas);
        btnJogar.desenha(canvas);
    }

    public void onTouch(MotionEvent e) {
        if (e.getAction() == MotionEvent.ACTION_DOWN) {
            if (btnOpcoes.foiTocado(e.getX(), e.getY())) {
                Toast.makeText(this.context, "Botao Opcoes clicado!", Toast.LENGTH_LONG).show();
            }else if(btnJogar.foiTocado(e.getX(), e.getY())){
                TelasDoJogo.telaAtual = TelasDoJogo.Tela.TELA_FASES;
            }
        }
    }
}

package com.example.client_servertcp_pingpong.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.client_servertcp_pingpong.R;
import com.example.client_servertcp_pingpong.model.Jogador;

public class TelaVitoria extends AppCompatActivity {
    Jogador jogador;
    TextView tvResult, tvResult2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_vitoria);
        tvResult = (TextView) findViewById(R.id.tvResult);
        tvResult2 = (TextView) findViewById(R.id.tvResult2);

        //Dados da Intent anterior
        Intent quemChamou = this.getIntent();
        if (quemChamou != null) {
            Bundle params = quemChamou.getExtras();
            if (params != null) {
                //Recuperando instância do jogador
                jogador = (Jogador) params.getSerializable("jogador");
                if (jogador != null) {
                    Log.v("PDM", "É Server? " + jogador.isServer());//não zerar
                    Log.v("PDM", "É Morlock? " + jogador.isMorlock());//não zerar
                    Log.v("PDM", "CEP Jogador: " + jogador.getCEP());//não zerar
                    Log.v("PDM", "CEP Oponente: " + jogador.getCEPOponente());//não zerar
                    Log.v("PDM", "IP Server: " + jogador.getIP());//não zerar
                    Log.v("PDM", "Porta: " + jogador.getPorta());//não zerar
                    Log.v("PDM", "Nº de Pontos Jogador: " + jogador.getnPontos());//gravar só no final
                    Log.v("PDM", "Nº de Pontos Oponente: " + jogador.getnPontosOponente());//receber só no final
                    Log.v("PDM", "Nº Tentativas: " + jogador.getnTentativas());//gravar só no final
                    Log.v("PDM", "Tempo: " + jogador.getTempoDoJogador());//gravar só no final
                    Log.v("PDM", "Jogador Terminou? " + jogador.isFinished());//enviar só no final
                    Log.v("PDM", "Oponente Terminou? " + jogador.isOpponentFinished());//receber só no final
                    Log.v("PDM", "Venceu? " + jogador.isWinner());//receber só no final
                    if (jogador.isWinner()) {
                        tvResult.setText("VOCÊ VENCEU COM " + jogador.getnPontos() + " PONTOS");
                        if (jogador.isMorlock()){
                            tvResult2.setText("Você conseguiu pegar o Eloi antes de ele chegar à máquina do tempo.");
                        } else {
                            tvResult2.setText("Você conseguiu chegar à máquina do tempo antes de ser encontrado pelo Morlock.");
                        }
                    } else {
                        tvResult.setText("VOCÊ PERDEU COM " + jogador.getnPontos() + " PONTOS");
                        if (jogador.isMorlock()){
                            tvResult2.setText("O Eloi conseguiu fugir na máquina do tempo.");
                        } else {
                            tvResult2.setText("Você foi pego pelo Morlock.");
                        }
                    }
                }
            }
        }
    }

    public void onClickReiniciar(View v){
        finish();
    }




}
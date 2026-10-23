package br.com.joaocarloslima;

import java.util.Random;

import javafx.scene.image.ImageView;


public class Meteoro extends Asset {

    private int tamanho;
    private int poder;

    public Meteoro(int x, int y, int velocidade, Direcao direcao) {
        super(x, y, velocidade, direcao);
        this.tamanho = new Random().nextInt(8) + 1; // 1 a 8
        this.poder = tamanho;

        String path = "images/meteoro/meteoro" + tamanho + ".png";
        ImageView imagem = new ImageView(App.class.getResource(path).toString());
        setImagem(imagem);
    }


    public void tomarTiro(Tiro tiro) {
        poder -= tiro.getPoder();
    }

    public int getTamanho() {
        return tamanho;
    }

    public int getPoder() {
        return poder;
    }
}

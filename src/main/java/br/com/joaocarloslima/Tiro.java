package br.com.joaocarloslima;

import javafx.scene.image.ImageView;


public class Tiro extends Asset {

    private int poder;

    public Tiro(int x, int y, int velocidade, Direcao direcao, int poder) {
        super(x, y, velocidade, direcao);
        this.poder = poder;

        String path = "images/laser/laser" + poder + ".png";
        ImageView imagem = new ImageView(App.class.getResource(path).toString());
        setImagem(imagem);
    }

    public int getPoder() {
        return poder;
    }

    public void setPoder(int poder) {
        this.poder = poder;
    }
}

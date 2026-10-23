package br.com.joaocarloslima;

import javafx.scene.image.ImageView;
public abstract class Asset {

    private int x;
    private int y;
    private ImageView imagem;
    private int velocidade;
    private Direcao direcao;

    public Asset(int x, int y, int velocidade, Direcao direcao) {
        this.x = x;
        this.y = y;
        this.velocidade = velocidade;
        this.direcao = direcao;
    }

    public void mover() {
        switch (direcao) {
            case CIMA:
                y -= velocidade;
                break;
            case BAIXO:
                y += velocidade;
                break;
            case ESQUERDA:
                x -= velocidade;
                break;
            case DIREITA:
                x += velocidade;
                break;
        }
    }

    public boolean colidiuCom(Asset asset) {
        return x < asset.getX() + 50 &&
                x + 50 > asset.getX() &&
                y < asset.getY() + 50 &&
                y + 50 > asset.getY();
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

    public ImageView getImagem() {
        return imagem;
    }

    public void setImagem(ImageView imagem) {
        this.imagem = imagem;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public Direcao getDirecao() {
        return direcao;
    }

    public void setDirecao(Direcao direcao) {
        this.direcao = direcao;
    }
}

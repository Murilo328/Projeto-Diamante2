package br.com.joaocarloslima;


public class Nave extends Asset {

    private static final int X_MIN = 0;
    private static final int X_MAX = 640 - 50;

    public Nave(int x, int y, int velocidade, Direcao direcao) {
        super(x, y, velocidade, direcao);
    }

    
    public Tiro atirar(int poder) {
        return new Tiro(getX(), getY(), 10, Direcao.CIMA, poder);
    }


    @Override
    public void mover() {
        super.mover();
        if (getX() < X_MIN) {
            setX(X_MIN);
        }
        if (getX() > X_MAX) {
            setX(X_MAX);
        }
    }
}

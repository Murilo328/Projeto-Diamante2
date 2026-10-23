package br.com.joaocarloslima;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

public class Controller implements Initializable {

    @FXML
    ImageView imgNave;
    @FXML
    AnchorPane pane;
    @FXML
    Label level;
    @FXML
    Label pontos;

    private int frame = 0;

    private Jogo jogo = new Jogo();

    public void keyHandler(KeyEvent event) {

        switch (event.getCode()) {
            case LEFT:
                jogo.nave.setDirecao(Direcao.ESQUERDA);
                jogo.nave.mover();
                imgNave.setLayoutX(jogo.nave.getX());
                break;
            case RIGHT:
                jogo.nave.setDirecao(Direcao.DIREITA);
                jogo.nave.mover();
                imgNave.setLayoutX(jogo.nave.getX());
                break;
            case SPACE:
                atirar();
                break;
            default:
                break;
        }
    }

    private void remover(Asset asset) {
        pane.getChildren().remove(asset.getImagem());
        jogo.assets.remove(asset);
    }

    private void atualizar() {
        try {

            frame++;
            if (frame % 100 == 0) {
                Meteoro meteoro = jogo.criarMeteoro();
                posicionar(meteoro);
                pane.getChildren().add(meteoro.getImagem());
            }

            for (Asset asset : new ArrayList<>(jogo.assets)) {

                if (!jogo.assets.contains(asset)) {
                    continue;
                }

                asset.mover();

                if (asset.getY() > 480 || asset.getY() < 0 || asset.getX() > 640 || asset.getX() < 0) {
                    remover(asset);
                    continue;
                }

                if (asset instanceof Tiro) {
                    Tiro tiro = (Tiro) asset;

                    for (Asset outro : new ArrayList<>(jogo.assets)) {
                        if (outro instanceof Meteoro && tiro.colidiuCom(outro)) {
                            Meteoro meteoro = (Meteoro) outro;
                            meteoro.tomarTiro(tiro);

                            if (meteoro.getPoder() <= 0) {
                                remover(meteoro);
                                jogo.pontuar();
                            }

                            remover(tiro);
                            break; 
                        }
                    }

                    if (!jogo.assets.contains(tiro)) {
                        continue;
                    }
                }

                posicionar(asset);
            }

            pontos.setText(jogo.getPontos() + "");
            level.setText(jogo.getNivel() + "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void posicionar(Asset asset) {
        ImageView img = asset.getImagem();
        img.setLayoutX(asset.getX());
        img.setLayoutY(asset.getY());
    }

    public void clockThread() {
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(20);
                    Platform.runLater(() -> atualizar());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }

    private void atirar() {
        Tiro tiro = jogo.atirar();
        posicionar(tiro);
        pane.getChildren().add(tiro.getImagem());
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        level.setText(jogo.getNivel() + "");
        clockThread();
    }
}

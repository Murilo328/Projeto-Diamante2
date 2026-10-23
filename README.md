# 🚀 Space Diamante

Jogo de tiro com tema espacial feito em **Java** com **JavaFX**, como trabalho de Programação Orientada a Objetos (Senac).

Você controla uma nave e tem que **destruir os meteoros** antes que eles passem.

Feito por: **Murilo328**

---

## Como jogar

| Tecla | O que faz |
|-------|-----------|
| ⬅️ Seta esquerda | Move a nave para a esquerda |
| ➡️ Seta direita | Move a nave para a direita |
| Barra de espaço | Atira |

- Cada meteoro destruído vale **1 ponto**.
- A cada **10 pontos** você sobe de nível (o máximo é o nível **4**).
- Quanto maior o nível, mais forte é o tiro.
- Os meteoros têm 8 tamanhos. Os maiores aguentam mais tiros.

---

## Como rodar

Você precisa ter o **Java** e o **Maven** instalados.

1. Baixe o projeto (ou clone):
   ```bash
   git clone https://github.com/Murilo328/Projeto-Diamante2.git
   ```
2. Entre na pasta do projeto (onde fica o `pom.xml`).
3. Rode:
   ```bash
   mvn clean javafx:run
   ```
4. Clique dentro da janela do jogo e jogue.

---

## Como o código está organizado

Todas as classes ficam em `src/main/java/br/com/joaocarloslima/`.

- **Direcao**: enum com `CIMA`, `BAIXO`, `ESQUERDA` e `DIREITA`.
- **Asset**: classe abstrata, base de tudo que aparece na tela (posição, velocidade, direção, imagem). Tem o `mover()` e o `colidiuCom()`.
- **Nave**: o jogador. Atira e não deixa a nave sair da tela.
- **Tiro**: o disparo da nave. O poder dele muda a imagem e o dano.
- **Meteoro**: nasce com um tamanho sorteado (1 a 8). O poder é igual ao tamanho e diminui quando leva tiro.
- **Jogo**: guarda as regras: lista de objetos, pontos e nível.
- **Controller**: liga o jogo à tela, lê o teclado e atualiza tudo a cada 20 ms.
- **App**: abre a janela.

---

## O que usei

- Java 11
- JavaFX 13
- Maven

package org.academiadecodigo.powrangers;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class DrawPictures {
    public final int CELL_SIZE = 10;
    private int limitUp = 0;
    private int limitDown = 0;
    private int ballCode;
    private int pineCode;

    Picture gameOver = new Picture(CELL_SIZE, CELL_SIZE, "resources/gameover.png");
    Picture winner = new Picture(CELL_SIZE, CELL_SIZE, "resources/winner.png");

    // First Game Images
    Picture firstBackground = new Picture(CELL_SIZE, CELL_SIZE, "frame_no_score.png");
    Picture ball1 = new Picture((int) (Math.ceil(Math.random() * 544 + 52)), 250, "resources/blackball.png");
    Picture ball2 = new Picture((int) (Math.ceil(Math.random() * 544 + 52)), 250, "resources/whiteball.png");
    Picture ball3 = new Picture((int) (Math.ceil(Math.random() * 544 + 52)), 250, "ball.png");
    Picture bomb = new Picture((int) (Math.ceil(Math.random() * 544 + 52)), 250, "bomb.png");
    Picture heart1 = new Picture(70,20,"resources/heart.png");
    Picture heart2 = new Picture(170,20,"resources/heart.png");
    Picture heart3 = new Picture(270,20,"resources/heart.png");

    // Second Game Images
    Picture secondBackground = new Picture(CELL_SIZE, CELL_SIZE, "resources/snowtrack2.png");
    Picture pine1 = new Picture();
    Picture pine2 = new Picture();
    Picture boulder = new Picture();
    Picture beer3 = new Picture(70,20,"resources/beerlife.png");
    Picture beer4 = new Picture(170,20,"resources/beerlife.png");
    Picture beer5 = new Picture(270,20,"resources/beerlife.png");

    public void drawBallGame() {
        firstBackground.draw();
    }
    public void drawSnowGame(){ secondBackground.draw();}

    public int getPictureY() {
        return firstBackground.getMaxY();
    }

    public int getBallCode() {
        return ballCode;
    }

    public int getPineCode() {
        return pineCode;
    }

    public void drawBall() {
        int i = (int) (Math.ceil(Math.random() * 7));

        if (i == 1 || i== 2) {
            ball1 = new Picture((int) (Math.ceil(Math.random() * 544 + 52)), 250, "resources/blackball.png");
            ball1.draw();
            ballCode = i;
        } else if (i == 3 || i== 4){
            ball2 = new Picture((int) (Math.ceil(Math.random() * 544 + 52)), 250, "resources/whiteball.png");
            ball2.draw();
            ballCode = i;
        }else if (i == 5 || i== 6){
            ball3 = new Picture((int) (Math.ceil(Math.random() * 544 + 52)), 250, "ball.png");
            ball3.draw();
            ballCode = i;
        }else {
            bomb = new Picture((int) (Math.ceil(Math.random() * 544 + 52)), 250, "bomb.png");
            bomb.draw();
            ballCode = i;
        }
    }
    public void drawPine() {
        int i = (int) (Math.ceil(Math.random() * 6));
        System.out.println("fiz uma pine");
        if (i == 1 || i == 2) {
            pine1 = new Picture((int) (Math.ceil(Math.random() * 544 + 52)), 250, "resources/pine1.png");
            pine1.draw();
            pineCode = i;
        } else if(i == 3 || i == 4 || i == 5){
            pine2 = new Picture((int) (Math.ceil(Math.random() * 544 + 52)), 250, "resources/pine2.png");
            pine2.draw();
            pineCode = i;
        } else if(i == 6){
            boulder = new Picture((int) (Math.ceil(Math.random() * 544 + 52)), 250, "resources/whiteball.png");
            boulder.draw();
            pineCode = i;
        }

    }

    public void translateDOWN(Picture picture, int sleep) throws InterruptedException {
        Thread.sleep(sleep);
        picture.translate(0, 50);
    }

    public void translateUP(Picture picture, int sleep) throws InterruptedException {
        Thread.sleep(sleep);
        picture.translate(0, -30);
    }

    public void translateLEFT(Picture picture, int sleep) throws InterruptedException {
        Thread.sleep(sleep);
        picture.translate(-50, 50);
    }

    public void translateRIGHT(Picture picture, int sleep) throws InterruptedException {
        Thread.sleep(sleep);
        picture.translate(50, 50);
    }
}
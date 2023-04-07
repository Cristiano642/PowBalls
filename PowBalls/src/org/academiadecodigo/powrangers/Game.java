package org.academiadecodigo.powrangers;

import com.sun.org.apache.xerces.internal.impl.xs.models.XSCMLeaf;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;

import static org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent.KEY_SPACE;

public class Game {
    DrawPictures drawPictures = new DrawPictures();
    private Text scoreDisplay;
    private Rectangle scoreBackground;
    private int counterG1 = 0;
    private int lifesG1 = 0;
    private int counterG2 = 0;
    private int lifesG2 = 0;
    private int sleep = 120;
    private int superSleep = 100;
    Player player = new Player();
    Player player2 = new Player();
    private boolean stopGame1 = false;
    private boolean stopGame2 = false;
    private boolean gameStart1 = false;
    private boolean gameStart2 = false;
    private boolean gameStart3 = false;
    private boolean gameOver = false;

    Sound sound = new Sound();

    public boolean isGameOver() {
        return gameOver=true;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public void setGameStart1(boolean gameStart1) {
        this.gameStart1 = true;
    }

    public boolean isGameStart1() {
        return gameStart1;
    }

    public void setStopGame1(boolean stopGame1) {
        this.stopGame1 = stopGame1;
    }

    public void init() throws InterruptedException {
        player.init();
        player.setGame(this);
        player.drawMenu1();
    }

    public void scoreShow(){
    scoreBackground = new Rectangle(100, 100, 50, 20);
        scoreBackground.draw();
        scoreBackground.translate(100,100);

    scoreDisplay = new Text(100 + 10, 100 + 10, Integer.toString(counterG1));
        scoreDisplay.draw();
        scoreDisplay.translate(100,100);
    }

    public int getLifesG1() {
        return lifesG1;
    }

    public void setLifesG1(int lifesG1) {
        this.lifesG1 = lifesG1;
    }

    public void startFirstgame() throws InterruptedException {
        drawPictures.drawBallGame();
        drawPictures.drawBall();
        player.catcher.draw();

        drawPictures.heart1.draw();
        drawPictures.heart2.draw();
        drawPictures.heart3.draw();

        while (true) {
            if (lifesG1 == 1) {
                drawPictures.heart3.delete();
            } else if (lifesG1 == 2) {
                drawPictures.heart2.delete();

            } else if (lifesG1 >= 3) {
                drawPictures.ball1.delete();
                drawPictures.ball2.delete();
                drawPictures.ball3.delete();
                drawPictures.bomb.delete();
                drawPictures.firstBackground.delete();
                drawPictures.heart1.delete();
                drawPictures.heart2.delete();
                drawPictures.heart3.delete();
                player.catcher.delete();
                sound.stop();

                System.out.println("Game over");
                gameOver = true;
                if (this.gameOver == true) {
                    drawPictures.gameOver.draw();
                    sound.stop();

                    sound.setFile(4);
                    sound.playMusic(4);
                }
                break;
            }

            if (drawPictures.getBallCode() == 1 || drawPictures.getBallCode() == 2) {
                drawPictures.translateDOWN(drawPictures.ball1, sleep);
                if ((((drawPictures.ball1.getX() + drawPictures.ball1.getMaxX()) / 2) >= player.catcher.getX() && ((drawPictures.ball1.getX() + drawPictures.ball1.getMaxX()) / 2) <= player.catcher.getMaxX()) &&
                        (drawPictures.ball1.getMaxY() >= 710)) {
                    drawPictures.ball1.delete();
                    sound.setFile(6);
                    sound.playMusic(6);

                    if (counterG1 == 8){
                        this.sleep-=15;
                    } else if (counterG1==16) {
                        this.sleep-=15;
                    } else if (counterG1==24) {
                        this.sleep-=15;
                    }else if (counterG1==32) {
                        this.sleep-=15;
                    }else if (counterG1==40) {
                        this.sleep-=15;
                    }
                    counterG1++;
                    drawPictures.drawBall();

                } else if (drawPictures.ball1.getMaxY() >= 850) {
                    drawPictures.ball1.delete();
                    sound.setFile(2);
                    sound.playMusic(1);

                    drawPictures.drawBall();
                    lifesG1++;
                }

            } else if (drawPictures.getBallCode() == 3 || drawPictures.getBallCode() == 4) {
                drawPictures.translateDOWN(drawPictures.ball2, sleep);
                if ((((drawPictures.ball2.getX() + drawPictures.ball2.getMaxX()) / 2) >= player.catcher.getX() && ((drawPictures.ball2.getX() + drawPictures.ball2.getMaxX()) / 2) <= player.catcher.getMaxX()) &&
                        (drawPictures.ball2.getMaxY() >= 710)) {
                    drawPictures.ball2.delete();
                    sound.setFile(6);
                    sound.playMusic(6);

                    if (counterG1 == 8){
                        this.sleep-=15;
                    } else if (counterG1==16) {
                        this.sleep-=15;
                    } else if (counterG1==24) {
                        this.sleep-=15;
                    }else if (counterG1==32) {
                        this.sleep-=15;
                    }else if (counterG1==40) {
                        this.sleep-=15;
                    }
                    counterG1++;
                    drawPictures.drawBall();

                } else if (drawPictures.ball2.getMaxY() >= 850) {
                    drawPictures.ball2.delete();
                    sound.setFile(2);
                    sound.playMusic(1);

                    drawPictures.drawBall();
                    lifesG1++;
                }

            }else if (drawPictures.getBallCode() == 5 || drawPictures.getBallCode()==6) {
                drawPictures.translateDOWN(drawPictures.ball3, sleep);
                if ((((drawPictures.ball3.getX() + drawPictures.ball3.getMaxX()) / 2) >= player.catcher.getX() && ((drawPictures.ball3.getX() + drawPictures.ball3.getMaxX()) / 2) <= player.catcher.getMaxX()) &&
                        (drawPictures.ball3.getMaxY() >= 710)) {
                    drawPictures.ball3.delete();
                    sound.setFile(6);
                    sound.playMusic(6);

                    if (counterG1 == 8){
                        this.sleep-=15;
                    } else if (counterG1==16) {
                        this.sleep-=15;
                    } else if (counterG1==24) {
                        this.sleep-=15;
                    }else if (counterG1==32) {
                        this.sleep-=15;
                    }else if (counterG1==40) {
                        this.sleep-=15;
                    }
                    counterG1++;
                    drawPictures.drawBall();

                } else if (drawPictures.ball3.getMaxY() >= 850) {
                    drawPictures.ball3.delete();
                    sound.setFile(2);
                    sound.playMusic(1);

                    drawPictures.drawBall();
                    lifesG1++;
                }

            }else if (drawPictures.getBallCode() == 7) {
                drawPictures.translateDOWN(drawPictures.bomb, sleep);

                if ((((drawPictures.bomb.getX() + drawPictures.bomb.getMaxX()) / 2) >= player.catcher.getX() && ((drawPictures.bomb.getX() + drawPictures.bomb.getMaxX()) / 2) <= player.catcher.getMaxX()) &&
                        (drawPictures.bomb.getMaxY() >= 710)) {
                    drawPictures.bomb.delete();
                    sound.setFile(8);
                    sound.playMusic(8);

                    sound.stop();
                    lifesG1+=3;

                    drawPictures.ball1.delete();
                    drawPictures.ball2.delete();
                    drawPictures.ball3.delete();
                    drawPictures.bomb.delete();
                    drawPictures.firstBackground.delete();
                    drawPictures.heart1.delete();
                    drawPictures.heart2.delete();
                    drawPictures.heart3.delete();
                    player.catcher.delete();

                    System.out.println("Game over");
                    gameOver=true;
                    if(this.gameOver==true){
                        drawPictures.gameOver.draw();
                        sound.stop();

                    sound.setFile(4);
                    sound.playMusic(4);}

                } else if (drawPictures.bomb.getMaxY() >= 850) {
                    drawPictures.bomb.delete();
                    sound.setFile(2);
                    sound.playMusic(1);

                    drawPictures.drawBall();
                }
            }

        }if(false){
            drawPictures.ball1.delete();
            drawPictures.ball2.delete();
            drawPictures.ball3.delete();
            drawPictures.bomb.delete();
            drawPictures.firstBackground.delete();
            drawPictures.heart1.delete();
            drawPictures.heart2.delete();
            drawPictures.heart3.delete();
            player.catcher.delete();
        }
        }


}
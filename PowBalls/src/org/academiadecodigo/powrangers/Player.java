package org.academiadecodigo.powrangers;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;

import static org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent.*;
import static org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType.KEY_PRESSED;

public class Player implements KeyboardHandler {
    private Keyboard keyboard;
    Picture catcher = new Picture(350, 710, "picos!.png");
    Picture ski = new Picture(350, 710, "resources/skiguy.png");
    private Game game;
    private Picture menu1;
    private Picture menu2;
    private Picture menu3;
    private boolean gameStart1 = false;
    private boolean gameStart2 = false;
    private boolean gameStart3 = false;
    private Sound sound = new Sound();
    private DrawPictures drawPictures;

    public boolean getgameStart1() {
        return gameStart1;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public boolean getgameStart2() {
        return gameStart2;
    }

    public boolean getgameStart3() {
        return gameStart3;
    }

    public void drawMenu1() throws InterruptedException {
        menu1 = new Picture(10, 10, "menu.png");
        menu1.draw();
        sound.setFile(3);
        sound.play();

        while (!gameStart1) {
            System.out.println(gameStart1);
        }
        sound.setFile(21);
        sound.play();
        sound.loop();

        game.startFirstgame();

        if (game.getLifesG1() == 3) {
            sound.stop();
            game.setGameOver(true);
        }
    }

    public void drawMenu3() {
        menu3 = new Picture(10, 10, "resources/backg3.png");
        menu3.draw();
    }

    public void draw() {
        catcher.draw();
    }

    public int getX() {
        return catcher.getX();
    }

    public int getY() {
        return catcher.getY();
    }

    public int getMaxX() {
        return catcher.getMaxX();
    }

    public int getMaxY() {
        return catcher.getMaxY();
    }

    public void delete() {
        catcher.delete();
    }

    public void init() {
        keyboard = new Keyboard(this);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent breakGame = new KeyboardEvent();
        breakGame.setKey(KeyboardEvent.KEY_Z);
        breakGame.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent gameSTART = new KeyboardEvent();
        gameSTART.setKey(KEY_SPACE);
        gameSTART.setKeyboardEventType(KEY_PRESSED);

        KeyboardEvent musicPause = new KeyboardEvent();
        musicPause.setKey(KEY_M);
        musicPause.setKeyboardEventType(KEY_PRESSED);

        KeyboardEvent restart = new KeyboardEvent();
        restart.setKey(KEY_R);
        restart.setKeyboardEventType(KEY_PRESSED);

        keyboard.addEventListener(right);
        keyboard.addEventListener(left);
        keyboard.addEventListener(breakGame);
        keyboard.addEventListener(gameSTART);
        keyboard.addEventListener(musicPause);
        keyboard.addEventListener(restart);
    }

    public void init2() {
        keyboard = new Keyboard(this);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent breakGame = new KeyboardEvent();
        breakGame.setKey(KeyboardEvent.KEY_Z);
        breakGame.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent gameSTART = new KeyboardEvent();
        gameSTART.setKey(KEY_SPACE);
        gameSTART.setKeyboardEventType(KEY_PRESSED);

        KeyboardEvent musicPause = new KeyboardEvent();
        musicPause.setKey(KEY_M);
        musicPause.setKeyboardEventType(KEY_PRESSED);

        KeyboardEvent restart = new KeyboardEvent();
        restart.setKey(KEY_R);
        restart.setKeyboardEventType(KEY_PRESSED);

        keyboard.addEventListener(right);
        keyboard.addEventListener(left);
        keyboard.addEventListener(breakGame);
        keyboard.addEventListener(gameSTART);
        keyboard.addEventListener(musicPause);
        keyboard.addEventListener(restart);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
                if (gameStart1 == true && gameStart2 == false) {
                    if (catcher.getMaxX() <= 620) {
                        catcher.translate(50, 0);
                        System.out.println("Going right");
                    }
                } else if (gameStart1 == true && gameStart2 == true) {
                    if (ski.getMaxX() <= 620) {
                        ski.translate(50, 0);
                        System.out.println("Going right");
                    }
                }
                break;
            case KeyboardEvent.KEY_LEFT:
                if (gameStart1 == true && gameStart2 == false) {
                    if (catcher.getX() >= 52) {
                        catcher.translate(-50, 0);
                        System.out.println("going left");
                    }
                } else if (gameStart1 == true && gameStart2 == true) {
                    if (ski.getX() >= 52) {
                        ski.translate(-50, 0);
                        System.out.println("going left");
                    }
                }
                break;
            case KEY_SPACE:
                if (gameStart1 == false) {
                    menu1.delete();
                    this.gameStart1 = true;
                    game.setGameStart1(true);
                    break;
                }

            case KEY_M:
                if (sound.isPlaying() == true && !game.isGameOver()) {
                    sound.stop();
                } else if (sound.isPlaying() == false && !game.isGameOver()) {
                    sound.play();
                    break;
                }
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }
}
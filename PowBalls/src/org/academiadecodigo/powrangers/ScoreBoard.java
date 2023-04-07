package org.academiadecodigo.powrangers;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class ScoreBoard {
    public int score = 0 ;
    private Text scoreDisplay;
    private Rectangle scoreBackground;
    int x;
    int y;

    public ScoreBoard(int x, int y) {
        scoreBackground = new Rectangle(x, y, 50, 20);
        scoreBackground.draw();

        scoreDisplay = new Text(x + 10, y + 10, Integer.toString(score));
        scoreDisplay.draw();
    }

    public void scoreBoardDisplay(){
        scoreBackground = new Rectangle(x, y, 50, 20);
        scoreBackground.draw();
        scoreDisplay = new Text(x + 10, y + 10, Integer.toString(score));
        scoreDisplay.draw();
    }
    public void addScore(int points) {
        score += points;
        scoreDisplay.setText(Integer.toString(score));
    }
    public int getScore() {
        return score;
    }
}
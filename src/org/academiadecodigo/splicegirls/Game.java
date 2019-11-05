package org.academiadecodigo.splicegirls;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private Visitor[] visitorsWeek1;
    private Visitor[] visitorsWeek2;
    private Visitor[] visitorsWeek3;
    private Visitor[] visitorsWeek4;

    private int totalWeeks = 4;
    private int money = 10;
    private int happiness = 5;

    private Answer answer = Answer.MAYBE;
    private boolean spacePressed = false;
    private boolean cPressed = false;
    private boolean microsoftChanged;
    private int week = 1;
    private String[] backgrounds = {
            "resources/game/Backgrounds/day1.png",
            "resources/game/Backgrounds/day2.png",
            "resources/game/Backgrounds/day3.png"
    };

    private String[] backgroundsMicro = {
            "resources/game/Backgrounds/day1microsoft.png",
            "resources/game/Backgrounds/day2microsoft.png",
            "resources/game/Backgrounds/day3microsoft.png"
    };

    private Text moneyText;
    private Text happinessText;
    private Text weekText;


    private int i = 0;
    private String endWeekFile = null;

    private Response currentResponse;


    //deleting when space pressed only works if it's instantiated here; ugly, need one for each week.


    public Game(Visitor[] visitorsWeek1, Visitor[] visitorsWeek2, Visitor[] visitorsWeek3, Visitor[] visitorsWeek4) {
        background("resources/game/Backgrounds/day1.png");
        this.visitorsWeek1 = visitorsWeek1;
        this.visitorsWeek2 = visitorsWeek2;
        this.visitorsWeek3 = visitorsWeek3;
        this.visitorsWeek4 = visitorsWeek4;
        textInit();
    }


    public void start() throws InterruptedException {

        Picture picture = new Picture(10, 10, Resources.ENTRANCE_1);

        while (!spacePressed) {
            picture.draw();
        }
        picture.delete();


        weekEvents(visitorsWeek1);
        endWeek("resources/weekEndings/separator1.png");
        weekEvents(visitorsWeek2);
        endWeek("resources/weekEndings/separator2.png");
        weekEvents(visitorsWeek3);
        endWeek("resources/weekEndings/separator3.png");
        weekEvents(visitorsWeek4);
        gameOver();
    }


    public void weekEvents(Visitor[] visitors) throws InterruptedException {

        for (Visitor visitor : visitors) {
            spacePressed = false;
            visitor.reveal();
            visitor.enter();
            visitor.askQuestion();
            spacePressed = false;
            while (answer == Answer.MAYBE) {
                visitor.idle();
                spacePressed = false;
            }
            if (answer == Answer.YES) {
                visitor.hideQuestion();
                SoundEffects soundEffects = new SoundEffects();
                String soundPath = "/resources/345299__scrampunk__okay.wav";
                soundEffects.playSound(soundPath);

                currentResponse = visitor.reply(true);
                money += currentResponse.getMoneyChanger();
                happiness += currentResponse.getHappyChanger();
                textUpdate();
                spacePressed = false;

            } else {
                visitor.hideQuestion();
                NegativeSound negativeSound = new NegativeSound();
                String negativePath = "resources/242503__gabrielaraujo__failure-wrong-action.wav";
                negativeSound.playSound(negativePath);
                currentResponse = visitor.reply(false);
                money += currentResponse.getMoneyChanger();
                happiness += currentResponse.getHappyChanger();
                textUpdate();
                spacePressed = false;

            }

            while (!spacePressed) {
                visitor.idle();
            }
            visitor.hideResponse();
            visitor.exit();

            if (currentResponse.getMicrosoftChanger() == 1) {
                background(backgroundsMicro[i + currentResponse.getBackgroundChanger()]);
                i += currentResponse.getBackgroundChanger();
                textUpdate();
                microsoftChanged = true;
            } else if (currentResponse.getMicrosoftChanger() == 0 && microsoftChanged == true) {
                background(backgroundsMicro[i + currentResponse.getBackgroundChanger()]);
                i += currentResponse.getBackgroundChanger();
                textUpdate();
            } else {

                background(backgrounds[i + currentResponse.getBackgroundChanger()]);
                i += currentResponse.getBackgroundChanger();
                textUpdate();
            }


            spacePressed = false;
            cPressed = false;
            answer = Answer.MAYBE;
        }
    }


    public void endWeek(String endWeekFile) {

        Picture endOfWeek = new Picture(190, 180, endWeekFile);

        cPressed = false;
        while (!cPressed) {
            endOfWeek.draw();
        }
        week++;
        textUpdate();
        endOfWeek.delete();
        cPressed = false;


    }


    public void textInit() {
        moneyText = new Text(220, 60, (Integer.toString(money)));
        happinessText = new Text(320, 60, (Integer.toString(happiness)));
        weekText = new Text(420, 63, ("WEEK " + week));

        moneyText.grow(8, 8);
        if (money <= 0) {
            moneyText.setColor(Color.RED);
            moneyText.draw();
        } else {
            moneyText.setColor(Color.BLACK);
            moneyText.draw();
        }

        happinessText.grow(8, 8);

        if (happiness <= 0) {
            happinessText.setColor(Color.RED);
            happinessText.draw();
        } else {
            happinessText.setColor(Color.BLACK);
            happinessText.draw();
        }

        weekText.grow(30, 10);
        weekText.setColor(Color.BLACK);
        weekText.draw();
    }

    public void textUpdate() {
        moneyText.delete();
        happinessText.delete();
        weekText.delete();
        textInit();
    }


    public void background(String filename) {

        Picture background = new Picture(10, 10, filename);
        Picture border = new Picture(10, 10, "resources/game/Backgrounds/border.png");
        Picture ferrao = new Picture(550, 292, "resources/game/Backgrounds/ferrao-out.png");
        Picture board = new Picture(150, 45, "resources/game/board1.png");

        background.draw();
        border.draw();
        ferrao.draw();
        board.draw();


    }

    public void gameOver() {

        if (money < happiness && money < 0 && happiness > 0) {
            endWeekFile = "resources/Endings/GameOver1.png";
        } else if (money > happiness && money > 0 && happiness < 0) {
            endWeekFile = "resources/Endings/GameOver2.png";
        } else if (money == happiness && money > 0 && happiness > 0) {
            endWeekFile = "resources/Endings/GameOver3.png";
        } else {
            endWeekFile = "resources/Endings/GameOver4.png";
        }

        Picture picture = new Picture(10, 10, endWeekFile);
        picture.draw();
    }


    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public void setSpacePressed() {
        this.spacePressed = !spacePressed;
    }

    public void setCpressed() {
        this.cPressed = !cPressed;
    }


}

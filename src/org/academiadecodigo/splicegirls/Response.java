package org.academiadecodigo.splicegirls;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Response {
    private Picture picture;
    private int moneyChanger;
    private int happyChanger;
    private int backgroundChanger;
    private int microsoftChanger;



    public Response(String filename,int moneyChanger,int happyChanger, int backgroundChanger, int microsoftChanger) {

        this.picture = new Picture(250,150,filename);
        this.moneyChanger = moneyChanger;
        this.happyChanger = happyChanger;
        this.backgroundChanger = backgroundChanger;
        this.microsoftChanger = microsoftChanger;
    }


    public void hideResponse() {
        picture.delete();
    }

    public void reveal() {
        picture.draw();
    }


    public int getHappyChanger() {
        return happyChanger;
    }

    public int getMoneyChanger() {
        return moneyChanger;
    }

    public int getBackgroundChanger() {
        return backgroundChanger;
    }

    public int getMicrosoftChanger() {
        return microsoftChanger;
    }
}

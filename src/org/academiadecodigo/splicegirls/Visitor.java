package org.academiadecodigo.splicegirls;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Visitor {

    private Picture pictureIn;
    private Picture pictureOut;
    private Response goodResponse;
    private Response badResponse;
    private Picture question;
    private int xQuestion = 250;
    private int yQuestion = 150;
    private int xCharacter = -10;
    private int yCharacter = 292;

    public Visitor(String filenameIn, String filenameOut, String questionFile,Response goodResponse, Response badResponse) {
        this.pictureIn = new Picture(xCharacter, yCharacter, filenameIn);
        this.pictureOut = new Picture(xCharacter, yCharacter, filenameOut);
        this.question = new Picture(xQuestion, yQuestion,questionFile);
        this.goodResponse = goodResponse;
        this.badResponse = badResponse;

    }

    public void exit() throws InterruptedException {

        for (int i = 0; i < 6; i++) {
            pictureIn.delete();
            pictureOut.draw();
            if (i < 1) {
                pictureOut.translate(160, 0);
                Thread.sleep(200);
            }
            pictureOut.translate(-20, 0);
            Thread.sleep(200);
        }
        pictureOut.delete();

    }


    public void enter() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            if (i < 1) {
                pictureIn.translate(40, 0);
                Thread.sleep(300);
            }
            pictureIn.translate(40, 0);
            Thread.sleep(200);
        }
    }

    public void idle(){
        pictureIn.draw();
    }


    public void askQuestion(){
        question.draw();
    }

    public void hideQuestion(){
        question.delete();
    }


    public void hide() {
        pictureOut.delete();
    }

    public void reveal() {
        pictureIn.draw();
    }


    public Response reply(boolean gameAnswer) {
        if(gameAnswer) {
            goodResponse.reveal();
            return goodResponse;
        }
        badResponse.reveal();
        return badResponse;

    }
    public void hideResponse(){
        badResponse.hideResponse();
        goodResponse.hideResponse();
    }




}

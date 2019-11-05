package org.academiadecodigo.splicegirls;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyboardController implements KeyboardHandler {

    private Game game;


    public KeyboardController (Game game) {
        this.game = game;
        keyboardInit();

    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch(keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_Y :
                System.out.println("yes");
                game.setAnswer(Answer.YES);

                break;

            case KeyboardEvent.KEY_N :
                System.out.println("no");
                game.setAnswer(Answer.NO);
                break;

            case KeyboardEvent.KEY_SPACE :
                System.out.println("space");
                game.setSpacePressed();
                SpaceSound spaceSound = new SpaceSound();
                String soundPath = "/Users/codecadet/Desktop/Workspace/finalGame/resources/Confirm 1.wav";
                spaceSound.playSpace(soundPath);
                break;

            case KeyboardEvent.KEY_C :
                System.out.println("continue");
                game.setCpressed();
                break;

            case KeyboardEvent.KEY_Q :
                System.out.println("Exit");
                System.exit(0);
        }
    }
    public void keyboardInit() {

        Keyboard keyboard = new Keyboard(this);
        KeyboardEvent keyYPressed = new KeyboardEvent();
        KeyboardEvent keyNPressed = new KeyboardEvent();
        KeyboardEvent spacePressed = new KeyboardEvent();
        KeyboardEvent cPressed = new KeyboardEvent();
        KeyboardEvent keyQpressed = new KeyboardEvent();

        keyQpressed.setKey(KeyboardEvent.KEY_Q);
        keyQpressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyQpressed);


        keyYPressed.setKey(KeyboardEvent.KEY_Y);
        keyYPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyYPressed);

        keyNPressed.setKey(KeyboardEvent.KEY_N);
        keyNPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyNPressed);

        spacePressed.setKey(KeyboardEvent.KEY_SPACE);
        spacePressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(spacePressed);

        cPressed.setKey(KeyboardEvent.KEY_C);
        cPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(cPressed);

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}

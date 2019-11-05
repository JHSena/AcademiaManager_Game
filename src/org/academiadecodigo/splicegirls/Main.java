package org.academiadecodigo.splicegirls;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        //Catarina week 1
        Response good1 = new Response(Resources.CATARINA1_Y,-10,10,1,0);
        Response bad1 = new Response(Resources.CATARINA1_N,0,-1,0,0);

        Visitor cat1 = new Visitor(Resources.CATARINA_IN, Resources.CATARINA_OUT,Resources.CATARINA1_Q,good1,bad1);


        //Catarina week 2
        Response good2 = new Response(Resources.CATARINA2_Y,-10,30,1,0);
        Response bad2 = new Response(Resources.CATARINA2_N,0,-5,0,0);

        Visitor cat2 = new Visitor(Resources.CATARINA_IN, Resources.CATARINA_OUT,Resources.CATARINA2_Q,good2,bad2);

        //Catarina week 3
        Response good3 = new Response(Resources.CATARINA3_Y,-70,50,0,0);
        Response bad3 = new Response(Resources.CATARINA3_N,0,-5,0,0);

        Visitor cat3 = new  Visitor(Resources.CATARINA_IN, Resources.CATARINA_OUT,Resources.CATARINA3_Q,good3,bad3);

        //Alexandra week 1
        Response good4 = new Response(Resources.ALEXANDRA1_Y,+10,-5,0,0);
        Response bad4 = new Response(Resources.ALEXANDRA1_N,0,0,0,0);

        Visitor alex1 = new Visitor(Resources.ALEXANDRA_IN, Resources.ALEXANDRA_OUT,Resources.ALEXANDRA1_Q, good4,bad4);


        //Alexandra week 2
        Response good5 = new Response(Resources.ALEXANDRA2_Y,60,-10,0,0);
        Response bad5 = new Response(Resources.ALEXANDRA2_N,0,5,0,0);

        Visitor alex2 = new Visitor(Resources.ALEXANDRA_IN, Resources.ALEXANDRA_OUT,Resources.ALEXANDRA2_Q, good5,bad5);

        //Alexandra week 3
        Response good6 = new Response(Resources.ALEXANDRA4_Y,40,-15,0,0);
        Response bad6 = new Response(Resources.ALEXANDRA4_N,0,-1,0,0);

        Visitor alex3 = new Visitor(Resources.ALEXANDRA_IN, Resources.ALEXANDRA_OUT,Resources.ALEXANDRA4_Q, good6,bad6);


        //Sergio week 1
        Response good7 = new Response(Resources.SERGIO1_Y,-5,30,0,0);
        Response bad7 = new Response(Resources.SERGIO1_N,0,0,0,0);

        Visitor sergio1 = new Visitor(Resources.SERGIO_IN,Resources.SERGIO_OUT,Resources.SERGIO1_Q, good7,bad7);


        //Sergio week 2
        Response good8 = new Response(Resources.SERGIO2_Y,0,-15,0,0);
        Response bad8 = new Response(Resources.SERGIO2_N,-100,-5,0,0);

        Visitor sergio2 = new Visitor(Resources.SERGIO_IN,Resources.SERGIO_OUT,Resources.SERGIO2_Q, good8,bad8);


        //Sergio week 3
        Response good9 = new Response(Resources.SERGIO3_Y,-10,-20,0,0);
        Response bad9 = new Response(Resources.SERGIO3_N,0,-1,0,0);

        Visitor sergio3 = new Visitor(Resources.SERGIO_IN,Resources.SERGIO_OUT,Resources.SERGIO3_Q, good9,bad9);


        //Catarina Week 4
        Response good10 = new Response(Resources.CATARINA4_Y,0,-15,0,0);
        Response bad10 = new Response(Resources.CATARINA4_N,0,15,0,0);

        Visitor cat4 = new Visitor(Resources.CATARINA_IN,Resources.CATARINA_OUT,Resources.CATARINA4_Q, good10,bad10);

        //Alexandra week 4
        Response good11 = new Response(Resources.ALEXANDRA3_Y,200,-80,0,1);
        Response bad11 = new Response(Resources.ALEXANDRA3_N,0,-1,0,0);

        Visitor alex4 = new Visitor(Resources.ALEXANDRA_IN, Resources.ALEXANDRA_OUT,Resources.ALEXANDRA3_Q, good11,bad11);


        //Sergio week 4
        Response good12 = new Response(Resources.SERGIO4_Y,0,10,0,0);
        Response bad12 = new Response(Resources.SERGIO4_N,0,-10,0,0);

        Visitor sergio4 = new Visitor(Resources.SERGIO_IN,Resources.SERGIO_OUT,Resources.SERGIO4_Q, good12,bad12);


        //Dog
        Response good13 = new Response(Resources.DOG_Y,-10,100,0,0);
        Response bad13 = new Response(Resources.DOG_N,0,-15,0,0);

        Visitor dog = new Visitor(Resources.DOG_IN, Resources.DOG_OUT,Resources.DOG_Q, good13,bad13);

        //Sergio Bonus
        Response good14 = new Response(Resources.SERGIO5_Y,-20,70,0,0);
        Response bad14 = new Response(Resources.SERGIO5_N,0, -30,0,0);

        Visitor sergio5 = new Visitor(Resources.SERGIO_IN,Resources.SERGIO_OUT,Resources.SERGIO5_Q,good14,bad14);



        Visitor[] visitorsWeek1 = {cat1, alex1, sergio1};
        Visitor[] visitorsWeek2 = {sergio5, cat2, alex2, sergio2};
        Visitor[] visitorsWeek3 = {cat3, alex3, sergio3};
        Visitor[] visitorsWeek4 = {cat4, alex4, sergio4, dog};


        Game game = new Game(visitorsWeek1, visitorsWeek2, visitorsWeek3, visitorsWeek4);
        KeyboardController keyboard = new KeyboardController(game);

        String filepath = "/Users/codecadet/Desktop/Workspace/finalGame/resources/VOLUME_Spice_Girls_-_Wannabe.wav";

        MusicPlayer musicPlayer = new MusicPlayer();

        musicPlayer.playMusic(filepath);
        game.start();

    }
}

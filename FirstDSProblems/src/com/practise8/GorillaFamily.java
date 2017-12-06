package com.practise8;

public class GorillaFamily {
    String walk = "walk";
    void everyonePlay(boolean play){
        String approach = "amble";
        approach = "changeValue";

        play(() -> walk);
        String finalApproach = approach;
        play(() -> finalApproach);
    }

    void play(Gorilla g){
        System.out.print(g.move());
    }

    public static void main(String[] args) {
        GorillaFamily gf = new GorillaFamily();
        gf.everyonePlay(true);
    }
}

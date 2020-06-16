package com.twschool.practice;

public class Main {
    private static final int RUN_TIMES = 6;

    public static void main(String[] args) throws Exception {

        for (int i = 0; i < RUN_TIMES; i++) {
            String input = new GuessInputCommand().input();
            String result = Game.playGame(input);
            if(result.equals("4A0B")) {
                System.out.println("win, all correct");
                break;
            }
            else {
                System.out.println(result+"\tWrong Input，Input again");
            }
        }
        System.out.println("Game Over！");
    }
}

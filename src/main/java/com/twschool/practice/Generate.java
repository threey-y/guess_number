package com.twschool.practice;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/*
 * 生成4个随机不重复并小于9的数字
 * */
public class Generate {
    public static int[] createGameAnswer(){
        int[] gameAnswer= new int[4];

        for (int i = 0; i < gameAnswer.length; i++){
            gameAnswer[i] = (int)((Math.random())*10);
            for (int j = 0; j < i; j++){
                if (gameAnswer[i] == gameAnswer[j]){
                    i--; // 先--，再++，相当于下标不动
                    break;
                }
            }
        }
        for (int i = 0 ; i < gameAnswer.length; i++) {
//            System.out.print(gameAnswer[i]);
        }
        return gameAnswer;
    }
}

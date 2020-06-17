package com.twschool.practice;

import javax.naming.PartialResultException;

public class Answer {
    public Answer() {
    }

    public static String play(int[] gameAnswerArray, int[] intputAnswerArray) {
        String result = null;
        int numA = Answer.getNumberA(gameAnswerArray,intputAnswerArray);
        int numB = Answer.getNumberB(gameAnswerArray,intputAnswerArray);

        result = String.valueOf(numA) + "A" + String.valueOf(numB) + "B";
        return result;
    }

    private static int getNumberA(int[] array1,int[] array2){
        int result = 0;
        for (int i = 0; i < array1.length; i++){
            if (array1[i] == array2[i]){
                result += 1;
            }
        }
        return result;
    }

    private static int getNumberB(int[] array1,int[] array2){
        int result = 0;
        for (int i = 0; i < array1.length; i++){
            for (int j = 0; j < array2.length; j++){
                if (array1[i] == array2[j] && i != j){
                    result += 1;
                }
            }
        }
        return result;
    }
}

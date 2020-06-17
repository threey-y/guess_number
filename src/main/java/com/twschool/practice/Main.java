package com.twschool.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final int RUN_TIMES = 6;
    private static BufferedReader bufferedReader;
    private static boolean isOver = false;
    private static int[] inputAnswer = new int[4];
    private static Account account = new Account();
    private static int continueSuccessTimes = 0;//连续赢的次数
    private static boolean overOneTimeGameSucceed = false;
    private static boolean overOneTimeGameFailure = false;
    private static boolean overOneTimeGame = false;
    private static String name ;
    private static int points ;
    private static User currentUser;
    private static int times = 0;

    public static void main(String[] args) throws IOException {
        times = 0;
        int[] gameAnswer = Generate.createGameAnswer();

        inputYourName();

        while (!overOneTimeGame){
            if (input()){
                String result = Answer.play(gameAnswer, inputAnswer);
                System.out.println(result);
                checkIsOver(result,times);
            }else{
                break;
            }
        }
        getPointsByFailureOrSucceed(currentUser,overOneTimeGameFailure,overOneTimeGameSucceed);
        System.out.println("\tYour points is " + points + "\n------------------------------------------");
    }

    private static void getPointsByFailureOrSucceed(User currentUser, boolean overOneTimeGameFailure, boolean overOneTimeGameSucceed) {
        if (overOneTimeGameSucceed){
            points += 3;
            currentUser.setPoints(points);
        }else if(overOneTimeGameFailure){
            points -= 3;
            currentUser.setPoints(points);
        }
    }

    private static void inputYourName() throws IOException {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("------------------------------------------\n"
                + "\tPlease Enter Your Name\n");
        name = bufferedReader.readLine();
        points = 0;
        currentUser = new User(name,points);
        account.userList.add(currentUser);
        System.out.print("\tHi\t" + currentUser.getName() + "\t");
    }

    //输入数字,并检查格式是否正确
    public static boolean input() throws IOException {
        boolean isInputRight = true;
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\n\tPlease enter you answer,use space between numbers");
        String[] inputAnswerString =bufferedReader.readLine().split(" ");
        if (inputAnswerString.length != 4){
            System.out.println("\tWrong Input");
            isInputRight = false;
        }else{
            for (int i = 0;i< inputAnswerString.length;i++){
                inputAnswer[i] = Integer.parseInt(inputAnswerString[i]);
            }
        }
        return isInputRight;
    }

    //检查是否结束游戏
    private static void checkIsOver(String result,int times) {
        times += 1;
        if (times >= 6 ){
            overOneTimeGame = true;
            overOneTimeGameFailure = true;
            System.out.println("failure");
            times = 0;
        }else if (result.equals("4A0B")){
            continueSuccessTimes++;
            overOneTimeGame = true;
            overOneTimeGameSucceed = true;
            times = 0;
            System.out.println("success");
        }
    }
}

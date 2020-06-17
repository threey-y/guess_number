package com.twschool.practice;

import org.junit.Test;

public class AnswerTest {

    @Test
    public void should_return_0A0B_when_gameAnswer_is_1234_given_inputAnswer_is_5678(){
        int[] gameAnswer = {1,2,3,4};
        int[] inputAnswer = {5,6,7,8};

        this.doTest("0A0B",gameAnswer,inputAnswer);
    }

    @Test
    public void should_return_4A0B_when_gameAnswer_is_1234_given_inputAnswer_is_1234(){
        int[] gameAnswer = {1,2,3,4};
        int[] inputAnswer = {1,2,3,4};

        this.doTest("4A0B",gameAnswer,inputAnswer);
    }
    @Test
    public void should_return_0A4B_when_gameAnswer_is_1234_given_inputAnswer_is_4321(){
        int[] gameAnswer = {1,2,3,4};
        int[] inputAnswer = {4,3,2,1};

        this.doTest("0A4B",gameAnswer,inputAnswer);
    }
    @Test
    public void should_return_2A2B_when_gameAnswer_is_1234_given_inputAnswer_is_1243(){
        int[] gameAnswer = {1,2,3,4};
        int[] inputAnswer = {1,2,4,3};

        this.doTest("2A2B",gameAnswer,inputAnswer);
    }
    @Test
    public void should_return_0A1B_when_gameAnswer_is_1234_given_inputAnswer_is_2567(){
        int[] gameAnswer = {1,2,3,4};
        int[] inputAnswer = {2,5,6,7};

        this.doTest("0A1B",gameAnswer,inputAnswer);
    }
    @Test
    public void should_return_1A0B_when_gameAnswer_is_1234_given_inputAnswer_is_1567(){
        int[] gameAnswer = {1,2,3,4};
        int[] inputAnswer = {1,5,6,7};

        this.doTest("1A0B",gameAnswer,inputAnswer);
    }


    //抽出的方法
    public void doTest(String result,int[] game_Answer,int[] input_Answer){
        //given

        //when
        String outResult = Answer.play(game_Answer, input_Answer);

        //then
        assert result.equals(outResult);
    }
}

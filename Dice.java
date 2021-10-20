package com.shafayetmaruf.assignment.assignment1.question4;

import java.util.Random;

public class Dice {
    enum Sides{
        one(1),
        two(2),
        three(3),
        four(4),
        five(5),
        six(6);

        private int point;
        private Sides(int point){
            this.point = point;
        }

        public int getPoint(){
            return point;
        }
    }

    public int roll(){
        Random random = new Random();
        return random.nextInt(6) + 1;
    }
}

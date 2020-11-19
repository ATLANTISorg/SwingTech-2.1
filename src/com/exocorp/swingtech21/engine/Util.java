package com.exocorp.swingtech21.engine;

public class Util {
    public static int clamp(int var, int min, int max){
        if(var < min){
            return min;
        }else if(var > max){
            return max;
        }else return var;
    }
    public static float clamp(float var, float min, float max){
        if(var < min){
            return min;
        }else if(var > max){
            return max;
        }else return var;
    }

    public double timer(long startTime){
        long elapsedTime = System.currentTimeMillis() - startTime;
        return elapsedTime / 1000f;
    }
}

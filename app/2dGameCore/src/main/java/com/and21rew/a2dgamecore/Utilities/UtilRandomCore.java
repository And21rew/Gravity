package com.and21rew.a2dgamecore.Utilities;

import java.util.Random;

public class UtilRandomCore {

    public static int GetCasualNumber(int number){
        return new Random().nextInt(number);
    }
}

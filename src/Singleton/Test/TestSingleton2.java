package Singleton.Test;

import Singleton.*;

import java.util.Date;

public class TestSingleton2 {

    public static void main(String[] args) {    	
        System.out.println(Singleton2.INSTANCE.date);
        System.out.println(Singleton2.INSTANCE.date);
        //System.out.println(Singleton2.INSTANCE.getInstance());
        //System.out.println(Singleton2.INSTANCE.getInstance());
        //System.out.println(Singleton2.INSTANCE.getInstance());
    }

}

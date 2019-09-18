package Singleton.Test;

import Singleton.*;

public class TestSingleton3 {

    public static void main(String[] args) {
        Singleton3 s = Singleton3.INSTANCE;
        Singleton3 s1 = Singleton3.INSTANCE;
        System.out.println(s==s1);
    }

}

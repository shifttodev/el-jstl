package io.shifttodev.eljstl.service;

public class GenerateID {

    private static int id = 0;

    public static int get(){
        return ++id;

    }
}

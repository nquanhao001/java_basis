package com.niuquanhao.exception;

/**
 * Created by niuquanhao on 16/6/24.
 */
public class ExceptionTest {

    public static void main(String[] args) {

        long begin = System.currentTimeMillis();
        for(int i = 0 ; i< 1000000 ; i++){
            try {
                callWithExcepton();
            } catch (Exception e) {

            }
        }
        long end = System.currentTimeMillis();
        for(int i = 0 ; i< 1000000 ; i++){
            call();
        }
        long end2 = System.currentTimeMillis();
        System.out.println(end - begin);
        System.out.println(end2 - end);
    }

    public static void callWithExcepton(){
        throw new RuntimeException();
    }

    public static int call(){
        return 12;
    }
}

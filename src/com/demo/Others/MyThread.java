package com.demo.Others;

import java.util.concurrent.Callable;

class myThread implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {

        return 100;
    }
}

public class MyThread {
    public static void main(String[] args) {
        Thread t1 = new Thread();
    }

}

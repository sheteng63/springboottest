package com.example.demo;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class Contest {

    LinkedBlockingQueue list = new LinkedBlockingQueue<String>();
    Object lock = new Object();
    volatile boolean  isWait = false;

    public void produce() {
        try {
            while (true) {
                synchronized (lock) {
                    while (!list.isEmpty()) {
                        isWait = true;
                        lock.wait();
                    }
                    isWait = false;
                    System.out.println("生产者生产     线程号" + Thread.currentThread().getName());
                    for (int i = 0; i < 10; i++) {
                        list.put(i + "");
                    }
                }
            }
        } catch (Exception e) {

        }
    }

    public void consume() {
        try {
            while (true) {
                while (list.isEmpty()) {
                    notifyProduct();
                }
                String take = (String) list.take();
                System.out.println("消费者消费" + take + "     线程号" + Thread.currentThread().getName());
                Thread.sleep(1000);
            }
        } catch (Exception e) {

        }
    }

    public void notifyProduct() {
        synchronized (lock) {
            if (isWait) {
                lock.notify();
            }
        }

    }

}

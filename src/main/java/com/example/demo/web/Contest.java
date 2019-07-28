package com.example.demo.web;

import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.LinkedBlockingQueue;

public class Contest {

    private LinkedBlockingQueue<String> list = new LinkedBlockingQueue<>();

    @Async
    public synchronized void consume() {
        while (true) {
            try {

                while (list.isEmpty()) {
                    this.wait();
                }
                list.take();
                System.out.println("消费完了");
                this.notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    @Async
    public synchronized void produce() {
        while (true) {
            try {
                while (list.size() > 0) {
                    this.wait();
                }
                for (int i = 0; i < 10; i++) {
                    list.put(i + "");
                }
                System.out.println("生产完了");
                this.notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}

package com.example.demo.service.impl;

import com.example.demo.dao.UserDao;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

@Service
public class Contest {
    private static final Logger LOG = LoggerFactory.getLogger(Contest.class);

    @Autowired
    UserDao userDao;

    LinkedBlockingQueue list = new LinkedBlockingQueue<String>();
    Object lock = new Object();
    volatile boolean isWait = false;
    boolean isFinish = false;
    //目前到第几行了
    private long current = 0;

    //总共行数
    private long total = 0;


    public void produce() {
        total = userDao.countIdentNo();
        try {
            while (!isFinish) {
                synchronized (lock) {
                    while (!list.isEmpty()) {
                        isWait = true;
                        lock.wait();
                    }

                    isWait = false;
                    productData();
                }
            }
        } catch (Exception e) {

        }

        LOG.info("已处理完全部数据,总共处理数据" + current);
    }

    private void productData() {

        try {
            if (current >= total) {
                isFinish = true;
                return;
            }
            HashMap<String, Object> map = new HashMap<>();
            map.put("begin", current);
            long end = current + 2;
            if (end >= total) {
                end = total;
            }
            map.put("end", end - current);
            List<String> identNos = userDao.selectAllIdentNo(map);
            current = end;
            for (String identNo : identNos) {
                list.put(identNo);
                LOG.info("生产者本次生产了" + identNo);
            }
            LOG.info("生产者本次生产了" + identNos.size());
            LOG.info("生产者总共生产了" + current);
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
                LOG.info("消费者消费" + take + "     线程号" + Thread.currentThread().getName());
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

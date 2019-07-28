package com.example.demo;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.UserEntity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    UserDao userDao;

    private LinkedBlockingQueue<String> list = new LinkedBlockingQueue<>();

    @Test
    public void contextLoads() {
//		UserEntity userEntity = new UserEntity();
//		userEntity.setUserName("sheteng");
//		List<UserEntity> userEntities = userDao.selectList(userEntity);
//		Long aLong = userDao.countIdentNo();
//		HashMap<String, Object> map = new HashMap<>();
//		map.put("begin",0);
//		map.put("end",5);
//		List<String> strings = userDao.selectAllIdentNo(map);
//		System.out.println("nihao");
//		for (String string : strings) {
//			List<UserEntity> entities = userDao.selectUserByIdentNo(string);
//		}
//		doRegist();


    }



    //目前到第几行了
    private int current = 0;
//
//    @Async
//    public void produce() {
//        Long total = userDao.countIdentNo();
//        try {
//            while (!list.isEmpty()) {//进入到while语句内，说明 isEmpty==false，那么表示有数据了，不能生产，必须要等待消费者消费
//                this.wait();//导致当前线程等待，进入等待池中，只能被其他线程唤醒
//            }
//            HashMap<String, Object> map = new HashMap<>();
//            map.put("begin", current);
//            long end = current + 1000;
//            if (end >= total) {
//                end = total;
//            }
//            map.put("end", end);
//            List<String> strings = userDao.selectAllIdentNo(map);
//            list.addAll(strings);
//            this.notifyAll();//生产完毕，唤醒所有消费者
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }


}

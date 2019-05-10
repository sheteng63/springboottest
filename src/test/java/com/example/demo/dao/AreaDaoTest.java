package com.example.demo.dao;

import com.example.demo.entity.Area;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {
    @Autowired
    private AreaDao areaDao;

    @Test
    public void queryArea() {
        List<Area> areaList = areaDao.queryArea();
        assertEquals(2, areaList.size());
        System.out.println(areaList.toString());
    }

    @Test
    public void queryAreaById() {
        Area area = areaDao.queryAreaById(1);
        assertEquals("东院", area.getAreaName());
    }

    @Test
    public void insertArea() {
        Area area = new Area();
        area.setAreaName("北苑");
        area.setPriority(1);
        int effectNum = areaDao.insertArea(area);
        assertEquals(1, effectNum);

    }

    @Test
    public void updateArea() {
        Area area = new Area();
        area.setAreaName("东院");
        area.setAreaId(1);
        area.setLastEditTime(new Date());
        int effectNum = areaDao.updateArea(area);
        assertEquals(1, effectNum);
    }

    @Test
    public void deleteArea() {
        int effectNum = areaDao.deleteArea(4);
        assertEquals(1, effectNum);
    }
}
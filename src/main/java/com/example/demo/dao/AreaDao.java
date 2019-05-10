package com.example.demo.dao;

import com.example.demo.entity.Area;

import java.util.List;

public interface AreaDao {
    /**
     * 列出列表区域
     * @return arealist
     */
    List<Area> queryArea();

    /**
     *
     * @param areaId
     * @return
     */
    Area queryAreaById(int areaId);

    /**
     *
     * @param area
     * @return
     */
    int insertArea(Area area);

    /**
     *
     * @param area
     * @return
     */
    int updateArea(Area area);

    /**
     *
     * @param areaId
     * @return
     */
    int deleteArea(int areaId);
}

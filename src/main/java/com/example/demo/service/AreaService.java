package com.example.demo.service;

import com.example.demo.entity.Area;

import java.util.List;

public interface AreaService {
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
    boolean addArea(Area area);

    /**
     *
     * @param area
     * @return
     */
    boolean modifyArea(Area area);

    /**
     *
     * @param areaId
     * @return
     */
    boolean deleteArea(int areaId);
}

package com.organOld.dao.repository.out;

import com.organOld.dao.entity.Coordinate;
import com.organOld.dao.repository.BaseDao;


public interface CoordinateDao extends BaseDao<Coordinate,Number> {
    void add(Coordinate coordinate);
    Integer getMaxtaskid(); //获取最大taskid
}

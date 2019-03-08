package com.organOld.oService.service;

import com.organOld.oService.contract.Conse;
//import com.organOld.oService.contract.Coordinate;
import com.organOld.oService.contract.OrganRegRequest;
import com.organOld.dao.entity.Coordinate;

import javax.servlet.http.HttpServletRequest;

public interface OrganService {
    Conse reg(OrganRegRequest organRegRequest, HttpServletRequest request);

    Conse getOrganTypes();

    Conse getOrganInfo(Integer organId);

    Conse getTypes();

    Conse getOrganLocation();

    Conse saveLocation(Coordinate coordinate);

    Conse getMaxtaskid();


}

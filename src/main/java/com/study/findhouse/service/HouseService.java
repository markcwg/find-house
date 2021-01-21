package com.study.findhouse.service;

import com.study.findhouse.pojo.House;

import java.io.IOException;
import java.util.List;

/**
 * @author markcwg
 * @email caiwg@sucsoft.com
 * @date 2021/1/20 17:37
 */
public interface HouseService {
    Boolean inputData () throws IOException;

    List<House> searchByTitle(String title);
}

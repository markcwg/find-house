package com.study.findhouse.controller;

import com.study.findhouse.pojo.House;
import com.study.findhouse.service.HouseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * @author markcwg
 * @email caiwg@sucsoft.com
 * @date 2021/1/20 17:36
 */
@RestController
@Api(tags = "系统接口")
public class HouseController {
    @Autowired
    private HouseService houseService;

    @PostMapping("input")
    @ApiOperation(value = "从贝壳找房导入 100 页房源数据到elasticsearch中")
    public Boolean inputData () throws IOException {
        return houseService.inputData();
    }

    @GetMapping("search")
    @ApiOperation(value = "根据标题搜索房源信息")
    public List<House> searchByTitle (String title) {
        return houseService.searchByTitle(title);
    }
}

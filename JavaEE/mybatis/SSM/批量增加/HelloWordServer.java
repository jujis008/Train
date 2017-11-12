package com.sinldo.server.dao;

import com.sinldo.po.HelloWorld;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface HelloWordServer {

    /**
     * @Title: batchInsert
     * @TitleExplain:
     * @Description: 批量插入操作
     * @param
     * @return
     * @version
    */
    int batchInsert(@Param("list") List<HelloWord> list);
}
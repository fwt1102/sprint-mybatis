package com.fwt.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 2019/5/30.
 */

//Echarts数据图
    @Setter
    @Getter
    @ToString
public class HistogramDto implements Serializable{
    List<String> data = new ArrayList<String>();
    List<String> category = new ArrayList<String>();


//数据添加到集合
    public void addCategory(String categoryName){
        this.category.add(categoryName);
    }

    public void addData(String dataName){
        this.data.add(dataName);
    }

}

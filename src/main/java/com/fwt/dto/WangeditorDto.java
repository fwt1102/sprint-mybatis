package com.fwt.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;
import java.util.Date;

@Setter
@Getter
@ToString
public class WangeditorDto {
    private  int id;
    private String text; //错误代码，0 表示没有错误。
    private int uid;
    private Date time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        System.out.println(time.getTime());

        this.time = time;
    }
}

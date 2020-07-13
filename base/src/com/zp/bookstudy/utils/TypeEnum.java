package com.zp.bookstudy.utils;

/**
 * @author zhaopeng
 * @create 2020-07-12 9:52
 */

public enum  TypeEnum {
    COURSE_TYPE1(1,"免费课程"),
    COURSE_TYPE2(2,"付费课程"),
    COURSE_TYPE3(3,"垃圾课程");
    private int id;
    private String type;

    @Override
    public String toString() {
        return "TypeEnum{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }

    TypeEnum(int id, String type) {
        this.id = id;
        this.type = type;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

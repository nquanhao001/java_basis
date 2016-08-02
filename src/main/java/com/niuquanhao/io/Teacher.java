package com.niuquanhao.io;

/**
 * Created by niuquanhao on 16/8/2.
 */
public class Teacher extends BaseDO {


    private String name;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "age:" + age + "; name:" + name;
    }
}

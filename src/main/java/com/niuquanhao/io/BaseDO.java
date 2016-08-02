package com.niuquanhao.io;

import java.io.Serializable;

/**
 * Created by niuquanhao on 16/8/2.
 */
public class BaseDO implements Serializable{

    private static final long serialVersionUID = 1L;
    private static final long ss = 1L;

    private Integer xx;

    public Integer getXx() {
        return xx;
    }

    public void setXx(Integer xx) {
        this.xx = xx;
    }
}

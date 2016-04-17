package com.niuquanhao.oo;

/**
 * Created by quanhao.nqh on 2016/4/17.
 */
public class ParamDeliver {
    private String name;
    public ParamDeliver(String name) {
        this.name = name;
    }
    public static void main(String[] args) {
        ParamDeliver paramDeliver = new ParamDeliver("入参前数值");
        invalid(paramDeliver);
        System.out.println(paramDeliver.getName());
        valid(paramDeliver);
        System.out.println(paramDeliver.getName());
    }
    private static void invalid(ParamDeliver paramDeliver){
        ParamDeliver paramDeliverInner = new ParamDeliver("入参后数值");
        paramDeliver = paramDeliverInner;//这一行为什么没有实际作用？？？  因为方法内的paramDeliver和main方法中定义的不是一个
    }
    private static void valid(ParamDeliver paramDeliver){
        paramDeliver.setName("入参后的值");
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

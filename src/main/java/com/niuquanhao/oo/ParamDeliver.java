package com.niuquanhao.oo;

/**
 * Created by quanhao.nqh on 2016/4/17.
 */
public class ParamDeliver {

    private String name;

    public static void main(String[] args) {
        String param1 = "111";
        String param2 = "111";
        String param3 = new String("111");   //String是常量

        System.out.println(param1.equals(param2));  //输出true
        System.out.println(param1.equals(param3));  //输出true

        ParamDeliver paramDeliver = new ParamDeliver();
        paramDeliver.setName("入参前数值");
        System.out.println("方法外：" + paramDeliver);

        test(paramDeliver);




    }

    private static void test(ParamDeliver paramDeliver){
        System.out.println("方法内：" + paramDeliver);
        ParamDeliver paramDeliverInner = new ParamDeliver();
        paramDeliver.setName("入参后数值");
        System.out.println("内部对象：" + paramDeliverInner);

        paramDeliver = paramDeliverInner;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

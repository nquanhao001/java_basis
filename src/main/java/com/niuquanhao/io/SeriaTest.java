package com.niuquanhao.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by niuquanhao on 16/8/2.
 */
public class SeriaTest {

    public static void main(String[] args) throws Exception{
        Teacher teacher = new Teacher();
        teacher.setAge(11);
        teacher.setName("fffff中文");


        /*ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("/Users/niuquanhao/workspace/java_basis/src/temp.out"));
        out.writeObject(teacher);
        out.close();*/

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("/Users/niuquanhao/workspace/java_basis/src/temp.out"));
        Object object = in.readObject();
        System.out.println(object);

    }


}

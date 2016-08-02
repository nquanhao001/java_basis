package com.niuquanhao.qlcoder.distributedOne;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

/**
 * Created by niuquanhao on 16/7/15.
 * qlcoder/7644
 */
public class Main {

    public static void main(String[] args) throws Exception{
        ZooKeeper zooKeeper = new ZooKeeper("121.201.8.217:2181", 1000, new Watcher() {
            public void process(WatchedEvent event) {
                System.out.println("变化了！！");
            }
        });

        byte[] data = zooKeeper.getData("/qlcoder/zookeeper", false, null);
        System.out.println(new String(data));
    }
}

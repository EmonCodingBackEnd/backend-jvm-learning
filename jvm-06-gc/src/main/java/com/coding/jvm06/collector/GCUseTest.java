package com.coding.jvm06.collector;

import java.util.ArrayList;

/**
 * -XX:+PrintCommandLineFlags
 *  JDK8下，使用的是： -XX:+UseParallelGC 和 -XX:+UseParallelOldGC
 *  JDK9下，使用的是： -XX:+UseG1GC
 *  也可以手动指定使用其他垃圾收集器：   -XX:+UseSerialGC        新生代用 Serial GC，且老年代用 Serial Old GC
 *  也可以手动指定使用其他垃圾收集器：   -XX:+UseParNewGC        新生代使用并行收集器，不影响老年代
 *  也可以手动指定使用其他垃圾收集器：   -XX:+UseParallelGC      新生代使用 Parallel GC，老年代使用 ParallelOld GC（UseParallelGC与UseParallelOldGC开启一个，另一个也会被开启）
 *  也可以手动指定使用其他垃圾收集器：   -XX:+UseParallelOldGC   新生代使用 Parallel GC，老年代使用 ParallelOld GC（UseParallelGC与UseParallelOldGC开启一个，另一个也会被开启）
 *  也可以手动指定使用其他垃圾收集器：   -XX:+UseConcMarkSweepGC 新生代使用ParNew+，老年代使用CMS（Serial Old作为CMS由于内存碎片出现“Concurrent Mode Failure”失败的后备预案）
 *  也可以手动指定使用其他垃圾收集器：   -XX:+UseG1GC    表示年轻代与老年代都使用G1GC
 */
public class GCUseTest {
    public static void main(String[] args) {
        ArrayList<byte[]> list = new ArrayList<byte[]>();

        while (true) {
            byte[] arr = new byte[100];
            list.add(arr);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

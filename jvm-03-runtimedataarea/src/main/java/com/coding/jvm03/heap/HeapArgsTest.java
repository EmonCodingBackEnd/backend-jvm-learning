package com.coding.jvm03.heap;

/**
 * 测试堆空间常用的jvm参数
 * | 参数                       | 含义                                                         |
 * | -------------------------- | ------------------------------------------------------------ |
 * | -XX:+PrintFlagsInitial     | 查看所有的参数的默认初始值                                   |
 * | -XX:+PrintFlagsFinal       | 查看所有的参数的最终值（可能会存在修改，不再是初始值）       |
 *      具体查看某个参数的指令： jps => 1、得到<pid> 2、jinfo -flag SurvivorRatio <pid>
 * | -Xms                       | 初始堆空间内存（默认为物理内存的1/64）                       |
 * | -Xmx                       | 最大堆空间内存（默认为物理内存的1/4）                        |
 * | -Xmn                       | 设置新生代的大小（初始值即最大值）<span style="color:red;font-weight:bold;">优先级高</span> |
 * | -XX:NewRatio               | 配置新生代与老年代在堆结构上的占比                           |
 * | -XX:SurvivorRatio          | 设置新生代中Eden和S0/S1空间的比例                            |
 * | -XX:MaxTenuringThreshold   | 设置新生代垃圾的最大年龄                                     |
 * | -XX:+PrintGCDetails        | 输出详细的GC处理日志；打印GC简要信息：<br />1、`-XX:+PrintGC` 2、`-verbose:gc` |
 * | -XX:HandlePromotionFailure | 是否设置空间分配担保                                         |
 */
public class HeapArgsTest {
    public static void main(String[] args) {

    }
}

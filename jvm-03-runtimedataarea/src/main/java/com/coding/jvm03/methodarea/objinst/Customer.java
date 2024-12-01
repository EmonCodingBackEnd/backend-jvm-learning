package com.coding.jvm03.methodarea.objinst;

/**
 * 测试对象实例化的过程
 * 1-加载类元信息；2-为对象分配内存；3-处理并发问题（CAS和TLAB）；4-属性的默认初始化（零值初始化）；5-设置对象头；
 * 6-属性的显式初始化、代码块中初始化、构造器中初始化。
 * <p>
 * 给对象的数下复制的操作：
 * 1、属性的默认初始化
 * 2、显式初始化
 * 3、代码块初始化
 * 4、构造器中初始化
 */
public class Customer {
    int id = 1001;
    String name;
    Account acct;

    {
        name = "匿名客户";
    }

    public Customer() {
        acct = new Account();
    }
}

class Account {

}

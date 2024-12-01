package com.coding.jvm06.gc;

/**
 * 测试Object类中finalize()方法，即对象的 finalization 机制。
 */
public class CanReliveObj {

    public static CanReliveObj obj; // 类变量；属于GC Root

    /**
     * 此方法只能被调用1次
     * <p>
     * 【该方法存在时】：
     * 调用当前类重写的finalize()方法
     * 第1次GC
     * obj is still alive
     * 第2次GC
     * obj is dead
     * <p>
     * 【该方法不存在时】：
     * 第1次GC
     * obj is dead
     * 第2次GC
     * obj is dead
     */
//    @Override
//    protected void finalize() throws Throwable {
//        super.finalize();
//        System.out.println("调用当前类重写的finalize()方法");
//        obj = this; // 当前待回收的对象在finalize()方法中与引用链上的任何一个对象建立了联系，导致当前对象复活
//    }

    public static void main(String[] args) {
        try {
            obj = new CanReliveObj();
            // obj 设置为 null，表示 obj 不引用 CanReliveObj 对象了，它成了垃圾对象
            obj = null;
            System.gc(); // 调用垃圾回收器
            System.out.println("第1次GC");
            // 第1次GC时，重写了finalize()方法，finalize()会被调用
            // finalize()方法中，CanReliveObj对象可能复活
            // 因为Finalizer线程优先级很低，暂停2秒，等待它被CPU调度。
            Thread.sleep(2000);
            if (obj == null) {
                System.out.println("obj is dead");
            } else {
                System.out.println("obj is still alive");
            }
            // 下面这段代码与上面的完全相同，但是这次自救失败了。
            obj = null;
            System.gc();
            System.out.println("第2次GC");
            // 因为Finalizer线程优先级很低，暂停2秒，等待它被CPU调度。
            Thread.sleep(2000);
            if (obj == null) {
                System.out.println("obj is dead");
            } else {
                System.out.println("obj is still alive");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 测试finalize()能否使对象复活
 *
 * @author shanmingda
 * @date 2020-09-30 15:40
 */
public class CanReliveObjDemo {

    /**
     * 类变量 属于GCRoot
     */
    public static CanReliveObjDemo obj;

    /**
     * finalize()方法只调用一次
     * @throws Throwable
     */
    @Override
    protected void finalize() throws Throwable {

        System.out.println("调用当前类重写的finalize()方法");

        // 当前待回收的对象在finalize()方法中与引用链上的任何一个对象建立了联系
        obj = this;
    }

    public static void main(String[] args) {
        try {
            obj = new CanReliveObjDemo();

            obj = null;

            System.out.println("第一次GC");
            // 调用垃圾回收器
            System.gc();
            // 因为Finalizer线程优先级很低 暂停两秒 等待它
            Thread.sleep(2000);
            if (obj == null) {
                System.out.println("obj is dead");
            } else {
                System.out.println("obj is alive");
            }
            System.out.println("第二次GC");
            obj = null;
            // 调用垃圾回收器
            System.gc();
            // 因为Finalizer线程优先级很低 暂停两秒 等待它
            Thread.sleep(2000);
            if (obj == null) {
                System.out.println("obj is dead");
            } else {
                System.out.println("obj is alive");
            }

            //最后打印的结果
            //第一次GC
            //调用当前类重写的finalize()方法
            //obj is alive
            //第二次GC
            //obj is dead
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

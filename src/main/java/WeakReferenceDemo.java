import java.lang.ref.WeakReference;

/**
 * 弱引用
 * 弱引用需要java.lang.ref.WeakReference<T>实现
 * 它比软引用的生命周期更短 对于只有软引用的对象来说
 * 只要垃圾回收机制一运行 不管JVM的内存空间够不够
 * 都会回收该对象的内存
 *
 * @author shanmingda
 * @date 2020-09-22 14:51
 */
public class WeakReferenceDemo {

    public static void main(String[] args) {
        Object o1 = new Object();
        WeakReference<Object> weakReference = new WeakReference<Object>(o1);
        System.out.println(o1);
        System.out.println(weakReference.get());
        //java.lang.Object@61bbe9ba
        //java.lang.Object@61bbe9ba

        o1 = null;
        System.gc();
        System.out.println("===================");

        System.out.println(o1);
        System.out.println(weakReference.get());
        //null
        //null

    }
}

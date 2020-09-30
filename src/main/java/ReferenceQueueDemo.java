import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 *
 * 引用队列
 * SoftReference
 * WeakReference
 * PhantomReference
 * 被GC之后都会被放到ReferenceQueue中去
 *
 * @author shanmingda
 * @date 2020-09-22 16:40
 */
public class ReferenceQueueDemo {

    public static void main(String[] args) {
        Object o1 = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<Object>();
        WeakReference<Object> weakReference = new WeakReference<Object>(o1, referenceQueue);
        System.out.println(o1);
        System.out.println(weakReference.get());

        System.out.println("================");

        o1 = null;
        System.gc();
        System.out.println(o1);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());
    }
}

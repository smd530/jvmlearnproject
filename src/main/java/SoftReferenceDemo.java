import java.lang.ref.SoftReference;

/**
 * 软引用
 * 内存足够的时候不回收 内存不够了回收 需要java.lang.ref.SoftReference<T> 实现
 *
 * 软引用通常应用到对内存敏感的程序中 比如高速缓存中就有用到软引用
 * 内存足够的时候就保留 不够就回收
 *
 * @author shanmingda
 * @date 2020-09-22 11:16
 */
public class SoftReferenceDemo {

    // 内存够用保留 不够回收
    public static void softRefMemoryEnough() {
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<Object>(o1);

        System.out.println(o1);
        System.out.println(softReference.get());
        //java.lang.Object@61bbe9ba
        //java.lang.Object@61bbe9ba

        o1 = null;
        System.gc();
        System.out.println(o1);
        System.out.println(softReference.get());
        //null
        //java.lang.Object@61bbe9ba
    }

    public static void softRefMemoryNotEnough() {
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<Object>(o1);

        System.out.println(o1);
        System.out.println(softReference.get());
        //java.lang.Object@61bbe9ba
        //java.lang.Object@61bbe9ba

        o1 = null;
        System.gc();


        try {
            //创建个30m的大对象
            byte[] bytes = new byte[30 * 1024 * 1024];
            //jvm参数 -Xms -Xmx 都配成 -Xms5m -Xmx5m -XX:+PrintGCDetails 创造内存不够用场景
        } catch (Throwable e) {

        } finally {
            System.out.println(o1);
            System.out.println(softReference.get());
        //null
        //null
        //均被回收
        //因为开启了-XX:+PrintGCDetails所以会打印如下信息
        //  GC (Allocation Failure) [PSYoungGen: 1024K->400K(1536K)] 1024K->400K(5632K), 0.0018540 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
        //  java.lang.Object@61bbe9ba
        //  java.lang.Object@61bbe9ba
        //  [GC (System.gc()) [PSYoungGen: 808K->496K(1536K)] 808K->504K(5632K), 0.0008373 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
        //  [Full GC (System.gc()) [PSYoungGen: 496K->0K(1536K)] [ParOldGen: 8K->367K(4096K)] 504K->367K(5632K), [Metaspace: 3058K->3058K(1056768K)], 0.0034506 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
        //  [GC (Allocation Failure) [PSYoungGen: 0K->0K(1536K)] 367K->367K(5632K), 0.0002834 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
        //  [GC (Allocation Failure) [PSYoungGen: 0K->0K(1536K)] 367K->367K(5632K), 0.0002498 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
        //  [Full GC (Allocation Failure) [PSYoungGen: 0K->0K(1536K)] [ParOldGen: 367K->367K(4096K)] 367K->367K(5632K), [Metaspace: 3058K->3058K(1056768K)], 0.0028977 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
        //  [GC (Allocation Failure) [PSYoungGen: 0K->0K(1536K)] 367K->367K(5632K), 0.0002383 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
        //  [Full GC (Allocation Failure) [PSYoungGen: 0K->0K(1536K)] [ParOldGen: 367K->349K(4096K)] 367K->349K(5632K), [Metaspace: 3058K->3058K(1056768K)], 0.0030147 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
        //  null
        //  null
        //  Heap
        //  PSYoungGen      total 1536K, used 62K [0x00000007bfe00000, 0x00000007c0000000, 0x00000007c0000000)
        //  eden space 1024K, 6% used [0x00000007bfe00000,0x00000007bfe0f870,0x00000007bff00000)
        //  from space 512K, 0% used [0x00000007bff00000,0x00000007bff00000,0x00000007bff80000)
        //  to   space 512K, 0% used [0x00000007bff80000,0x00000007bff80000,0x00000007c0000000)
        //  ParOldGen       total 4096K, used 349K [0x00000007bfa00000, 0x00000007bfe00000, 0x00000007bfe00000)
        //  object space 4096K, 8% used [0x00000007bfa00000,0x00000007bfa57690,0x00000007bfe00000)
        //  Metaspace       used 3067K, capacity 4496K, committed 4864K, reserved 1056768K
        //  class space    used 337K, capacity 388K, committed 512K, reserved 1048576K

        }
    }

    public static void main(String[] args) {
//        softRefMemoryEnough();
        softRefMemoryNotEnough();
    }
}

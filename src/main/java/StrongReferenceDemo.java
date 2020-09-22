/**
 * 强引用
 *
 * @author shanmingda
 * @date 2020-09-22 11:00
 */
public class StrongReferenceDemo {

    public static void main(String[] args) {
        // 这种默认的就是强引用
        Object obj1 = new Object();
        //obj2引用赋值
        Object obj2 = obj1;
        //置空
        obj1 = null;
        System.gc();
        System.out.println(obj2);

        //obj2不会被垃圾回收掉

    }

}

import java.util.Random;

/**
 * OutOfMemoryError Java堆溢出
 *
 * @author shanmingda
 * @date 2020-09-22 20:47
 */
public class OutOfMemoryErrorDemo {

    public static void main(String[] args) {
        String str = "abc";

        while (true) {
            str += str + new Random().nextInt(111111111) + new Random().nextInt(222222222);
            str.intern();
        }
    }

    //Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
    //	at java.util.Arrays.copyOf(Arrays.java:3332)
    //	at java.lang.AbstractStringBuilder.ensureCapacityInternal(AbstractStringBuilder.java:124)
    //	at java.lang.AbstractStringBuilder.append(AbstractStringBuilder.java:674)
    //	at java.lang.StringBuilder.append(StringBuilder.java:208)
    //	at OutOfMemoryErrorDemo.main(OutOfMemoryErrorDemo.java:15)
}

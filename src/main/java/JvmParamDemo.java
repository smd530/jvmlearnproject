/**
 * -Xmx 最大堆内存
 * -Xms 初始堆内存
 *
 * @author shanmingda
 * @date 2020-09-22 10:58
 */
public class JvmParamDemo {

    public static void main(String[] args) {

        // JAVA虚拟机中的内存总量
        long totalMemory = Runtime.getRuntime().totalMemory();
        // JAVA虚拟机试图使用的最大内存
        long maxMemory = Runtime.getRuntime().maxMemory();

        System.out.println("totalMemory（-Xms）= " + totalMemory + "字节" + (totalMemory / (double)1024 / 1024) + "MB");
        System.out.println("maxMemory（-Xmx）= " + totalMemory + "字节" + (totalMemory / (double)1024 / 1024) + "MB");

    }
}

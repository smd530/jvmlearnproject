/**
 * 类加载器Demo
 *
 * @author shanmingda
 * @date 2020-09-24 18:46
 */
public class  ClassLoaderDemo {

    public static void main(String[] args) {
        Object o = new Object();

        // 获取类加载器
//        System.out.println(o.getClass().getClassLoader());
        //null

        ClassLoaderDemo demo = new ClassLoaderDemo();


//        sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(demo.getClass().getClassLoader());
//        sun.misc.Launcher$ExtClassLoader@61bbe9ba
        System.out.println(demo.getClass().getClassLoader().getParent());
        // null
        System.out.println(demo.getClass().getClassLoader().getParent().getParent());
//        null

//        sun.misc.Launcher 是JVM的入口引用类
    }

}

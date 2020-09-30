import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * WeakHashMap
 *
 * @author shanmingda
 * @date 2020-09-22 15:39
 */
public class WeakHashMapDemo {

    public static void main(String[] args) {
        myHashMap();
        System.out.println("===============");
        myWeakHashMap();
    }

    private static void myHashMap() {
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        Integer key = new Integer(1);
        String value = "hashMap";
        map.put(key, value);

        key = null;
        System.out.println(map);
        System.out.println("========");
        System.gc();
        System.out.println(map);

        //{1=hashMap}
        //========
        //{1=hashMap}
    }

    private static void myWeakHashMap() {
        WeakHashMap<Integer, String> weakHashMap = new WeakHashMap<Integer, String>();
        Integer key = new Integer(2);
        String value = "weakHashMap";
        weakHashMap.put(key, value);

        key = null;
        System.out.println(weakHashMap);
        System.out.println("========");
        System.gc();
        System.out.println(weakHashMap);

        //{2=weakHashMap}
        //========
        //{}
    }
}

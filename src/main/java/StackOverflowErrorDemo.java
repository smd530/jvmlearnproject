/**
 * 栈溢出
 *
 * @author shanmingda
 * @date 2020-09-22 18:26
 */
public class StackOverflowErrorDemo {

    public static void main(String[] args) {
        stackOverflowError();
    }

    private static void stackOverflowError() {
        stackOverflowError();

        //会输出
        //Exception in thread "main" java.lang.StackOverflowError
        //	at StackOverflowErrorDemo.stackOverflowError(StackOverflowErrorDemo.java:14)
        //	at StackOverflowErrorDemo.stackOverflowError(StackOverflowErrorDemo.java:14)
        //	at StackOverflowErrorDemo.stackOverflowError(StackOverflowErrorDemo.java:14)
        //	at StackOverflowErrorDemo.stackOverflowError(StackOverflowErrorDemo.java:14)
        //	at StackOverflowErrorDemo.stackOverflowError(StackOverflowErrorDemo.java:14)
        //	at StackOverflowErrorDemo.stackOverflowError(StackOverflowErrorDemo.java:14)
    }
}

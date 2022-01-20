package java8.general;

public class StringSplitTest {
    public static void main(String args[]) {
        String s = "BNSX 99002";
        String[] arr = s.split(" ");

        System.out.println(arr[0]);
        System.out.println(arr[1]);


        //When string null
        s = "";
        arr = s.split(" ");

        System.out.println(arr[0]);
        System.out.println(arr[1]);
    }
}

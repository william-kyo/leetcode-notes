package search.backtracking;

public class RestoreIpAddress {
    public static void main(String[] args) {
        String str = "256.01";
        String[] arr = str.split("\\.");
        String last = arr[arr.length - 1];
        System.out.println(Integer.valueOf(last).compareTo(255));

        String[] arr2 = "".split("\\.");
        System.out.println(arr2.length);
        System.out.println(arr2[0]);

        System.out.println("".length());
    }
}

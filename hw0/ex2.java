public class ex2 {
    public static int max(int[] m) {
        int maxnum=m[0];
        for (int i = 1; i < m.length; i += 1){
            if (m[i] > maxnum){
                maxnum=m[i];
            }
        }
        return maxnum;
    }
    public static void main(String[] args) {
       int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
       System.out.print(max(numbers)); 
    }
 }
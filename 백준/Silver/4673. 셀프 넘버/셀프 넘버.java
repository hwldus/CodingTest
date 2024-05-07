public class Main {
    public static void main(String[] args) {
        int[] arr = new int[10000];
        for(int i=0; i<10000; i++) {
            int num = dx(i+1);
            if(num <= 10000)
                arr[num-1] = 1;
        }
        for(int i=0; i<10000; i++) {
            if(arr[i]==0)
                System.out.println(i+1);
        }
    }
    public static int dx(int n) {
        int sum = n;
        while(n != 0) {
            sum += n%10;
            n = n/10;
        }
        return sum;
    }
}
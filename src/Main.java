import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a=1000;
        int b=1000;
        int c=1000;
//        while (in.hasNextInt()) {
//             a = in.nextInt();
//             b = in.nextInt();
//             c = in.nextInt();
//        }
        if(a>b){
            for(int i=b;;i--){
               int s= a*(b-i);
               if(s>c){
                   System.out.println(i+1);
                   break;
               }

            }
        }
        else {
            for(int i=a;;i--){
                int s= b*(a-i);
               // System.out.println(a+" "+i);
                if(s>c){
                    System.out.println(i+1);
                    break;
                }

            }
        }

    }
}



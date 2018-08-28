import java.util.Scanner;

public class CountOne {
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();

        System.out.println(countOne1(n));
        System.out.println(countOne2(n));
        System.out.println(countOne3(n));
    }

    public static int countOne1(int v){
        int num = 0;
        while(v>=1){
            if(v%2==1){
                num++;
            }
            v=v/2;
        }
        return num;
    }

    //常规算法
    public static int countOne2(int v){

        int num=0;
        while (v>=1){
            num =num + (v&0x01);
            //num += v&0x01;
            v=v>>1;
        }
        return num;
    }

    //最高效的算法 有几个1就循环几次
    public static  int countOne3(int v){
        int num=0;
        while (v>0){
            v = v&(v-1);
            num++;
        }
        return num;
    }
}

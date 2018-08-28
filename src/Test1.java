import java.util.Scanner;

public class Test1 {
        public static void main(String args[]){
            Scanner sc =  new Scanner(System.in);
            int N= sc.nextInt();
            int M= sc.nextInt();


            int[][] jobs = new int[N][2];
            for(int i=0;i <N;i++){
                jobs[i][0]=sc.nextInt();
                jobs[i][1]=sc.nextInt();
            }

            int[] ability = new int[M];
            for (int i =0; i<M ;i++){
                ability[i] = sc.nextInt();
            }
            sc.close();
            int[] MaxReward = maxReward(jobs,ability);
            for(int i:MaxReward){
                System.out.println(i);
            }

        }

        public static int[] maxReward(int[][] jobs, int[] ability){
            int[] maxReward = new int[ability.length];
            for(int i=0;i<maxReward.length;i++){
                maxReward[i]=0;
            }

            for(int i=0;i<ability.length;i++){
                for(int j=0; j<jobs.length;j++) {
                    if(ability[i] >= jobs[j][0]) {
                        if (maxReward[i] < jobs[j][1]) {
                            maxReward[i] = jobs[j][1];
                        }
                    }
                }
            }

            return maxReward;

        }


    }
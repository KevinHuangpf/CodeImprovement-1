public class dijkstra {
	private static int IMAX = 999999; //����ͨ״̬  
    public static int[][] adjMat = {  
        {0,3,2,9999},
            {3,0,9999,5},
            {2,9999,0,7},
            {9999,5,7,0},

       
    };  
      
    public static void main(String[] args) {  
    	dijkstra dijstraAlgorithm = new dijkstra();  
        int start = 0;  
        int end = 3;
        System.out.println("------����------");  
        System.out.println("\n��" + start + "��" + end   
                + "�ľ�����:" + dijstraAlgorithm.reslove(adjMat, start, end));  
          
        
    }  
      
    /** 
     * �����ڽӾ���adjMat��ʾ��ͼ�У����ӵ�s����t�����·�� 
     * @param adjMat �ڽӾ��� 
     * @param s ��� 
     * @param t �յ� 
     * @return 
     */  
    public int reslove(int[][] adjMat,int s,int t) {  
          
        //�жϲ����Ƿ���ȷ  
        if(s < 0 || t < 0 || s >=adjMat.length || t >= adjMat.length) {  
            System.out.println("���󣬶��㲻��ͼ��!");  
            return IMAX;  
        }  
          
        //������¼ĳ�������Ƿ��Ѿ���ɱ�������������ȶ��е�"�Ƴ�����"����  
        boolean[] isVisited = new boolean[adjMat.length];  
        //���ڴ洢��s��������֮������·������  
        int[] d = new int[adjMat.length];   
          
        //��ʼ������  
        for(int i=0;i<adjMat.length;i++) {  
            isVisited[i] = false;  
            d[i] = IMAX;  
        }  
        d[s] = 0; //s��s�ľ�����0   
        isVisited[s] = true; //��s���Ϊ�ѷ��ʹ���
        //��δ�����Ķ�����Ŀ��������ȶ����Ƿ�Ϊ�յ��жϼ�Queue.isEmpty()  
        int unVisitedNum = adjMat.length;  
        //���ڱ�ʾ��ǰ���������·����Ȩ����С�Ķ��������,��Ӧ���ȶ�����,Ĭ�������  
        int index = s;   
        while(unVisitedNum > 0 && index != t) {  
            int min = IMAX;  
            for(int i=0;i<adjMat.length;i++) { //ȡ����i�е���СԪ�ص�����  
                if(min > d[i] && !isVisited[i]) {  
                    min = d[i];  
                    index = i;  
                }  
            }  
  
            for(int i=0;i<adjMat.length;i++) {  
                if(d[index] + adjMat[index][i] < d[i]) {  
                    d[i] = d[index] + adjMat[index][i];  
                }  
            }  
            if(index == t || unVisitedNum == 0) {  
                System.out.print(index); //��ӡ���·��  
            } else {  
                System.out.print(index + "=>"); //��ӡ���·��  
            }
            unVisitedNum --;  
            isVisited[index] = true;  
        }
        return d[t];  
    }  
}  
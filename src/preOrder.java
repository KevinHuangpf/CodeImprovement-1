import java.util.HashMap;
import java.util.Hashtable;
import java.util.Stack;

public class preOrder {

    public class Node {
        private int data;
        private Node leftNode;
        private Node rightNode;
        public Node(int data, Node leftNode, Node rightNode){
            this.data = data;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }

        public int getData() {
            return data;
        }
        public void setData(int data) {
            this.data = data;
        }
        public Node getLeftNode() {
            return leftNode;
        }
        public void setLeftNode(Node leftNode) {
            this.leftNode = leftNode;
        }
        public Node getRightNode() {
            return rightNode;
        }
        public void setRightNode(Node rightNode) {
            this.rightNode = rightNode;
        }
    }

    public Node init() {//ע��������������Ƚ����ӽڵ㣬���������Ͻ�������Ϊ��Ҷ�ӽ���ʹ�õ�����Ľڵ㣬����ʼ���ǰ�˳���ʼ���ģ����������ᱨ��
        Node J = new Node(8, null, null);
        Node H = new Node(4, null, null);
        Node G = new Node(2, null, null);
        Node F = new Node(7, null, J);
        Node E = new Node(5, H, null);
        Node D = new Node(1, null, G);
        Node C = new Node(9, F, null);
        Node B = new Node(3, D, E);
        Node A = new Node(6, B, C);
        return A;   //���ظ��ڵ�
    }

    public void printNode(Node node){
        System.out.print(node.getData());
    }


    public void theFirstTraversal_Stack(Node root) {  //�������
        Stack<Node> stack = new Stack<Node>();
        Node node = root;
        while (node != null || stack.size() > 0) {  //����������ѹջ
            if (node != null) {   //ѹջ֮ǰ�ȷ���
                printNode(node);
                stack.push(node);
                node = node.getLeftNode();
            } else {
                node = stack.pop();
                node = node.getRightNode();
            }
        }
    }

    public void theInOrderTraversal_Stack(Node root) {  //�������
        Stack<Node> stack = new Stack<Node>();
        Node node = root;
        while (node != null || stack.size() > 0) {
            if (node != null) {
                stack.push(node);   //ֱ��ѹջ
                node = node.getLeftNode();
            } else {
                node = stack.pop(); //��ջ������
                printNode(node);
                node = node.getRightNode();
            }
        }
    }

    public void thePostOrderTraversal_Stack(Node root) {   //�������
        Stack<Node> stack = new Stack<Node>();
        Stack<Node> output = new Stack<Node>();//����һ���м�ջ���洢���������Ľ��
        Node node = root;
        while (node != null || stack.size() > 0) {
            if (node != null) {
                output.push(node);
                stack.push(node);
                node = node.getRightNode();
            } else {
                node = stack.pop();
                node = node.getLeftNode();
            }
        }
        System.out.println(output.size());
        while (output.size() > 0) {

            printNode(output.pop());
        }
    }

    public static void main(String[] args) {
        preOrder tree = new preOrder();
        Node root = tree.init();
        System.out.println("�������");
        tree.theFirstTraversal_Stack(root);
        System.out.println("");
        System.out.println("�������");
        tree.theInOrderTraversal_Stack(root);
        System.out.println("");
        System.out.println("�������");
        tree.thePostOrderTraversal_Stack(root);
        System.out.println("");
        HashMap<String, String> map = new HashMap<>();
        map.put("aa", "@sohu.com");

        map.put("bb","@163.com");

        map.put("cc", "@sina.com");
        System.out.println("��ͨ�ı���������ͨ��Map.keySet����key��value");//��ͨʹ�ã�����ȡֵ

        for (String key : map.keySet()) {

            System.out.println("key= "+key+" and value= "+map.get(key));

        }

    }
}
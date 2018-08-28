
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class HuffmanPad extends JFrame {
	DefaultListModel m = new DefaultListModel();
	JList jta = new JList(m);
	JScrollPane jsp = new JScrollPane(jta);
	JLabel jlb = new JLabel("请输入一组数(数与数之间用一个空格隔开)：");
	JTextField jtf = new JTextField();
	JButton jb1 = new JButton("确定结束添加");
	JButton jb2 = new JButton("编码");
	private List<Double> nums;
	private List<Double> numsMo;
	private List<Tree> trees;
	private String temp;
	int i;

	public static void main(String[] args) {
		
		new HuffmanPad().setVisible(true);
	}

	public HuffmanPad() {
		init();// 初始化操作
		this.setTitle("霍夫曼编码");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);// 是否需要同时关闭窗口
		this.setLocation(200, 200);
		this.setSize(300, 300);
		this.setVisible(true);
	}

	private void init() {
		nums = new ArrayList<Double>();
		numsMo = new ArrayList<Double>();
		trees = new ArrayList<Tree>();
		temp = "";
		
		jtf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNums();
			}
		});
		jb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OverNumIn();
			}
		});
		jb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coding();
			}
		});
		jta.setBackground(new Color(205, 245, 245));
		GridBagLayout layout = new GridBagLayout();// 建立一个GridBagLayout的对象
		this.setLayout(layout);// 将GridBagLayout对象设置为组件的布局管理器
		this.add(jlb);
		this.add(jtf);
		this.add(jb1);
		this.add(jb2);
		this.add(jsp);
		GridBagConstraints s = new GridBagConstraints();
		s.fill = GridBagConstraints.BOTH;// 
		s.gridwidth = 0;
		s.gridheight=2;
		s.weightx = 1;
		s.weighty = 1;
		layout.setConstraints(jlb, s);

		s.fill = GridBagConstraints.BOTH;//
		s.gridwidth = 0;
		s.gridheight=1;
		s.weightx = 1;
		s.weighty = 1;
		layout.setConstraints(jtf, s);

		s.fill = GridBagConstraints.NONE;//
		s.gridwidth = 0;
		s.gridheight=2;
		s.weightx = 1;
		s.weighty = 1;
		layout.setConstraints(jb1, s);

		s.fill = GridBagConstraints.NONE;// 
		s.gridwidth = 0;
		s.gridheight=2;
		s.weightx = 1;
		s.weighty = 1;
		layout.setConstraints(jb2, s);

		s.fill = GridBagConstraints.BOTH;// 
		s.gridwidth = 0;
		s.gridheight=6;
		s.weightx = 100;
		s.weighty = 100;
		layout.setConstraints(jsp, s);
	}

	protected void OverNumIn() {
		
		
	}

	protected void coding() {//编码
		addNums();
		compareNum(nums, trees);
		while (numsMo.size() > 1) {
			double[] mins = minTwo(numsMo);
			if (mins[0] != mins[1]) {
				numsMo.remove(Double.valueOf(mins[0]));
				write(mins[0]);
			}
		}
		if (!numsMo.isEmpty()) {
			write(numsMo.get(0));
		}

	}

	private void write(double d) {//在Jlist中打印出最终结果
		temp = "";
		print(d);
		m.add(i,'\n'+"数字： "+d +"    编码：  "+temp+"    码长：" + temp.length());
		
	}
	public void print(double num) {// 递归打印编码
		for (Tree t : trees) {
			if (num == t.getRchild()) {
				temp = 1 + temp;
				print(t.getParents());
				break;
			} else if (num == t.getLchild()) {
				temp = 0 + temp;
				print(t.getParents());
				break;
			}
		}
	}

	protected void addNums() {
		String str = jtf.getText();
		String[] strs = str.split(" ");//字符串，用空格分割存入ArrayList中，不能间夹两个空格
		for (int i = 0; i < strs.length; i++) {
			nums.add(Double.parseDouble(strs[i]));
			numsMo.add(Double.parseDouble(strs[i]));
		}
       
	}
	public void compareNum(List<Double> nums, List<Tree> trees) {  // 递归算法
		double[] min = new double[2];
		if (nums.size() > 1) {
			min = minTwo(nums);
			Tree t = new Tree(min[0], min[1], min[0] + min[1]);
			nums.remove(Double.valueOf(min[0]));
			nums.remove(Double.valueOf(min[1]));
			nums.add(min[0] + min[1]);
			trees.add(t);
			compareNum(nums, trees);
		}
	}
	public double[] minTwo(List<Double> nums) {// 在一组数中选则最小的两个，按递增排序返回
		Double temp = 0.0;
		for (int j = 0; j < 2; j++) {
			for (int i = 1; i < nums.size(); i++) {
				if (nums.get(i - 1) < nums.get(i)) {
					temp = nums.get(i);
					nums.set(i, nums.get(i - 1));
					nums.set(i - 1, temp);
				}
			}
		}
		double[] n = { nums.get(nums.size() - 1), nums.get(nums.size() - 2) };
		return n;
	}

}

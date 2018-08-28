

public class Tree {//定义了一个树类
	double lChild, rChild, parent;//左右孩子，父节点

	public Tree(double lChild, double rChild, double parent) {
		this.lChild = lChild;
		this.rChild = rChild;
		this.parent = parent;
	}

	public double getLchild() {
		return lChild;
	}

	public void setLchild(double lChild) {
		this.lChild = lChild;
	}

	public double getRchild() {
		return rChild;
	}

	public void setRchild(double rChild) {
		this.rChild = rChild;
	}

	public double getParents() {
		return parent;
	}

	public void setParents(double root) {
		this.parent = root;
	}
}

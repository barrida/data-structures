package algorthims;

public class BinaryTree {
	public Node node;

	public BinaryTree() {
		
	}

	public void addRoot(Node node) {
		this.node.setData(node.getData());
	}

	public void addLeftChild(Node node) throws Exception {
		this.node.setLeftChild(node);
	}

	public void addRightChild(Node node) throws Exception {
		this.node.setRightChild(node);
	}
	
	public void insert(Node node){
		try {
			addLeftChild(node);
			addRightChild(node);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

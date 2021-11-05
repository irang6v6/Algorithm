package LeetCode;

//LeetCode127. Sum Root to Leaf Numbers - DFS(������̴�)
//����Ʈ���� ���̿켱Ž���ϸ� 1-2-3=123���� �� Ž������ ������ ���Ͽ��� 
public class LC129 {
	public int sumNumbers(TreeNode root) {
		return recur(root, 0);
	}

	public int recur(TreeNode node, int val) {
		if (node == null)
			return 0;

		// �θ��尡 �� ���� 10�� ���ϰ� ���� ��Ʈ���� ���Ѵ�
		int sum = val * 10 + node.val;

		// ������ �ڽĳ��
		if (node.left == null && node.right == null)
			return sum;

		// �ڽĳ�Ʈ�� ������
		return recur(node.left, sum) + recur(node.right, sum);
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

}

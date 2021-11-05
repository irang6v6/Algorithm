package LeetCode;

//LeetCode127. Sum Root to Leaf Numbers - DFS(재귀적이다)
//이진트리를 깊이우선탐색하며 1-2-3=123으로 각 탐색값의 총합을 구하여라 
public class LC129 {
	public int sumNumbers(TreeNode root) {
		return recur(root, 0);
	}

	public int recur(TreeNode node, int val) {
		if (node == null)
			return 0;

		// 부모노드가 준 값에 10을 곱하고 현재 노트값을 더한다
		int sum = val * 10 + node.val;

		// 최하위 자식노드
		if (node.left == null && node.right == null)
			return sum;

		// 자식노트로 내려감
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

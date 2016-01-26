package org.mai.tree;

public class DeepthRecurseVisitor implements IVisitor {

	public String print(Node root) {
		return String.valueOf(deepth(root));
	}
	/**
	 * 递归方式获得树深度
	 * @param currentNode
	 * @return
	 */
	public int deepth( Node currentNode ) {
		//若节点为空，意味着已经到达叶子节点
		if ( currentNode == null ) return 0;
		//否则继续向下递归
		int l = deepth( currentNode.getLeft() );
		int r = deepth( currentNode.getRight());
		return l > r ? ++l:++r;
	}

}

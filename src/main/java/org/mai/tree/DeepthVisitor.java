package org.mai.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 输出树深度
 *
 */
public class DeepthVisitor implements IVisitor {

	public String print( final Node root) {
		Queue<Node> currentLevel = new LinkedList<Node>();
		currentLevel.add(root);
		int deepth = 0;
		//对树的每一层进行循环，直到到达全无节点的层，即为树的最大深度
		while ( !currentLevel.isEmpty()) {
			currentLevel = getChilderenByParents(currentLevel);
			deepth++;
		}//#while
		return String.valueOf( deepth );
	}
	/**
	 * 根据树当前层次节点组获得下级节点组
	 * @param queue
	 * @return
	 */
	protected static Queue<Node> getChilderenByParents(Queue<Node> queue )  {
		final Queue<Node> outQueue = new LinkedList<Node>();
		//遍历本层节点，获取左右非空子节点，压入新队列
		while( !queue.isEmpty()) {
			Node each = queue.remove();
			//添加左、右节点到队列
			addIfNodeNotNull( each.getRight(), addIfNodeNotNull ( each.getLeft() , outQueue) );
		}//#while
		return outQueue;
	}
	
	/**
	 * 如节点不为空则添加入队列
	 * @param node
	 * @param queue
	 * @return
	 */
	protected static Queue<Node> addIfNodeNotNull(final Node node, final Queue<Node> queue ) {
		if (node != null ) queue.add(node);
		return queue;
	}
	

}

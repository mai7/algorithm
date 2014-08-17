package org.mai;

import java.util.LinkedList;
import java.util.Queue;
/**
 * 层次遍历并输出
 *
 */
public class LevelTraverseVisitor extends DeepthVisitor {
	
	@Override
	public String print(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		StringBuilder sb = new StringBuilder();
		/**
		 * 循环树每一层，并依据节点值依次构建字符串
		 */
		while( !queue.isEmpty() ) {
			for ( Node each: queue ) {
				sb.append(each.getValue()+" ");
			}
			sb.append("/");
			queue = getChilderenByParents(queue);
		}//#while
		return sb.substring(0,sb.length()-1);
	}

}

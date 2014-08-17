package org.mai;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class TreeVisitorTest {
	
	private Tree tree ;
	/**
	 * 构建如下树用于测试：
	 <pre>
		    5
		   / \
		  3   6
		 / \   \
		2   4   7

	 </pre>
	 **/
	@Before
	public void setUp() {
		tree = new Tree();
		tree.addNode(5);
		tree.addNode(3);
		tree.addNode(2);
		tree.addNode(4);
		tree.addNode(6);
		tree.addNode(7);
	}
	
	/**
	 * 测试树深度
	 */
	@Test
	public void testDeepthVisit() {
		IVisitor visitor = new DeepthVisitor();
		String out = tree.visit(visitor);
		Assert.assertEquals("3", out);	
	}
	
	/**
	 * 测试树层次遍历
	 */
	@Test
	public void testLevelVisit() {
		IVisitor visitor = new LevelTraverseVisitor();
		String out = tree.visit(visitor);
		Assert.assertEquals("5 /3 6 /2 4 7 ", out);
	}
	
	/**
	 * 测试树深度,使用递归
	 */
	@Test
	public void testDeepthRecurseVisitor() {
		IVisitor visitor = new DeepthRecurseVisitor();
		String out = tree.visit(visitor);
		Assert.assertEquals("3", out);	
	}


}

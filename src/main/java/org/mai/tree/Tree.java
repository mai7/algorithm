package org.mai.tree;

public class Tree {
	
	private Node root;
	/**
	 * 为树添加节点
	 * @param value 待插入节点值
	 */
	public void addNode( int value ) {
		Node newNode = new Node( value );
		if ( root == null ) {
			root = newNode;
		}else{
			//当前节点为根节点
			Node currentNode = root;
			while ( true ) {
				Node parent = currentNode;
				//若当前值大于待插入值，将当前节点设为左节点
				if ( currentNode.getValue() > value ) {
					currentNode = currentNode.getLeft();
					//若左节点不存在，则设定待插入节点为左值并退出循环
					if ( currentNode == null ){
						parent.setLeft( newNode );
						return;
					}//#if
						
				} else{
					currentNode = currentNode.getRight();
					if ( currentNode == null ){
						parent.setRight( newNode );
						return;
					}//#if
						
				}	
				
			}//#while
		
		}//#else
		
	}
	
	public String visit( IVisitor visit ) {
		if ( this.root == null ) return "empty tree";
		return visit.print(this.root);
	}

}

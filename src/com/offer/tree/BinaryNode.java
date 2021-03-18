package com.offer.tree;

public class BinaryNode<AnyType>{
	AnyType data;
	BinaryNode<AnyType> left;
	BinaryNode<AnyType> right;
	
	public BinaryNode(){
		
	}
	public BinaryNode(AnyType data){
		this(data, null, null);
	}
	public BinaryNode(AnyType data, BinaryNode<AnyType> left, BinaryNode<AnyType> right){
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
}

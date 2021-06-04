package com.fenyun.ws.manager.thead;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeTest {


	public static class TreeNode {
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

	public static void main(String[] args) {

//来源的数组
		Integer[] data = {3,9,20,1,null,8,21,null};
		//创建二叉树
		TreeNode treeNode = createTree(data, 0);

		System.out.println(list(treeNode));;


	}

	private static int showTree3(TreeNode treeNode){


		if (treeNode == null) {
			return 0;
		} else {
			int leftHeight = showTree3(treeNode.left);
			int rightHeight = showTree3(treeNode.right);
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}
	private static List list(TreeNode treeNode){

		if(treeNode==null) return new ArrayList();

		List<Integer> list=new ArrayList<>();
		List<Integer> listLeft=list(treeNode.left);
		List<Integer> listRight=list(treeNode.right);

		list.addAll(listLeft);
		list.add(treeNode.val);
		list.addAll(listRight);
		return list;

	}

	private static void showTree(TreeNode treeNode){

		if(treeNode==null) return ;

		showTree(treeNode.left);
		System.out.println(treeNode.val);
		showTree(treeNode.right);
	}
	private static TreeNode createTree(Integer []array,int index){
		TreeNode treeNode = null;
		if (index<array.length) {
			Integer value = array[index];
			if (value == null) {
				return null;
			}
			treeNode = new TreeNode(value);
			treeNode.left = createTree(array, 2*index+1);
			treeNode.right = createTree(array, 2*index+2);
			return treeNode;
		}
		return treeNode;
	}

}

package com.fenyun.ws.manager.thead;

import java.util.*;

public class NodeDemo {
	static class Node {
		public int val;
		public List<Node> neighbors;
		public Node() {
			val = 0;
			neighbors = new ArrayList<Node>();
		}
		public Node(int _val) {
			val = _val;
			neighbors = new ArrayList<Node>();
		}
		public Node(int _val, ArrayList<Node> _neighbors) {
			val = _val;
			neighbors = _neighbors;
		}
	}

	public static void main(String[] args) {
		Node node1=new Node(1);
		Node node2=new Node(2);
		Node node3=new Node(3);
		Node node4=new Node(4);
		Node node5=new Node(5);
		node1.neighbors=new ArrayList<Node>(){{
			add(node2);
			add(node4);
		}};

		node2.neighbors=new ArrayList<Node>(){{
			add(node5);
			add(node1);
			add(node3);

			}};

		node3.neighbors=new ArrayList<Node>(){{
			add(node2);
			add(node4); }};

		node4.neighbors=new ArrayList<Node>(){{
			add(node1);
			add(node3); }};

		Map<Node, Node> lookup = new HashMap<>();
		//dfs(node1,lookup);
		cloneGraph(node1);
	}



	private static void dfs(Node node, Map<Node,Node> lookup) {
		if (node == null) return;
		if (lookup.containsKey(node)) return;

		lookup.put(node,node);
		System.out.println(node.val);
		for (Node n : node.neighbors){
			dfs(n,lookup);
			}

	}

	public static void cloneGraph(Node node) {
		if (node == null) return ;
		Map<Node, Node> lookup = new HashMap<>();
		//Node clone = new Node(node.val, new ArrayList<>());
		lookup.put(node, node);
		Deque<Node> queue = new LinkedList<>();

		queue.offer(node);
		while (!queue.isEmpty()) {
			Node tmp = queue.poll();
			System.out.println(tmp.val);
			for (Node n : tmp.neighbors) {

				if (!lookup.containsKey(n)) {
					lookup.put(n, n);
					queue.offer(n);
				}
				//lookup.get(tmp).neighbors.add(lookup.get(n));
			}
		}
		return ;
	}



}

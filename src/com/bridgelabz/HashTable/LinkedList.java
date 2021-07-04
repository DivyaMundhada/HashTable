package com.bridgelabz.HashTable;

import java.util.ArrayList;

public class LinkedList<K, V> {
	MyMapNode head;
	MyMapNode tail;
	private final int numOfBuckets;
	ArrayList<MyMapNode<K, V>> myBucketArray;

	public LinkedList() {
		this.numOfBuckets = 20;
		this.myBucketArray = new ArrayList<>();
		for (int i = 0; i < numOfBuckets; i++)
			this.myBucketArray.add(null);
	}

	public void add(K key, V value) {
		int index = this.getBucketIndex(key);
		MyMapNode<K, V> myNode = this.myBucketArray.get(index);
		if (myNode == null) {
			myNode = new MyMapNode<>(key, value);
			this.myBucketArray.set(index, myNode);
		}
		myNode = (MyMapNode<K, V>) searchNode(key);
		if (myNode == null) {
			myNode = new MyMapNode<>(key, value);
			this.append(myNode);
		} else {
			myNode.setValue(value);
		}
	}

	public void append(MyMapNode myNode) {
		if (this.head == null)
			this.head = myNode;
		if (this.tail == null)
			this.tail = myNode;
		else {
			this.tail.setNext(myNode);
			this.tail = myNode;
		}
	}

	public MyMapNode<K, V> searchNode(K data) {
		MyMapNode currentNode = head;
		int position = 0;
		while (currentNode != null) {
			position++;
			if (currentNode.getKey().equals(data)) {
				return currentNode;
			}
			currentNode = currentNode.getNext();
		}
		return currentNode;
	}

	public V get(K word) {
		int index = this.getBucketIndex(word);
		if (this.myBucketArray.get(index) == null)
			return null;
		MyMapNode<K, V> myMapNode = searchNode(word);
		return (myMapNode == null) ? null : myMapNode.getValue();
	}

	private int getBucketIndex(K word) {
		int hashCode = Math.abs(word.hashCode());
		int index = hashCode % numOfBuckets;
		return index;
	}

	@Override
	public String toString() {
		return "MyLinkedListNodes{ " + head + " }";
	}

	public void printNodes() {
		System.out.println("My nodes: " + head);
	}
}
package com.bridgelabz.HashTable;

public class LinkedList<K,V> {
	 MyMapNode head;
	    MyMapNode tail;

	    public void add(K key, V value) {
	        MyMapNode<K, V> myNode = (MyMapNode<K, V>) searchNode(key);
	        if(myNode == null) {
	            myNode = new MyMapNode<>(key , value);
	            this.append(myNode);
	        }
	        else {
	            myNode.setValue(value);
	        }
	    }

	    public void append(MyMapNode myNode) {
	        if(this.head == null)
	            this.head = myNode;
	        if(this.tail == null)
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
	        MyMapNode<K, V> myMapNode = searchNode(word);
	        return (myMapNode == null) ? null : myMapNode.getValue();
	    }

	    @Override
	    public String toString() {
	        return "MyLinkedListNodes{ " + head + " }";
	    }

	    public void printNodes() {
	        System.out.println("My nodes: " + head);
	    }
}

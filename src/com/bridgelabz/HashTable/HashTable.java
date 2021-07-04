package com.bridgelabz.HashTable;

public class HashTable {
	public static void main(String[] args) {
		LinkedList<String, Integer> object = new LinkedList();
		 String message = "Paranoids are not paranoid because they are paranoid but " +
	                "because they keep putting themselves deliberately into paranoid avoidable situations";

		String[] messageArray = message.toLowerCase().split(" ");

		for (String word : messageArray) {

			Integer value = object.get(word);

			if (value == null)
				value = 1;
			else

				value = value + 1;
			object.add(word, value);
		}

		System.out.println(object);
	}
}

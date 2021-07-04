package com.bridgelabz.HashTable;

public class HashTable {
    public static void main(String[] args) {
        LinkedList<String, Integer> hashImpl = new LinkedList();
        String message = "Paranoids are not paranoid because they are paranoid but " +
                "because they keep putting themselves deliberately into paranoid avoidable situations";

        String[] messageArray = message.toLowerCase().split(" ");

        for(String word: messageArray) {
            Integer value =  hashImpl.get(word);
            if( value == null)
                value = 1;
            else
                value = value + 1;
            hashImpl.add(word , value);
        }
        System.out.println(hashImpl);

        hashImpl.remove("avoidable");

        System.out.println(hashImpl);
    }
}

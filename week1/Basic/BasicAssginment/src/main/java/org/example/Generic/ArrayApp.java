package org.example.Generic;

public class ArrayApp {
    public static void main(String[] args) {
        arrayGeneric<Integer> integerStack = new arrayGeneric<Integer>(Integer.class, 10); //제네릭 Stack<E>를 특정 타입인 Integer 타입으로 구체화함.
        integerStack.add(new Integer("5"));
        integerStack.add(new Integer("7"));
        System.out.println("integerStack에서 pop한 원소 = " + integerStack.pop());
        integerStack.add(new Integer("10"));
        System.out.println("integerStack에서 pop한 원소 = " + integerStack.pop());

        arrayGeneric<String> stringStack = new arrayGeneric<String>(String.class, 5); //제네릭 Stack<E>를 특정 타입인 String 타입으로 구체화함.
        stringStack.add(new String("코슐랭"));
        stringStack.add(new String("가이드"));
        stringStack.add(new String("우리가 짱"));
        System.out.println("stringStack에서 pop한 원소 = " + stringStack.pop());
    }
}

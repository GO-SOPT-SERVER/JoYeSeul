package org.example.Polymorphism.UsingAbstract;

public class CalculatorApp {
    public static void main(String[] args) {
        GoodCalc calc = new GoodCalc();
        System.out.println("2 + 3 = " + calc.add(2,3));
        System.out.println("150 - 29 = " + calc.add(150,29));
        System.out.println("[2,3,4,5] 배열의 평균 = " + calc.average(new int[] {2,3,4,5}));
    }
}

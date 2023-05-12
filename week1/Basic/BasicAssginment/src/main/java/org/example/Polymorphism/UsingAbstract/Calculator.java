package org.example.Polymorphism.UsingAbstract;

public abstract class Calculator {
    /**
     * 추상메서드: 선언은 되어 있지만 코드가 구현되어 있지 않은, 껍데기만 있는 메소드이다.
     * 추상클래스: 클래스를 설계도에 비유한다면 추상 클래스는 미완성 설계도라고 할 수 있다.
     * 미완성이라는 것은 멤버의 개수에 관계 없이, 단지 미완성 메서드(추상메서드)를 포함하는 클래스라는 의미이다.
     * 따라서 추상클래스는 상속을 통해서 자손클래스에 의해서만 완성될 수 있다.
     */
    public abstract int add(int a, int b);
    public abstract int subtract(int a, int b);
    public abstract double average(int[] a);
}

package org.example.Polymorphism.UsingInterface;

public interface PhonInterface {
    /**
     * 인터페이스: 구현된 것은 아무것도 없고 밑그림만 그려져 있는 기본 설계도
     * 추상 메소드와 상수로만 이루어져있고, 구현된 코드가 없다.
     * 따라서 인터페이스는 구현체를 꼭 만들어주어야 한다.
     * 그 구현체에서 인터페이스에 선언한 추상 메소드들을 모두 오버라이딩 해주면 된다.
     */
    int TIMEOUT = 10000;
    void sendCall();
    void receiveCall();
    default void printLogo() { //* Java8 부터는 default 메소드도 가능, 접근 지정은 public
        System.out.println("*** phone ***");
    }
}

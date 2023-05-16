package org.example.Polymorphism.UsingInterface;

//클래스 상속(PDA)과 다중 인터페이스 구현(PhoneInterface, MP3Interface) 가능
public class SamsungPhone extends PDA implements PhonInterface, MP3Interface {
    //PhoneInterface에 모든 추상 메소드 구현 해주어야 함
    @Override
    public void sendCall() {
        System.out.println("띠리리리리링~");
    }

    @Override
    public void receiveCall() {
        System.out.println("전화가 왔습니다.");
    }

    //* 메소드 추가도 가능하다.
    public void flash() {
        System.out.println("전화기에 불이 켜졌습니다.");
    }

    @Override
    public void play() {
        System.out.println("음악을 재생합니다.");
    }

    @Override
    public void stop() {
        System.out.println("음악을 중단합니다.");
    }
}

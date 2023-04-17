package org.example.Polymorphism.UsingInterface;

public interface MobilePhoneInterface extends PhonInterface{ //인터페이스도 상속 가능하다.
    void sendSMS();
    void receiveSMS();
}

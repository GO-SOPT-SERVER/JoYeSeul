package org.example.Polymorphism.UsingInterface;

public class PhoneApp {
    public static void main(String[] args) {
        SamsungPhone phone = new SamsungPhone();
        phone.printLogo();
        phone.sendCall();
        phone.play();
        phone.stop();
        System.out.println("10 + 8 = " + phone.calculation(10,8));
    }
}

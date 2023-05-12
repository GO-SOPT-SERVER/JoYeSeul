package org.example.ClaasAndInstance;

public class TVApp {
    public static void main(String[] args) {
        //*클래스와 인스턴스
        TV tv1 = new TV(); //* 인스턴스 생성
        TV tv2 = new TV(120, "SAMSUNG", 150000);
        tv2.subChannel();
        tv2.setChannel(11);
        tv2.addChannel();
    }
}

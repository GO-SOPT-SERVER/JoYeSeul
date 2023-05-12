package org.example.ClaasAndInstance;

public class TV {
    /**
     * 멤버 변수
     */
    private int size;
    private String manufacturer;
    private int price;
    private int channel = 0;
    final int MAX_CHANNEL = 100; //* final 키워드로 상수 변수 선언 가능
    final int MIN_CHANNEL = 0;


    /**
     * 기본 생성자
     * 생성자가 하나라도 존재하는 클래스에는 컴파일러가 기본 생성자를 삽입해주지 않기 때문에 정의 해주어야 한다.
     */
    public TV() {
        size = 32;
        manufacturer = "LG";
        price = 30000;
        System.out.println(size + "인치 " + manufacturer + " 제품 가격은 " + price + "입니다.");
    }

    public TV(int size, String manufacturer) {
        this.size = size; //* this는 현재 실행하고 있는 객체 레퍼런스
        this.manufacturer = manufacturer;
    }

    public TV(int size, String manufacturer, int price) {
        this(size, manufacturer); //* this()는 다른 생성자 호출
        this.price = price;
        System.out.println(size + "인치 " + manufacturer + " 제품 가격은 " + price + "입니다.");
    }

    public void setChannel(int channel) {
        this.channel = channel;
        System.out.println(channel + "번 채널 시청중입니다.");
    }

    /**
     * 멤버 메소드
     */
    public void addChannel() {
        if (channel < MAX_CHANNEL) {
            this.channel++;
            System.out.println(channel + "번 채널 시청중입니다.");
        } else {
            System.out.println("현재가 최대 채널 번호입니다.");
        }
    }
    public void subChannel() {
        if (channel > MIN_CHANNEL) {
            this.channel--;
            System.out.println(channel + "번 채널 시청중입니다.");
        } else {
            System.out.println("현재가 최소 채널 번호입니다.");
        }
    }

}

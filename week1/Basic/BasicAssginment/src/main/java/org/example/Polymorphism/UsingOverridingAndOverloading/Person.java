package org.example.Polymorphism.UsingOverridingAndOverloading;

public class Person {
    /**
     * 캡슐화
     * 클래스의 속성과 행위를 하나의 캡슐로 만들어 데이터를 외부로부터 보호하는 것을 뜻한다.
     * 자바의 경우, 접근 제어자를 통해 구현할 수 있다.
     */
    private int weight; //* private: 오직 현재 클래스의 멤버들에게만 접근을 허용. Person 클래스만 접근 가능
    int age; //* default: 같은 패키지의 클래스는 접근 가능.
    protected int height; //* protected: 같은 패키지 가능, 다른 페키지에 있다면 상속받은 클래스만 접근 가능
    public String name; //* public: 내부, 외부 패키지 그냥 다 가능

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Person(int weight, int age, int height, String name) {
        this.weight = weight;
        this.age = age;
        this.height = height;
        this.name = name;
    }

    public void work() {
        System.out.println("사람이 일을 합니다");
    }


    public void intro() {
        System.out.println("제 이름은 " + name + "이고 나이는 "+ age + "살 입니다.");
    }
}

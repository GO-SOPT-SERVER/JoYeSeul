package org.example.Polymorphism.UsingOverridingAndOverloading;

public class Developer extends Person {
    /**
     * 다형성: 하나의 객체나 메서드가 각각 여러가지의 다른 형태를 가질 수 있는 것
     * 전에 상속 설명할 때 만들었던 Person 클래스를 상속 받아서 오버로딩과 오버라이딩을 통한 타형성을 설명.
     */

    private String job;
    private String company;

    public Developer(int weight, int age, int height, String name, String job, String company) {
        super(weight, age, height, name);
        this.job = job;
        this.company = company;
    }


    /**
     * 오버라이딩: 부모 클래스의 동작을 재정의 하는 것
     * 현재 Person 클래스에서 work는 단순히 사람이 일을 하는 것을 뜻하지만
     * 이 work를 오버라이딩 하여서 Developer 만의 내용으로 새로 구현해서 다형성을 실현해보겠다.
     */
    @Override
    public void work() {
        System.out.println("개발자가 일을 합니다.");
    }

    /**
     * 오버로딩: 같은 이름의 메서드가 다른 타입으로 동작하는 것
     * 이 오버로딩의 특징은 다음과 같다.
     * 1. 메서드 이름은 동일
     * 2. 리턴 타입은 같아도 되고, 달라도 된다.
     * 3. 파라미터의 개수가 달라야 하고, 만약 같은 경우 데이터 타입이 달라야한다.
     */
    public void introJob() {
        System.out.println("저는 현재 " + company + "에 재직 중입니다");
    }
    public void introJob(String job) {
        System.out.println("저는 현재 " + company + "에서 " + job + " 직무를 맡고 있습니다.");
    }
}

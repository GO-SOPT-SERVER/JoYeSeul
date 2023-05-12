package org.example.EncapsulationAndInheritance;

import org.example.ClaasAndInstance.TV;

public class PersonApp {
    public static void main(String[] args) {
        //* 상속
        Developer developer = new Developer(55, 25, 170, "코슐랭", "백엔드", "kakao");
        developer.intro(); //상속 받은 부모 클래스의 메소드 호출 가능

        //System.out.println(developer.weight); //에러. weight 변수는 private이기 때문에
        System.out.println("developer.weight = " + developer.getWeight()); //따라서 getter 함수를 이용해서 접근

        developer.introJob();
        developer.setJob("프론트엔드"); //job 변수 역시 private이므로 setter 함수를 이용해서 값을 수정
        developer.introJob();

    }
}

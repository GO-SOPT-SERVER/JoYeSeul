package org.example.Polymorphism.UsingOverridingAndOverloading;

public class PersonApp {

    public static void main(String[] args) {
        Developer dev = new Developer(55,25,180,"서팟최고",
                "백엔드", "솝트");

        dev.work(); //오버라이딩
        dev.introJob();
        dev.introJob("서버"); //오버로딩

    }

}

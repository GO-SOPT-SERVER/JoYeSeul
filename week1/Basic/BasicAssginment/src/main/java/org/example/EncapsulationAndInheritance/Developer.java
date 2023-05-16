package org.example.EncapsulationAndInheritance;

public class Developer extends Person{
    private String job;
    private String company;

    public Developer(int weight, int age, int height, String name, String job, String company) {
        super(weight, age, height, name); //* super()을 사용해서 부모 클래스 생성자 호출, 무조건 첫 줄에 와야함
        this.job = job;
        this.company = company;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void introJob() {
        System.out.println("저는 현재 " + company + "에서 " + job + " 직무를 맡고 있습니다.");
    }
}

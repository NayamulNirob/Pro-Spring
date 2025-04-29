package car.example.bean;

public class MyBean {

    private String massage;

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public void showMassage() {
        System.out.println(massage);
    }

    @Override
    public String toString() {
        return "MyBean{" +
                "massage='" + massage + '\'' +
                '}';
    }
}

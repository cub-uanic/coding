package cub.testapp;

public class JavaTestApp {
    public String getGreeting() {
        return "Hello from Java!";
    }

    public static void main(String[] args) {
        System.out.println(new JavaTestApp().getGreeting());
    }
}

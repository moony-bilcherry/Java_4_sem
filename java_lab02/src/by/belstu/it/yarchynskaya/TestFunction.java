package by.belstu.it.yarchynskaya;

public class TestFunction {
    public int test;

    public int getTest() {
        return test;
    }
    public void setTest(int test) {
        this.test = test;
    }

    public TestFunction() {
    }
    public TestFunction(int test) {
        this.test = test;
    }

    public String getValue() {
        it_speaks();
        return "Hello from 1st proj";
    }

    private void it_speaks() {
        System.out.println("i'll be extracted");
    }
}

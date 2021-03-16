package by.belstu.it.yarchynskaya;

/**
 * @author moony
 * @version 1.0.0.1
 * */
public class Main {
    /**
     * @return ничего потому что войд
     * @trows
     * @param args - аргументы
     * */
    public static void main(String[] args) {
        //TODO hey look ma
        System.out.println("Hiiii");

        for (int count = 0; count < 10; count++) {
            System.out.println("the num is: " + count);
        }

        TestFunction obj = new TestFunction();

        String elem = "hey";

        WrapperString ws1 = new WrapperString(elem);
        ws1.replace();

        WrapperString ws2 = new WrapperString(elem) {
            @Override
            public void replace() {
                System.out.println("метод replace от анона");
                delete();
            }
            public void delete() {
                System.out.println("я удалятель");
            }
        };
        ws2.replace();
    }
}

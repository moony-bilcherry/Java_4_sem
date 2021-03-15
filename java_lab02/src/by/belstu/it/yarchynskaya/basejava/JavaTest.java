package by.belstu.it.yarchynskaya.basejava;

import java.util.Random;

import static java.lang.Math.*;

public class JavaTest {
    static int s_int;                           // для 3b

    public static final double PI = 3.14;       // для 3c
    public final int your_value = 295;

    public static void main(String[] args) {
        EX_3b();
        EX_3c();
        EX_3d();

    }

    private static void EX_3d() {
        System.out.println("\t\tEX 3d");
        System.out.println("Значение Math.PI: " + Math.PI);
        System.out.println("Значение Math.E: " + Math.E);
        System.out.println("Округленное Math.PI: " + Math.round(Math.PI));
        System.out.println("Округленное Math.E: " + Math.round(Math.E));
        System.out.println("Минимальное из PI и E: " + Math.min(Math.PI, Math.E));
        System.out.println("Случайное число из диапазона [0,1): ");
        double start = 0.0;
        double end = 1.0;
        double random = new Random().nextDouble();
        double result = start + (random * (end - start));
        System.out.println(result);
    }

    private static void EX_3c() {
        System.out.println("\t\tEX 3c");
        System.out.println("Разница между финальной переменной и константой в том что инициализацию final можно отложить");
        final int check_final;
        // ошибка, т.к. переменная не финализирована
        // System.out.println(check_final);
        check_final = 37;            //финализация
        System.out.println("Константа = public static final переменная");
        System.out.println("Статическую final можно вызвать без объявления экземпляра класса: " + JavaTest.PI);
        System.out.println();
    }

    private static void EX_3b() {
        char v_char = 'F';
        int v_int = 139;
        short v_short = 27;
        byte v_byte = 78;
        long v_long = 346674L;
        boolean v_boolean = true;
        String v_string = "!woof!";
        double v_double = 386.25;

        System.out.println("\t\tEX 3b");

        System.out.println("String + int: " + (v_string + v_int));
        System.out.println("String + char: " + (v_string + v_char));
        System.out.println("String + double: " + (v_string + v_double));

        byte v_byte_sum = (byte) (v_byte + v_int);
        System.out.println("byte + int: " + v_byte_sum);
        int v_int_sum = (int) (v_double + v_long);
        System.out.println("double + long: " + v_int_sum);
        long v_long_sum = (long) v_int + 2147483647;
        System.out.println("int + 2147483647: " + v_long_sum);
        System.out.println("static int (defined outside the method): " + s_int);

        boolean v_boolean_and = v_boolean && !v_boolean;
        System.out.println("boolean(true) && boolean(false): " + v_boolean_and);
        boolean v_boolean_or = v_boolean ^ !v_boolean;
        System.out.println("boolean(true) ^ boolean(false): " + v_boolean_or);
        // ошибка: нельзя складывать булевые значения
        // boolean v_boolean_sum = v_boolean + !v_boolean;

        long v_mystery1 = 9223372036854775807L;
        long v_mystery2 = 0x7fff_ffff_ffffL;

        char v_char_01 = 'a', v_char_02 = '\u0061', v_char_03 = 97;
        System.out.println("'a' + \u0061 + 97 = " + v_char_01 + v_char_02 + v_char_03);

        System.out.println("3.45 % 2.4 = " + (3.45 % 2.4));
        System.out.println("1.0 / 0.0 = " + (1.0 / 0.0));
        System.out.println("0.0 / 0.0 = " + (0.0 / 0.0));
        System.out.println("log(-345) = " + Math.log(-345));
        System.out.println("Float.intBitsToFloat(0x7F800000) = " + Float.intBitsToFloat(0x7F800000));
        System.out.println("Float.intBitsToFloat(0xFF800000) = " + Float.intBitsToFloat(0xFF800000));
        System.out.println("Целые константы можно записывать в СС: 2, 10, 16\n");
    }
}

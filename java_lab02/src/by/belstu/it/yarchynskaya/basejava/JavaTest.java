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
        EX_3e();
        EX_3f();
        EX_3g();
    }

    private static void EX_3g() {
        System.out.println("\t\tEX 3g");
        char[][] c1;
        char[] c2[];
        char c3[][];

        int zero_arr[] = new int [0];
        // исключение: выход за пределы
        //System.out.println(zero_arr[5]);

        // c1
        c1 = new char[3][];
        c1[0] = new char[0];
        c1[1] = new char[1];
        c1[2] = new char[2];
        System.out.println("длина массива: " + c1.length);
        System.out.println("длина строки 0: " + c1[0].length);
        System.out.println("длина строки 1: " + c1[1].length);
        System.out.println("длина строки 2: " + c1[2].length);

        c2 = new char[][] {{'1','2','3'}, {'4','5','6'}, {'7','8','9'}};
        c3 = new char[][] {{'1','2','3'}, {'4','5','6'}, {'7','8','9'}};
        boolean comRez = c2 == c3;
        System.out.println(comRez);
        c2 = c3;
        System.out.println(c2 == c3);
        for (char[] inner_arr: c2) {
            for (char cell: inner_arr) {
                System.out.println(cell);
            }
        }
    }

    private static void EX_3f() {
        System.out.println("\t\tEX 3f");
        String s34 = "2345";

        // преобразование в инт:
        System.out.println("Integer.valueOf(s34): " + (Integer.valueOf(s34)));
        System.out.println("new Integer(s34): " + (new Integer(s34)));
        System.out.println("Integer.parseInt(s34): " + (Integer.parseInt(s34)));

        // перевод строки в массив байтов и обратно из массива байтов в строку
        byte[] str_arr = s34.getBytes();
        System.out.println("массив байтов из строки: " + str_arr);

        String new_s34 = new String(str_arr);
        System.out.println("из байтов в строку: " + new_s34);

        // строка в логический тип 2мя способами
        System.out.println("1: " + Boolean.valueOf(s34));
        System.out.println("2: " + Boolean.getBoolean(s34));
        System.out.println("3: " + Boolean.parseBoolean(s34));

        // сравнения
        String str1 = "meow";
        String str2 = "meow";
        System.out.println("== : " + (str1 == str2));
        System.out.println("equals: " + (str1.equals(str2)));
        System.out.println("compareTo: " + (str1.compareTo(str2)));
        str2 = null;
        System.out.println("== : " + (str1 == str2));
        System.out.println("equals: " + (str1.equals(str2)));
        // исключение
        //System.out.println("compareTo: " + (str1.compareTo(str2)));

        // функции split, contains, hashCode, indexOf, length, replace
        String my_str = "i'm out of my head";
        System.out.println("оригинал строки: " + my_str);
        String[] my_split = my_str.split(" ");
        for (String a : my_split)
            System.out.println(a);
        System.out.println("hashCode: " + my_str.hashCode());
        System.out.println("indexOf: " + my_str.indexOf("of"));     // индекс первого символа подстроки в строке
        System.out.println("length: " + my_str.length());
        System.out.println("replace: " + my_str.replace("head", "mind"));
        System.out.println();
    }

    private static void EX_3e() {
        System.out.println("\t\tEX 3e");
        Boolean o_bool = new Boolean(true);
        Character o_char = new Character('Q');
        Integer o_int = new Integer(391);
        Byte o_byte = new Byte((byte) 56);
        Short o_short = new Short((short) 268);
        Long o_long = new Long(7453432462L);
        Double o_double = new Double(543.2);

        // >>>, >>, ~, &, *, -, +
        System.out.println("\tОператоры:");
        System.out.println("395 >>> 1 (беззнаковый сдвиг): " + (o_int >>> 1));
        System.out.println("-10 >>> 1 (беззнаковый сдвиг): " + (-10 >>> 1));
        System.out.println("395 >> 1 (знаковый сдвиг): " + (o_int >> 1));
        System.out.println("-10 >> 1 (знаковый сдвиг): " + (-10 >> 1));
        System.out.println("~125 (не): " + (~(125)));
        System.out.println("127 & 11 = " + (127 & 11));
        System.out.println("127 | 11 = " + (127 | 11));
        System.out.println("127 ^ 11 = " + (127 ^ 11));
        System.out.println("true && true = " + (o_bool && true));
        System.out.println("true && false = " + (o_bool && !o_bool));
        System.out.println("true || true = " + (o_bool || !o_bool));

        // MIN_VALUE и MAX_VALUE для Long и Double
        System.out.println("\tLong, Double:");
        System.out.println("Long.MAX_VALUE: " + (Long.MAX_VALUE));
        System.out.println("Long.MIN_VALUE: " + (Long.MIN_VALUE));

        System.out.println("o_double.isNaN(): " + (o_double.isNaN()));      // isNaN() только у Float и Double
        System.out.println("Double.MAX_VALUE: " + (Double.MAX_VALUE));
        System.out.println("Double.MIN_VALUE: " + (Double.MIN_VALUE));

        // упаковка и распаковка для Integer и Byte
        Integer boxed_int = 19;              // автоупаковка
        int unbox_int = 287;
        unbox_int = new Integer(12);    // распаковка

        Byte boxed_byte = 16;
        byte unbox_byte = 32;
        unbox_byte = new Byte((byte)53);

        //  для Integer методы : parseInt ; toHexString ; compare ; toString ; bitCount ; isNaN ...
        System.out.println("\tInteger:");
        System.out.println("ParseInt('170'): " + (Integer.parseInt("170")));
        System.out.println("ParseInt('170', 16): " + (Integer.parseInt("170",16)));

        System.out.println("toString(523): " + (Integer.toString(523)));
        // число -> строка с числом в 16й сс
        System.out.println("toHexString(742): " + (Integer.toHexString(742)));

        System.out.println("compare(10, 17): " + (Integer.compare(10,17)));
        System.out.println("compare(17, 17): " + (Integer.compare(17,17)));
        System.out.println("compare(17, 10): " + (Integer.compare(17,10)));
        System.out.println("o_int.compareTo(17): " + (o_int.compareTo(17)));

        System.out.println("bitCount(127): " + (Integer.bitCount(127)));        // кол-во 1 битов числа в 2й сс
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
        System.out.println();
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

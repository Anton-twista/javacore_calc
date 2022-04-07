import java.io.IOException;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {

        Calculator calc = Calculator.instance.get();

        int a = calc.plus.apply(1, 2);
        int b = calc.minus.apply(1, 1);
        int c = calc.divide.apply(a, b);

        calc.println.accept(c);
    }
}
//        Exception in thread "main" java.lang.ArithmeticException: / by zero
//        at Calculator.lambda$new$3(Calculator.java:9)
//        at Main.main(Main.java:9)

//          Причина возникновения:
//        int a = calc.plus.apply(1, 2);  a = 1 + 2 = 3;
//        int b = calc.minus.apply(1,1); b = 1 - 1 = 0;
//        int c = calc.divide.apply(a, b);  с = 3 / 0; ошибка, деление на ноль!!!

//        ошибка заключается в том, что на ноль делить нельзя,
//        а мы как раз это и пытаемся сделать,
//        необходимо поймать и обработать эту ошибку и сообщить об этом пользователю
//        либо через тернарный оператор напримере abs.
//
//        UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;
//        BinaryOperator<Integer> divide = (x, y) -> y == 0 ? y : x / y;
//
//        try {
//            c = calc.divide.apply(a, b);
//
//        } catch (ArithmeticException e){
//            System.out.println("Вы пытаетесь делить на ноль:     " + e);
//        }
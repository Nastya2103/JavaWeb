package lesson4;

import lesson4.MyException;
import lesson4.STriangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class STriangleTest {
    public static Logger logger = LoggerFactory.getLogger(STriangleTest.class);

    @Test
    void testCalcTriangle() throws MyException {
        STriangle triangle = new STriangle();
        Assertions.assertEquals(22.24859546128699, triangle.triangleArea(8, 8, 6));
        logger.info("Позитивный тест: Сравнение фактического результата с ожидаемым результатом.");
    }

    @Test
    void testNegativeValue() throws MyException {
        STriangle triangle = new STriangle();
        Assertions.assertThrows(MyException.class, () -> triangle.triangleArea(15, -33, 20));
        logger.info("Негативный тест: Проверка при введении отрицательного значения одной из сторон.");
    }

    @Test
    void testZeroValue() throws MyException {
        STriangle triangle = new STriangle();
        Assertions.assertThrows(MyException.class, () -> triangle.triangleArea(5, 12, 0));
        logger.info("Негативный тест: Проверка при введении нулевого значения одной из сторон.");
    }

    @Test
    void testSumTwoSides() throws MyException {
        STriangle triangle = new STriangle();
        Assertions.assertThrows(MyException.class, () -> triangle.triangleArea(5, 60, 15));
        logger.info("Негативный тест: Проверка при введении значения одной из сторон, которое больше либо равно сумме двух других сторон.");
    }
}

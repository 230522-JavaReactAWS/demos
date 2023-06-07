import com.revature.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private final Calculator calculator= new Calculator();

    // Now to write a test we simply need a new method and to denote it with the @Test annotation
    @Test
    public void AdditionPositiveTest1(){
        // Now that we're inside our test we want to start using asserts to test our methods in Calculator

        // In a perfect world 2 + 2 = 4
        Assertions.assertEquals(4, calculator.add(2,2));
    }

    @Test
    public void AdditionPositiveTest2(){
        // 14 + 28 = 42
        Assertions.assertEquals(42, calculator.add(14, 28));
    }

    // Negative testing denotes when two things should NOT be equal

    @Test
    public void AdditionNegativeTest(){
        // 34 + 16 != 51
        Assertions.assertNotEquals(51, calculator.add(16,34));
    }

    // Now it's time for some TDD
    // Let's write some tests for divide before we implement it
    @Test
    public void DivisionTestPositive(){
        // 12/ 4 == 3
        Assertions.assertEquals(3, calculator.divide(12, 4));
    }

    @Test
    public void DivisionTestDecimalValue(){
        // 1/4 == 0.25
        Assertions.assertEquals(.25, calculator.divide(1, 4));
    }

    @Test
    public void DivisionTestNegativeIntegers(){
        // 51/17 != 2
        Assertions.assertNotEquals(2, calculator.divide(51, 17));
    }

    // We'll add more tests in a minute
    // We need to consider all our edge cases when writing tests
    // So we need to know what happens when we divide by zero\
    @Test
    public void DivisionByZerotest(){
        Assertions.assertThrows(ArithmeticException.class, () -> calculator.divide(1, 0));
    }

}

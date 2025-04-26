package service;

import model.Calculator;
import org.example.repo.IDevisionRepo;
import org.example.service.DevisionService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParameterizedDevisionServiceTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Pesho", 10, 2, "Hello Pesho devision(:) of 10.0 and 2.0 is(=) 5.0"},
                {"Ivan", 5, 0, "Y cannot be zero"},
                {"Iva", 0, 5, "X cannot be zero"},
                {"Yoana", -10, -2, "Hello Yoana devision(:) of -10.0 and -2.0 is(=) 5.0"},
                {"Rado", -10, 2, "Hello Rado devision(:) of -10.0 and 2.0 is(=) -5.0"},
                {"Sasha", 5, Double.NaN, "Y cannot be NaN"},
                {"", 10, 5, "Invalid name"}
        });
    }

    @Parameterized.Parameter(0)
    public String name;
    @Parameterized.Parameter(1)
    public double x;
    @Parameterized.Parameter(2)
    public double y;
    @Parameterized.Parameter(3)
    public String expectedMessage;

    private DevisionService devisionService = new DevisionService(null) ;

    @Test
    public void testDivision() {
        // Act
        String result = devisionService.result(name, x, y);

        // Assert
        assertEquals(expectedMessage, result);
    }
}

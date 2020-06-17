package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Junit5DemoTest {

    @Test
    void assertion() {
        assertAll("demo assertion",
                () -> {
                    assertEquals(2, 2);
                },
                () -> assertEquals(1, 1),
                () -> assertEquals(3, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("getString")
    public void parameterizedTest(String data){
        Assertions.assertTrue(data.length() > 3);
    }

    public static Stream<String> getString(){
        return Stream.of("1234", "1211111", "String Demo");
    }
}

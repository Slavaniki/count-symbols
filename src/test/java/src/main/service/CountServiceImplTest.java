package src.main.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import src.main.exception.ValidationException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class CountServiceImplTest {

    @InjectMocks
    private CountServiceImpl countServiceImpl;

    private static final String INPUT_STR = "aaaabbcccddde";

    @Test
    public void getCountOfSymbols_whenInputStrIsNull_shouldThrowValidationException() {
        assertThrows(ValidationException.class, () -> countServiceImpl.getCountOfSymbols(null));
    }

    @Test
    public void getCountOfSymbols_whenInputStrIsBlank_shouldThrowValidationException() {
        assertThrows(ValidationException.class, () -> countServiceImpl.getCountOfSymbols(""));
    }

    @Test
    public void getCountOfSymbols_whenInputStrIsNotNullAndNotBlank_shouldReturnCountOfSymbols() {
        String result = countServiceImpl.getCountOfSymbols(INPUT_STR);
        assertEquals(
                "\"a\": 4, " +
                "\"c\": 3, " +
                "\"d\": 3, " +
                "\"b\": 2, " +
                "\"e\": 1"
                , result);
        String result2 = countServiceImpl.getCountOfSymbols(INPUT_STR);
        assertEquals(
        "\"a\": 4, " +
                "\"c\": 3, " +
                "\"d\": 3, " +
                "\"b\": 2, " +
                "\"e\": 1"
                , result2);
    }
}
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class mainTest {

    @Test
    void incorrectInputShouldReturnMinusOne(){

        FindMaxFreeUrinals fmfu = new FindMaxFreeUrinals();
        assertThrows(FileNotFoundException.class,
                () -> {
            fmfu.openFile("input1.dat");
                });
    }
}

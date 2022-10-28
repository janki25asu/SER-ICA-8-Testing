import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.IOException;

public class mainTest {

    //File doesn't exist
    @Test
    void FileNotFoundExceptionTest(){

        FindMaxFreeUrinals fmfu = new FindMaxFreeUrinals();
        assertThrows(FileNotFoundException.class,
                () -> {
            fmfu.openFile("input1.dat");
                });
    }

    //IOException
    @Test
    void IOExceptionTest(){

        FindMaxFreeUrinals fmfu = new FindMaxFreeUrinals();
        assertThrows(IOException.class,
                () -> {
                    fmfu.openFile("input1.dat");
                });
    }

}

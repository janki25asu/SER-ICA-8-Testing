import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.junit.Assert;
import static org.junit.jupiter.api.Assertions.*;

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


    //Read File Tests Complete
    @Test
    void ReadFileTest() throws IOException {

        FindMaxFreeUrinals fmfu = new FindMaxFreeUrinals();
        String[] expectedOutput = {"10001", "1001", "00000", "0000", "string", "abab", "010248", "78723"};
        String[] methodOutput = fmfu.openFile("input.dat");
        Assert.assertArrayEquals(expectedOutput, methodOutput);
    }


    //countUrinal tests
    @Test
    void countUrinalsTest() throws IOException {
        FindMaxFreeUrinals fmfu = new FindMaxFreeUrinals();
        String[] array = fmfu.openFile("input.dat");
        int[] methodop = fmfu.getCharArray(array);
        int[] expectedop = {1, 0, 3, 2, -1, -1, -1, -1};
        Assert.assertArrayEquals(expectedop, methodop);
    }

}

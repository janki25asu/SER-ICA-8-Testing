import java.io.IOException;


public class main {
    public static void main(String[] args) throws IOException {

        FindMaxFreeUrinals fmfu = new FindMaxFreeUrinals();

        String[] array = fmfu.openFile("C:\\Users\\Radhe Krishna\\Downloads\\SER-515-ICA-8-Testing\\input.txt");

        int[] result = fmfu.getCharArray(array);

        fmfu.writeOutputFile(result);

    }

}

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class FindMaxFreeUrinals {

    public String[] openFile(String path) throws IOException {

        List<String> listOfStrings
                = new ArrayList<String>();

        BufferedReader bf = new BufferedReader(
                new FileReader(path));

        String line = bf.readLine();

        while (line != null) {
            listOfStrings.add(line);
            line = bf.readLine();
        }

        bf.close();

        String[] array
                = listOfStrings.toArray(new String[0]);

        return array;
    }


    public int[] getCharArray(String[] strs){
        int[] result = new int[strs.length];
        for (int i=0; i < strs.length; i++) {
            char[] ch = new char[strs[i].length()];
            int j = 0;
            for (j = 0; j < strs[i].length(); j++) {
                ch[j] = strs[i].charAt(j);
            }
            result[i] = findMaxFreeUrinals(ch);
        }
        return result;
    }

    public int findMaxFreeUrinals(char[] ch){
        char[] passedparam = ch;

        boolean previousZero = true;
        int maxFreeUrinals=0;

        for(int i=0;i<ch.length-1 ;i++){

            if((ch[i]!='0' && ch[i]!='1')){
                maxFreeUrinals=-1;
                break;
            }

            if(previousZero==true){
                if(ch[i]=='0' && ch[i+1]=='1'){
                    previousZero = true;
                }
                else if(ch[i]=='0' && ch[i+1]=='0'){
                    previousZero = false;
                    maxFreeUrinals+=1;
                }
                else if(ch[i]=='1' && ch[i+1]=='0'){
                    previousZero = false;
                }
                else if(ch[i]=='1' && ch[i+1]=='1'){
                    maxFreeUrinals = -1;
                    break;
                }
            }
            else if(!previousZero){
                if(ch[i]=='0' && ch[i+1]=='1'){
                    previousZero = true;
                }
                else if(ch[i]=='0' && ch[i+1]=='0'){
                    previousZero = true;
                }
                else if(ch[i]=='1'){
                    maxFreeUrinals = -1;
                    break;
                }
            }
        }

        int length = ch.length-1;
        if(previousZero){
            if(ch[length]=='0'){
                maxFreeUrinals+=1;
            }
        }
        else if(!previousZero){
            if(ch[length-1]=='1'){
                maxFreeUrinals = -1;
            }
        }

        return maxFreeUrinals;
    }


    public void writeOutputFile(int[] output){

        String strFilePath = "output.txt";

        try
        {
            FileWriter writer = new FileWriter(strFilePath);

            int len = output.length;
            for (int i = 0; i < len; i++) {
                writer.write(output[i] + "\n");
            }
            System.out.println("output.txt file successfully generated");
            writer.close();

        }
        catch (IOException e)
        {
            System.out.println("IOException : " + e);
        }
    }
}

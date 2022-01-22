package iostream.RW;

import java.io.*;

public class BufferedRWCopy {

    public static void main(String[] args) {
        String srcFilePath = "";
        String targetFilePath = "";

        // 注意 BufferedReader和BufferedWriter是按字符操作
        // 不要去操作二进制文件，可能会造成文件损坏。
        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            br = new BufferedReader(new FileReader(srcFilePath));
            bw = new BufferedWriter(new FileWriter(targetFilePath));

            String line;
            while ((line = br.readLine())!=null){
                bw.write(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br!=null){
                    br.close();
                }
                if(bw!=null){
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

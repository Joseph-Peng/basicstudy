package iostream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {

    public static void main(String[] args) {
        String srcFilePath = "D:\\tomcat70.zip";
        String targetFilePath = "F:\\tomcat70.zip";
        FileInputStream iStream = null;
        FileOutputStream oStream = null;

        try {
            iStream = new FileInputStream(srcFilePath);
            oStream = new FileOutputStream(targetFilePath);
            int readLen = 0;
            byte[] readData = new byte[1024];
            while ((readLen = iStream.read(readData))!=-1){
                oStream.write(readData,0,readLen);
            }
            System.out.println("拷贝成功。");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                if (iStream!=null){
                    iStream.close();
                }
                if (oStream!=null){
                    oStream.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}

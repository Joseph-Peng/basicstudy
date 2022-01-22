package iostream.RW;

import java.io.*;

public class BufferedStreamCopy {

    public static void main(String[] args) {
        String srcFilePath = "";
        String targetFilePath = "";

        // 可以操作二进制文件和文本文件
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            bis = new BufferedInputStream(new FileInputStream(srcFilePath));
            bos = new BufferedOutputStream(new FileOutputStream(targetFilePath));

            byte[] buff = new byte[1024];
            int readLen = 0;
            while ((readLen = bis.read(buff))!=-1){
                bos.write(buff,0,readLen);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bis!=null){
                    bis.close();
                }
                if(bos!=null){
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

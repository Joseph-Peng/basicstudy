package socket.demo1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8888);
        OutputStream os = socket.getOutputStream();
        InputStream is = socket.getInputStream();

        os.write(new String("hello server").getBytes());


        byte buffer[] = new byte[1024];
        int len = is.read(buffer);
        String content = new String(buffer, 0, len);
        System.out.println(content);
        is.close();
        os.close();
        socket.close();
    }
}

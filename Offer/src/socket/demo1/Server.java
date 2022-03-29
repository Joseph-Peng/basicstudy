package socket.demo1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        System.out.println("================= 服务端启动！=================");
        try {
            //1. 注册端口
            ServerSocket server = new ServerSocket(8888);

            //2. 调用accept方法，阻塞等待客户端的连接
            Socket socket = server.accept();
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            byte[] data = new byte[1024];
            int len = is.read(data);
            String content = new String(data,0,len);
            System.out.println(content);
            os.write(String.valueOf(len).getBytes());
            os.close();
            is.close();
            socket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

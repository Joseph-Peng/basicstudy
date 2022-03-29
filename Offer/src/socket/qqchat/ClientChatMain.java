package socket.qqchat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class ClientChatMain extends JFrame implements ActionListener {

    private JTextArea jta;

    private JScrollPane jsp;

    private JPanel jp;

    private JTextField jtf;

    private JButton jb;

    private BufferedWriter writer;

    public ClientChatMain(){
        jta = new JTextArea();
        jta.setEnabled(false);
        jsp = new JScrollPane(jta);
        jp = new JPanel();
        jtf = new JTextField(10);
        jb = new JButton("发送");
        jp.add(jtf);
        jp.add(jb);

        this.add(jsp, BorderLayout.CENTER);
        this.add(jp, BorderLayout.SOUTH);

        this.setTitle("客户端");
        this.setSize(300,300);
        this.setLocation(600,300);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);

        jb.addActionListener(this);

        try {
            Socket socket = new Socket("127.0.0.1",8888);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            String line = null;
            while ((line = reader.readLine())!=null){
                jta.append(line+System.lineSeparator());
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ClientChatMain();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = jtf.getText();
        text = "客户端："+text;
        jta.append(text + System.lineSeparator());
        try {
            writer.write(text);
            writer.newLine();
            writer.flush();
            jtf.setText("");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}

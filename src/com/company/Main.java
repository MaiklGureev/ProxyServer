package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here

        ServerSocket sersock = new ServerSocket(5000);
        System.out.println("Сервер запущен и ожидает...");

        //recv
        Socket sock = sersock.accept();
        InputStream istream = sock.getInputStream();
        DataInputStream dstream = new DataInputStream(istream);
        double a = dstream.readDouble();
        double b = dstream.readDouble();
        double res = a*b+100;
        System.out.println("Принял первое число "+a);
        System.out.println("Принял второе число "+b);
        System.out.println("Отправил ответ: "+res);

        //send
        OutputStream ostream = sock.getOutputStream();
        DataOutputStream dos = new DataOutputStream(ostream);
        dos.writeDouble(res);

        dstream .close();
        istream.close();
        //sock.close();
        sersock.close();
    }
}

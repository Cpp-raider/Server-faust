package ml.aerialline.serverfaust;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutionException;

public class SendThread extends Thread {

    boolean isRandomName;
    String name;
    InetSocketAddress host;
    int protocol;
    double delay;z

    public SendThread(boolean isRandomName, String name, String address, int port, int protocol, double delay) {
        this.isRandomName = isRandomName;
        this.name = name;
        host = new InetSocketAddress(address, port);
        this.protocol = protocol;
        this.delay = delay * 1000;

    }

    @Override
    public void run() {
        if (isRandomName) {
            name = Utility.randomString();

        }

    }
}
package ml.aerialline.serverfaust;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Logger;

public class Utility {
    private static final String a = "abcdefghijklmnopqrstuvwxyz";
    private static final String b = a.toUpperCase(Locale.ROOT);
    private static final String all = a + b + "123456789";

    public static String randomString() {

        Random r = new Random();

        int limitLen = r.nextInt(16);
        StringBuilder sb = new StringBuilder(limitLen);
        for(int i = 0; i < limitLen; i++)
            sb.append(all.charAt(r.nextInt(all.length())));
        return sb.toString();

    }

    public static String scaner(Logger logger, String message) {
        Scanner scanner = new Scanner(System.in);
        logger.info(message);
        return scanner.nextLine();

    }
    
}

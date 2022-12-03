package ml.aerialline.serverfaust;

import java.util.logging.Logger;

public class ServerFaust {

    static String name/* = "!random"*/;
    static String address/* = "localhost"*/;
    static int port/* = 25565*/;
    static int protocol/* = 760*/;
    static double delay/* = 0.2*/;
    static int threads/* = 8*/;


    public static void main(String[] args) {
        Logger logger = Logger.getLogger( ClassLoader.class.getName() );

        name = Utility.scaner(logger, "1 Please enter player name(random = !random) >");
        address = Utility.scaner(logger, "2 Please enter target address >");
        port = Integer.parseInt(Utility.scaner(logger, "3 PLease enter target port >"));
        delay = Double.parseDouble(Utility.scaner(logger, "4 Please enter delay(sce) >"));
        protocol = Integer.parseInt(Utility.scaner(logger, "5 Please enter protocol version(latest is 760) >"));
        threads = Integer.parseInt(Utility.scaner(logger, "6 Please enter threads number >"));

        boolean isRandomName = name.equals("!random");
        logger.info("stating...");
        logger.info(threads + " threads." + delay + " delay.");
        for (int i=0;i<=threads;i++) {
            new SendThread(isRandomName, name, address, port, protocol, delay).start();
            try {
                Thread.sleep((long) (delay * 1000 / threads));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        logger.info("stop command is ctrl + c");


    }

}

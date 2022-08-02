import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static double fibonacci (int count) {
        double f_0 = 0;
        double f_1 = 1;
        double result = 0;
        for (int n = 2; n <= count; n++) {
            result = f_0 + f_1;
            f_0 = f_1;
            f_1 = result;
        }
        if (count == 0) {
            result = 0;
        } else if (count == 1) {
            result = 1;
        }
        return result;

    }
    public static void main(String[] args) throws IOException {
        int port = 8079;
        try (ServerSocket servSocket = new ServerSocket(port);) {
            while (true) {
                try (Socket clienSocket = servSocket.accept();
                     PrintWriter out = new PrintWriter(clienSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader
                             (clienSocket.getInputStream()))) {
                    System.out.printf("Подключился клиент. Порт: " + clienSocket.getPort());
                    final String count = in.readLine();
                    out.println(fibonacci(Integer.parseInt(count)));



                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

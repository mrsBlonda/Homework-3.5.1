import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int port = 8079;
        String host = "127.0.0.1";
        try (Socket socket = new Socket(host, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Scanner scanner = new Scanner(System.in)) {
            String msg;
            while (true) {
                System.out.println("Введите номер члена ряда Фибоначчи: ");
                msg = scanner.nextLine();
                if (msg.equals("end")) {
                    break;
                }
                out.println(msg);
                System.out.println("Число Фибоначчи равно: " + in.readLine());



            }





        } catch (IOException ex) {
            ex.printStackTrace();
        }



    }
}

package networkp2;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String argv[]) throws Exception
    {
        String clientSentence;
        String line;
        String message;


        ServerSocket establishSocket = new ServerSocket(6789);

        while(true) {

            Socket connectionSocket = establishSocket.accept();

            BufferedReader inFromClient =
                    new BufferedReader(new
                            InputStreamReader(connectionSocket.getInputStream()));

            DataOutputStream outToClient =
                    new DataOutputStream(connectionSocket.getOutputStream());


            clientSentence = inFromClient.readLine();
            if(!clientSentence.equals("CONNECT")){
                connectionSocket.close();
                System.out.println("Error: " + clientSentence);
                return;
            }
            
            System.out.println("Received Connection.");

            while((line = inFromClient.readLine()) != null){
                System.out.println("Client: " + line);
                System.out.print("Server: ");
                BufferedReader inFromUser =
                        new BufferedReader(new InputStreamReader(System.in));
                while((message = inFromUser.readLine()) != null){
                    outToClient.writeBytes(message + '\n');
                    break;
                }

            }

        }
    }

}

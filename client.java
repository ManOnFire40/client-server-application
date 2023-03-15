package networkp2;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class client {

	public static void main(String argv[] ) throws Exception
{//starting of method
		
		
		String sentence="";
		String modifedSentence;
		String serverSentence;
		Scanner input=new Scanner(System.in);
		
		
		while(! sentence.equals("CONNECT")) 
		{//starting of first loop
			sentence=input.nextLine();
		}//end of first loop
		
		
		Socket cSocket=new Socket("localhost",1337);
        DataOutputStream outToServer=new DataOutputStream(cSocket.getOutputStream());

        
while(true) {//starting of second loop
BufferedReader inFromuser=new BufferedReader(new InputStreamReader(System.in));
sentence=inFromuser.readLine();
outToServer.writeBytes(sentence+'\n');

BufferedReader inFromServer=new BufferedReader(new InputStreamReader(cSocket.getInputStream()));
serverSentence=inFromServer.readLine();
System.out.println(serverSentence);

if(sentence.equals("Exit")) 
{//start of condition
break;	
}//end of condition
cSocket.close();

}//end of second loop		
		

}//end of method


}

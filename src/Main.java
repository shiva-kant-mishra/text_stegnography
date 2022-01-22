
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import java.util.*;
import java.lang.String;
import javax.swing.JFrame;
class Encrypt{
	public void encode(String str){
		char[] arr=str.toCharArray();
		try{
		String path=(System.getProperty("user.home"));
		File file = new File("encrypted.txt");
		if (!file.exists()) {
				file.createNewFile();
			}
 
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
		for(int i=0;i<str.length();i++)
		{
		for(int j=1;j<=arr[i];j++)
			{
				bw.write(" ");
			}
				bw.newLine();
		}
		bw.close();
		System.out.println("Done");
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
class Decrypt{
	public void decode(){
	BufferedReader br = null;
 
		try {
 
			String sCurrentLine;
			String path=(System.getProperty("user.home"));
			br = new BufferedReader(new FileReader("encrypted.txt"));
 			System.out.println("Decoded message is:");
			while ((sCurrentLine = br.readLine()) != null) {
				char temp=(char)(sCurrentLine.length());
				System.out.print(temp);
			
			}
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
 
	}

}
class Main{
	public static void main(String...skm){
		Gui g= new Gui();
		g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		g.setSize(300,220);
		g.setVisible(true);
		System.out.println("click on encode");
		
	}
}
class Gui extends JFrame{

	private JButton encode;
	private JButton decode;
	
	public Gui(){
		super("Stagnography");				//Title for popup window
		setLayout(new FlowLayout());		//Gives default layout
			
		Icon u=new ImageIcon(getClass().getResource("e1.png"));	
		Icon v=new ImageIcon(getClass().getResource("e2.png"));
		encode=new JButton("",u);		//set button name and style
		encode.setRolloverIcon(v);			//to change image on rollover
		add(encode);						//decode button
		
		Icon w=new ImageIcon(getClass().getResource("d1.png"));	
		Icon x=new ImageIcon(getClass().getResource("d2.png"));
		decode=new JButton("",w);		//set button name and style
		decode.setRolloverIcon(x);			//to change image on rollover
		add(decode);						//decode button
		
		HandlerClassencode handlerencode = new HandlerClassencode();
		HandlerClassdecode handlerdecode = new HandlerClassdecode();
		encode.addActionListener(handlerencode);
		decode.addActionListener(handlerdecode);
	}
	public class HandlerClassencode implements ActionListener{
		public void actionPerformed(ActionEvent event){
			String message=JOptionPane.showInputDialog("Enter message");
			Encrypt en=new Encrypt();
			en.encode(message);
			JOptionPane.showMessageDialog(null,String.format("Message Encoded",event.getActionCommand()));
		}
	}	
	public class HandlerClassdecode implements ActionListener{
		public void actionPerformed(ActionEvent event){
			Decrypt dc=new Decrypt();
			dc.decode();
			JOptionPane.showMessageDialog(null,String.format("Message Decoded",event.getActionCommand()));
		}
	}
	
	
}		
		
		 
			
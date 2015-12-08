import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by jagesh on 11/29/2015.
 */
public class GameApplication
{
    Socket socket;
    ServerSocket serverSocket;
    int port;
    String ipAddr;
    BufferedReader is;
    PrintWriter os;

    JFrame frame;
    JTable table;
    JPanel p1,p2;
    JButton btnNewgame;
    JTextField txtDifficultyLevel;
    JLabel lblDififculty;
    String[] level = {"Easy","Medium","Difficulty"};
    JComboBox cboLevel = new JComboBox(level);

    GameApplication(String client,String server,String ipaddress, int portaddress, boolean isserver)
    {
        if (isserver)
        {
            try
            {
                serverSocket = new ServerSocket(portaddress);
                socket = serverSocket.accept();
                is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                os = new PrintWriter(socket.getOutputStream());

            }
            catch (Exception e)
            {   System.out.println("Error1: " + e);   }

        }
        else
        {
            try
            {
                socket = new Socket(ipaddress,portaddress);
                os = new PrintWriter(socket.getOutputStream());
                is = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            }
            catch (Exception e)
            {   System.out.print("Error-2: " + e);}
        }

        while (true)
        {
            DrawJTable drawtbl = new DrawJTable();
            drawtbl.drawServerWindows();
            drawtbl.drawClientWindows();
            break;
            //Need to work here a lot again, previous code had lots of error don't forget (code has been removed)
//            try
//            {
//                System.out.println("abc");
//            }
//            catch (Exception e)
//            {
//                System.out.println(e);
//            }
        }
    }
}

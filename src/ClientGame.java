//import javax.swing.*;
//import javax.swing.table.AbstractTableModel;
//import javax.swing.table.TableModel;
//import java.awt.*;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.net.Socket;
//
///**
// * Created by jagesh on 11/29/2015.
// */
//public class ClientGame
//{
//    JFrame frame;
//    JPanel p1;
//    JTable table;
//
//    Socket clientSocket;
//    PrintWriter os;
//    BufferedReader is;
//
//    public ClientGame()
//    {
//
//    }
//
//    public ClientGame(String ipAddress,int port)
//    {
//        try
//        {
//            clientSocket = new Socket(ipAddress,port);
//            os = new PrintWriter(clientSocket.getOutputStream());
//            is = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//        }
//        catch (Exception e)
//        { System.out.println("Error joining: " + e);     }
//    }
//
//    public static void main(String[] args)
//    {
//        new ClientGame().run();
//    }
//
//    public void run()
//    {
//        frame = new JFrame("Client Joined");
//        frame.setSize(400,200);
//        frame.setLayout(new GridLayout(1,1));
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//
//        p1 = new JPanel();
//
//        TableModel dataModel = new AbstractTableModel() {
//            public int getColumnCount() { return 10; }
//            public int getRowCount() { return 10;}
//            public Object getValueAt(int row, int col) { return new Integer(row*col); }
//        };
//
//        table = new JTable(dataModel);
//         p1.add(table,BorderLayout.CENTER);
//
//        frame.add(p1);
//        frame.setVisible(true);
//    }
//}

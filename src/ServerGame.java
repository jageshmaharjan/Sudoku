//import javax.swing.*;
//import javax.swing.table.AbstractTableModel;
//import javax.swing.table.TableModel;
//import java.awt.*;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.net.ServerSocket;
//import java.net.Socket;
//
///**
// * Created by jagesh on 11/29/2015.
// */
//public class ServerGame
//{
//    ServerSocket socketServer;
//    Socket socket;
//    int port;
//    String ServerIP;
//    BufferedReader is;
//    PrintWriter os;
//    String line;
//
//    JFrame frame;
//    JTable table;
//    JPanel p1,p2;
//    JButton btnNewgame;
//    JTextField txtDifficultyLevel;
//    JLabel lblDififculty;
//
//    public ServerGame()
//    {
//
//    }
//
//    public ServerGame(int port, boolean isserver)
//    {
//        if (isserver)
//        {
//            try
//            {
//                socketServer = null;
//                socketServer = new ServerSocket(port);
//                socket = null;
//                socket = socketServer.accept();
//
//                is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//                os = new PrintWriter(socket.getOutputStream());
//            }
//            catch (Exception e)
//            {System.out.println("Error in Connecting: " + e);}
//        }
//
//        while (true)
//        {
//            try
//            {
//                line = is.readLine();
//
//            }
//            catch (Exception e)
//            {System.out.println("Error-2:" + e);}
//        }
//    }
//
//    public static void main(String[] args )
//    {
//        new ServerGame().run();
//    }
//
//    public void run()
//    {
//        frame = new JFrame("Server Playing");
//        frame.setSize(400,400);
//        frame.setLayout(new GridLayout(2,1));
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//
//        p1 = new JPanel(); // FlowLayot
//
//        lblDififculty = new JLabel("Level(1 hardest, 8 simplest): ");
//        txtDifficultyLevel = new JTextField(5);
//        btnNewgame = new JButton("New Game");
//        p1.add(lblDififculty);
//        p1.add(txtDifficultyLevel);
//        p1.add(btnNewgame);
//
//        p2 = new JPanel();
//
//        TableModel dataModel = new AbstractTableModel() {
//            public int getColumnCount() { return 10; }
//            public int getRowCount() { return 10;}
//            public Object getValueAt(int row, int col) { return new Integer(row*col); }
//        };
//
//        table = new JTable(dataModel);
//       // table.addColumn(new TableColumn(300,300));
//        p2.add(table,BorderLayout.CENTER);
//
//        frame.add(p1);
//        frame.add(p2);
//
//        frame.setVisible(true);
//    }
//}

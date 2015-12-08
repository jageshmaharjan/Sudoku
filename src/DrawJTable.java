import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

/**
 * Created by jagesh on 12/05/2015.
 */
public class DrawJTable implements ActionListener,TableModelListener
{
    JFrame frame;
    JTable table;
    JPanel p1,p2;
    JButton btnNewgame;
    JTextField txtDifficultyLevel;
    JLabel lblDififculty;
    String[] level = {"Easy","Medium","Difficulty"};
    JComboBox cboLevel = new JComboBox(level);


    public void drawServerWindows()
    {
        frame = new JFrame("Server Playing");
        frame.setSize(500,600);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        p1 = new JPanel();

        lblDififculty = new JLabel("Level(Easy, Medium, Difficult): ");
        txtDifficultyLevel = new JTextField(5);
        btnNewgame = new JButton("New Game");

        btnNewgame.addActionListener(this);

        p1.add(lblDififculty);
        p1.add(cboLevel);
        cboLevel.addActionListener(this);
        p1.add(btnNewgame);

        p2 = new JPanel();

        Object[] colname =  {0,0,0,0,0,0,0,0,0};
        Object[][] data = getData();

        DefaultTableModel model = new DefaultTableModel(data,colname);

        table = new JTable(model);
        table.setRowHeight(50);
        Enumeration<TableColumn> nosOfColumns = table.getColumnModel().getColumns();
        while (nosOfColumns.hasMoreElements())
        {

            TableColumn col = nosOfColumns.nextElement();
            col.setPreferredWidth(50);
        }

        table.getModel().addTableModelListener(this);

        p2.add(table,BorderLayout.CENTER);

        frame.add(p1,BorderLayout.NORTH);
        frame.add(p2,BorderLayout.CENTER);
        frame.setUndecorated(true);
        frame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void drawClientWindows()
    {
        frame = new JFrame("Client Joined");
        frame.setSize(600,500);
        frame.setLayout(new GridLayout(1,1));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        p1 = new JPanel();


        Object[] colname =  {0,0,0,0,0,0,0,0,0};
        Object[][] data = getData();

        DefaultTableModel model = new DefaultTableModel(data,colname);
        table = new JTable(model);

        table.setRowHeight(50);
        Enumeration<TableColumn> nosOfCol = table.getColumnModel().getColumns();
        while (nosOfCol.hasMoreElements())
        {
            TableColumn column = nosOfCol.nextElement();
            column.setPreferredWidth(50);
        }

        table.getModel().addTableModelListener(this);

        p1.add(table,BorderLayout.CENTER);
        frame.setUndecorated(true);
        frame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(p1);
        frame.pack(); // --12/05/2015 : 2:58
        frame.setVisible(true);
    }

    public Object[][] getData()
    {
        Object[][] datavalues = {
                {0,0,0,5,6,0,2,0,6},{0,0,0,5,6,0,2,0,6},{0,0,0,5,6,0,2,0,6},
                {0,0,0,5,6,0,2,0,5},{1,0,0,5,6,0,2,0,6},{0,0,0,5,6,0,8,0,6},
                {0,0,0,5,7,0,0,0,6},{0,0,0,5,7,0,0,0,0},{5,0,0,5,7,0,0,0,6}
        };
        return datavalues;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equals("New Game"))
        {
            if (cboLevel.getSelectedItem().toString().equals("Easy"))
            {
                frame.dispose();
                drawEasyClientWindows();
                drawEasyServerWindows();
            }
            else if (cboLevel.getSelectedItem().toString().equals("Medium"))
            {
                frame.dispose();
                drawMediumClientWindows();
                drawMediumServerWindows();
            }
            else if (cboLevel.getSelectedItem().toString().equals("Difficult"))
            {
                frame.dispose();
                drawDifficultyClientWindows();
                drawDifficultyServerWindows();
            }
        }
    }

    private void drawEasyClientWindows()
    {
        frame = new JFrame("Client Joined");
        frame.setSize(600,500);
        frame.setLayout(new GridLayout(1,1));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        p1 = new JPanel();

        Object[] colname =  {0,0,0,0,0,0,0,0,0};//{"c1", "c2", "c3", "c4", "c5", "c6", "c7", "c8", "c9"};
        Object[][] datavalues = {
                {0,0,0,5,6,0,2,0,6},{0,0,0,5,6,0,2,0,6},{0,0,0,5,6,0,2,0,6},
                {0,0,0,5,6,0,2,0,5},{1,0,0,5,6,0,2,0,6},{0,0,0,5,6,0,8,0,6},
                {0,0,0,5,7,0,0,0,6},{0,0,0,5,7,0,0,0,0},{5,0,0,5,7,0,0,0,6}
        };
        DefaultTableModel model = new DefaultTableModel(datavalues,colname);
        table = new JTable(model);

        table.setRowHeight(50);
        Enumeration<TableColumn> nosOfCol = table.getColumnModel().getColumns();
        while (nosOfCol.hasMoreElements())
        {
            TableColumn column = nosOfCol.nextElement();
            column.setPreferredWidth(50);
        }

        p1.add(table,BorderLayout.CENTER);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(p1);
        frame.setVisible(true);
    }
    private void drawEasyServerWindows()
    {
        frame = new JFrame("Server Playing");
        frame.setSize(500,600);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        p1 = new JPanel(); // FlowLayot

        lblDififculty = new JLabel("Level(Easy, Medium, Difficult): ");
        txtDifficultyLevel = new JTextField(5);
        btnNewgame = new JButton("New Game");

        btnNewgame.addActionListener(this);

        p1.add(lblDififculty);
        p1.add(cboLevel);
        cboLevel.addActionListener(this);
        p1.add(btnNewgame);

        p2 = new JPanel();

        Object[] colname =  {0,0,0,0,0,0,0,0,0};
        Object[][] datavalues = {
                {1,1,1,1,1,1,1,1,1,1},{0,0,0,5,6,0,2,0,6},{0,0,0,5,6,0,2,0,6},
                {0,0,0,5,6,0,2,0,5},{1,0,0,5,6,0,2,0,6},{0,0,0,5,6,0,8,0,6},
                {0,0,0,5,7,0,0,0,6},{2,2,2,2,2,2,2,2,2},{5,0,0,5,7,0,0,0,6}
        };

        DefaultTableModel model = new DefaultTableModel(datavalues,colname);

        table = new JTable(model);
        table.setRowHeight(50);
        Enumeration<TableColumn> nosOfColumns = table.getColumnModel().getColumns();
        while (nosOfColumns.hasMoreElements())
        {

            TableColumn col = nosOfColumns.nextElement();
            col.setPreferredWidth(50);
        }
        p2.add(table,BorderLayout.CENTER);

        frame.add(p1,BorderLayout.NORTH);
        frame.add(p2,BorderLayout.CENTER);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    private void drawMediumClientWindows()
    {
        frame = new JFrame("Client Joined");
        frame.setSize(600,500);
        frame.setLayout(new GridLayout(1,1));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        p1 = new JPanel();

        Object[] colname =  {0,0,0,0,0,0,0,0,0};//{"c1", "c2", "c3", "c4", "c5", "c6", "c7", "c8", "c9"};
        Object[][] datavalues = {
                {0,0,0,5,6,0,2,0,6},{0,0,0,5,6,0,2,0,6},{0,0,0,5,6,0,2,0,6},
                {0,0,0,5,6,0,2,0,5},{1,0,0,5,6,0,2,0,6},{0,0,0,5,6,0,8,0,6},
                {0,0,0,5,7,0,0,0,6},{0,0,0,5,7,0,0,0,0},{5,0,0,5,7,0,0,0,6}
        };
        DefaultTableModel model = new DefaultTableModel(datavalues,colname);
        table = new JTable(model);

        table.setRowHeight(50);
        Enumeration<TableColumn> nosOfCol = table.getColumnModel().getColumns();
        while (nosOfCol.hasMoreElements())
        {
            TableColumn column = nosOfCol.nextElement();
            column.setPreferredWidth(50);
        }

        p1.add(table,BorderLayout.CENTER);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(p1);
        frame.setVisible(true);
    }
    private void drawMediumServerWindows()
    {
        frame = new JFrame("Server Playing");
        frame.setSize(500,600);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        p1 = new JPanel(); // FlowLayot

        lblDififculty = new JLabel("Level(Easy, Medium, Difficult): ");
        txtDifficultyLevel = new JTextField(5);
        btnNewgame = new JButton("New Game");

        btnNewgame.addActionListener(this);

        p1.add(lblDififculty);
        p1.add(cboLevel);
        cboLevel.addActionListener(this);
        p1.add(btnNewgame);

        p2 = new JPanel();

        Object[] colname =  {0,0,0,0,0,0,0,0,0};
        Object[][] datavalues = {
                {1,1,1,1,1,1,1,1,1,1},{0,0,0,5,6,0,2,0,6},{0,0,0,5,6,0,2,0,6},
                {0,0,0,5,6,0,2,0,5},{1,0,0,5,6,0,2,0,6},{0,0,0,5,6,0,8,0,6},
                {0,0,0,5,7,0,0,0,6},{2,2,2,2,2,2,2,2,2},{5,0,0,5,7,0,0,0,6}
        };

        DefaultTableModel model = new DefaultTableModel(datavalues,colname);

        table = new JTable(model);
        table.setRowHeight(50);
        Enumeration<TableColumn> nosOfColumns = table.getColumnModel().getColumns();
        while (nosOfColumns.hasMoreElements())
        {

            TableColumn col = nosOfColumns.nextElement();
            col.setPreferredWidth(50);
        }
        p2.add(table,BorderLayout.CENTER);

        frame.add(p1,BorderLayout.NORTH);
        frame.add(p2,BorderLayout.CENTER);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
    private void drawDifficultyClientWindows()
    {
        frame = new JFrame("Client Joined");
        frame.setSize(600,500);
        frame.setLayout(new GridLayout(1,1));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        p1 = new JPanel();

        Object[] colname =  {0,0,0,0,0,0,0,0,0};//{"c1", "c2", "c3", "c4", "c5", "c6", "c7", "c8", "c9"};
        Object[][] datavalues = {
                {0,0,0,5,6,0,2,0,6},{0,0,0,5,6,0,2,0,6},{0,0,0,5,6,0,2,0,6},
                {0,0,0,5,6,0,2,0,5},{1,0,0,5,6,0,2,0,6},{0,0,0,5,6,0,8,0,6},
                {0,0,0,5,7,0,0,0,6},{0,0,0,5,7,0,0,0,0},{5,0,0,5,7,0,0,0,6}
        };
        DefaultTableModel model = new DefaultTableModel(datavalues,colname);
        table = new JTable(model);

        table.setRowHeight(50);
        Enumeration<TableColumn> nosOfCol = table.getColumnModel().getColumns();
        while (nosOfCol.hasMoreElements())
        {
            TableColumn column = nosOfCol.nextElement();
            column.setPreferredWidth(50);
        }

        p1.add(table,BorderLayout.CENTER);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(p1);
        frame.setVisible(true);
    }
    private void drawDifficultyServerWindows()
    {
        frame = new JFrame("Server Playing");
        frame.setSize(500,600);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        p1 = new JPanel(); // FlowLayot

        lblDififculty = new JLabel("Level(Easy, Medium, Difficult): ");
        txtDifficultyLevel = new JTextField(5);
        btnNewgame = new JButton("New Game");

        btnNewgame.addActionListener(this);

        p1.add(lblDififculty);
        p1.add(cboLevel);
        cboLevel.addActionListener(this);
        p1.add(btnNewgame);

        p2 = new JPanel();

        Object[] colname =  {0,0,0,0,0,0,0,0,0};
        Object[][] datavalues = {
                {1,1,1,1,1,1,1,1,1,1},{0,0,0,5,6,0,2,0,6},{0,0,0,5,6,0,2,0,6},
                {0,0,0,5,6,0,2,0,5},{1,0,0,5,6,0,2,0,6},{0,0,0,5,6,0,8,0,6},
                {0,0,0,5,7,0,0,0,6},{2,2,2,2,2,2,2,2,2},{5,0,0,5,7,0,0,0,6}
        };

        DefaultTableModel model = new DefaultTableModel(datavalues,colname);

        table = new JTable(model);
        table.setRowHeight(50);
        Enumeration<TableColumn> nosOfColumns = table.getColumnModel().getColumns();
        while (nosOfColumns.hasMoreElements())
        {

            TableColumn col = nosOfColumns.nextElement();
            col.setPreferredWidth(50);
        }
        p2.add(table,BorderLayout.CENTER);

        frame.add(p1,BorderLayout.NORTH);
        frame.add(p2,BorderLayout.CENTER);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void tableChanged(TableModelEvent e)
    {
        int ic = e.getColumn();
        int ir = e.getFirstRow();
        TableModel model = (TableModel)e.getSource();

        Object data = model.getValueAt(ir,ic);
//        System.out.println("row and col: "+ir+ic+"val: "+data);

        if (e.getClass().getEnclosingMethod().getName() ==   "drawServerWindows")
        {
            //GameApplication gameApp = new GameApplication();
        }
        else if (e.getClass().getEnclosingMethod().getName() == "drawClientWindows")
        {

        }
            //GameApplication gameApp = new GameApplication();

    }
}

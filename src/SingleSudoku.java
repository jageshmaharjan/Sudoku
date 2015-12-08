import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.Enumeration;

/**
 * Created by jagesh on 12/04/2015.
 */
public class SingleSudoku extends JComponent implements TableModelListener,ListSelectionListener
{
    int[][] board = new int[9][9];

    JFrame frame = new JFrame("Sudoku SinglePlayer");
    JPanel panel = new JPanel();
    JTextField text;
    public void go()
    {
        int[][] gameValueBoard = new int[8][8];

        Object[][] data =  getData();
        Object[] col = {0,0,0,0,0,0,0,0,0};


        DefaultTableModel model = new DefaultTableModel(data,col);
        JTable table = new JTable(model);
        table.setRowHeight(40);
        Enumeration<TableColumn> nosOfCol = table.getColumnModel().getColumns();
        while (nosOfCol.hasMoreElements())
        {
            TableColumn column = nosOfCol.nextElement();
            column.setPreferredWidth(40);
        }

        table.setGridColor(Color.YELLOW);
        table.setBackground(Color.CYAN);

        table.getModel().addTableModelListener(this);

        panel.add(table, BorderLayout.CENTER);
        frame.add(panel);

        frame.setUndecorated(true);
        frame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        for (int i=0;i<table.getRowCount() ; i++)
        {
            for (int j=0;j<table.getColumnCount();j++)
            {
                int a = (int) model.getValueAt(i,j);
                board[i][j] = a;
            }
        }
    }


    @Override
    public void tableChanged(TableModelEvent e)
    {
        int ic = e.getColumn();
        int ir = e.getFirstRow();
        TableModel model = (TableModel)e.getSource();

        Object data = model.getValueAt(ir,ic);
//        System.out.println("ic = " + ic +" & " + "ir = " + ir + ", data: " + data);
        GameCalculation gamecalc = new GameCalculation();
        //gamecalc.overallGameCheck(board);
        boolean isvalid = gamecalc.validMoves(board,data,ir,ic);
        if (isvalid)
        {
            JOptionPane.showMessageDialog(new Frame(),"Winner! Game Over");
            SingleSudoku single = new SingleSudoku();
            this.frame.dispose();
            single.go();
            //System.out.println("Winner! Game Over");
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e)
    {

    }
    public Object[][] getData()
    {
        Object[][] data = {
                {0,0,0,4,0,6,0,8,0},{0,3,0,5,0,0,0,0,0},{0,0,5,0,7,0,0,1,0},{0,5,0,7,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,9,1,0,3,0,0},{9,0,2,0,4,0,0,0,0}
//                {1,2,3,4,5,6,7,8,9},{2,3,4,5,6,7,8,9,1},{3,4,5,6,7,8,9,1,2},{4,5,6,7,8,9,1,2,4},{5,6,7,8,9,1,2,3,4},
//                {6,7,8,9,1,2,3,4,5},{7,8,9,1,2,3,4,5,6},{6,7,8,9,1,2,3,4,5},{9,1,2,3,4,5,6,7,8}
        };
        return data;
    }
}

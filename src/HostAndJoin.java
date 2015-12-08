import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by jagesh on 11/28/2015.
 */
public class HostAndJoin extends JFrame implements ActionListener,SudokuConstants
{
    JLabel lblPort,lblAddress;
    JTextField txtPort,txtAddress;
    JButton btnLaunch,btnJoin,btnSinglePlayer;
    JPanel p1,p2,p3;
    JFrame frame;

    public HostAndJoin()
    {
        prepareHostAndLaunch();
    }

    private void prepareHostAndLaunch()
    {
        frame = new JFrame("Host and launch a Sudoku");
        frame.setSize(400,150);
        frame.setLayout(new GridLayout(3,1));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        p1 = new JPanel();
        p1.setLayout(new FlowLayout());
        p2 = new JPanel();
        p2.setLayout(new FlowLayout());
        p3 = new JPanel();
        p3.setLayout(new FlowLayout());

        frame.add(p1);
        frame.add(p2);
        frame.add(p3);

        //frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args)
    {
        new HostAndJoin().go();
    }

    public void go()
    {
        btnLaunch = new JButton("Launch");
        btnJoin = new JButton("Join");
        txtPort = new JTextField(10);
        txtAddress = new JTextField(10);
        lblPort = new JLabel("Start a game.   Port");
        lblAddress = new JLabel("Join a game.   Address");
        btnSinglePlayer = new JButton("Single Player");

        btnLaunch.addActionListener(this);
        btnJoin.addActionListener(this);
        btnSinglePlayer.addActionListener(this);

        p1.add(lblPort);
        p1.add(txtPort);
        p1.add(btnLaunch);
        p2.add(lblAddress);
        p2.add(txtAddress);
        p2.add(btnJoin);
        p3.add(btnSinglePlayer);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equals("Launch"))
        {
            if (txtPort.getText().equals("31416"))
            {
                System.out.println("Launched");
                //gameServer = new ServerGame(Integer.parseInt(txtPort.getText()),true);    //can use this for direct access to game
                LaunchServer ls = new LaunchServer(Integer.parseInt(txtPort.getText()));

            }
        }
        else if (e.getActionCommand().equals("Join"))
        {
            if (txtAddress.getText().equals(DEFAULT_IP) )
            {
                System.out.println("Joined");
                //gameClient = new ClientGame(txtAddress.getText(),Integer.parseInt(txtPort.getText()));   //can use this for direct access to game
                JoinClient jc = new JoinClient(txtAddress.getText(),Integer.parseInt(txtPort.getText()));
            }
        }
        else if (e.getActionCommand().equals("Single Player"))
        {
            SingleSudoku singlePlay = new SingleSudoku();
            singlePlay.go();
        }
    }
}

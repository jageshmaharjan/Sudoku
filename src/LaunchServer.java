/**
 * Created by jagesh on 11/29/2015.
 */
public class LaunchServer implements SudokuConstants
{
    int port;
    public LaunchServer(int port)
    {
        GameApplication gameapp = new GameApplication("Client","Server",DEFAULT_IP,DEFAULT_PORT,true);

    }

    public void setPort(int port)
    {
        this.port = port;
    }

    public int getPort()
    {
        return port;
    }
}

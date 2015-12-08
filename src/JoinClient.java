/**
 * Created by jagesh on 11/29/2015.
 */
public class JoinClient
{
    String ipaddress;
    int port;
    public JoinClient(String ipaddress, int port)
    {
        GameApplication gameApplication = new GameApplication("client","server",ipaddress,port,false);
    }

    public void setipaddress(String ipaddress)
    {
            this.ipaddress = ipaddress;
    }

    public void setPort(int port)
    {
        this.port = port;
    }

    public String getIPaddress()
    {
        return ipaddress;
    }

    public int getPort()
    {
        return port;
    }
}

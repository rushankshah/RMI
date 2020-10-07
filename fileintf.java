import java.rmi.*;

public interface fileintf extends Remote{
    public byte[] download(String filename) throws RemoteException;
    public void upload(byte b[], String name) throws RemoteException;
}
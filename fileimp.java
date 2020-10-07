import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

@SuppressWarnings("serial")
public class fileimp extends UnicastRemoteObject implements fileintf {
    public fileimp() throws RemoteException {
        super();
    }

    public byte[] download(String filename) {
        byte buffer[] = new byte[100];
        try {
            FileInputStream fin = new FileInputStream(filename);
            fin.read(buffer, 0, 100);
            fin.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buffer;
    }

    public void upload(byte b [], String name){
        try{
            File f = new File(name);
            FileOutputStream outputStream = new FileOutputStream(f);
            outputStream.write(b);
            outputStream.flush();
            outputStream.close();
        } catch(Exception e){
            System.err.println(e.toString());
        }
        System.out.println("Uploading successful");
    }
}

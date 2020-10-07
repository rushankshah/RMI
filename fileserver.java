import java.rmi.*;

public class fileserver {
    public static void main(String[] args) {
        try {
            fileintf _Fileintf = new fileimp();
            Naming.rebind("rmi://localhost:1099//fileimp", _Fileintf);
            System.out.println("Server is up and running");
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}

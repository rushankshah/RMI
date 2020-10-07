import java.rmi.Naming;
import java.util.Scanner;

public class fileclient {
    public static void main(String[] args) {
        try{
            fileintf fi = (fileintf)Naming.lookup("rmi://localhost//fileimp");
            String fileName;
            Scanner sc = new Scanner(System.in);
            int option = 0;
            while(option!=1){
                System.out.println("Enter your choice: \n 1. Exit \n 2. Upload \n 3. Download");
                option = sc.nextInt();
                if(option == 2){
                    System.out.println("Enter filename: ");
                    fileName = sc.next();
                    System.out.println("Enter data: ");
                    String data = sc.next();
                    byte[] byteData = data.getBytes();
                    fi.upload(byteData, fileName+".txt"); 
                } else if(option == 3){
                    System.out.println("Enter filename: ");
                    fileName = sc.next();
                    String output = new String(fi.download(fileName + ".txt"));
                    System.out.println("Data is "+output);
                }
            }
            sc.close();
        } catch (Exception e){
            System.err.println(e);
        }
    }
}

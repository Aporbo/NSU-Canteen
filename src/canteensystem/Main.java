/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canteensystem;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import canteensystem.component.auth.userlog;
public class Main  {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
   
        
        createRequiredFileIfDoesNotExist();
        
        userlog im = new userlog();
        im.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        im.setVisible(true);
    }
    
    private static void createRequiredFileIfDoesNotExist() {
        String fileNames [];
        
        File rootDir = new File("storage");
        rootDir.mkdirs();
        
        fileNames = new String [] {"storage/item.txt",
            "storage/staff.txt",
            "storage/order.txt",
            "storage/orderLine.txt"};
        
        for (String fileName : fileNames) {
            File file = new File(fileName);
            if(!file.exists())
            {  
                try {
                    file.createNewFile();
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
       
    }
}

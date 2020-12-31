package canteensystem.service;
import canteensystem.model.account;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class AccountService {
     public AccountService() {
    }
        public List<account> getAll() {
        List<account> account = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileInputStream("storage/account.txt"))) {
            while (scanner.hasNextLine()) {
                 String accountLine = scanner.nextLine();
                 String accountInfo[] = accountLine.split(",");
                 account Account = new account(accountInfo[0],accountInfo[1],accountInfo[2],accountInfo[3],accountInfo[4]);
                account.add(Account);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ItemService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return account;
    }
/*public account getItemByIndex(int index) {
        List<account> listOfaccount = getAll();
       if (listOfaccount.size() >= index) {
            return listOfaccount.get(index - 1);
        }     return null;
    }*/
public void create(account Account) {
        try (PrintWriter pw = new PrintWriter(new FileOutputStream("storage/account.txt", true))) {
            pw.println(Account.getName() + "," + Account.getID() + "," + Account.getEmail()+ "," + Account.getPassword()+ "," + Account.getRetypepassword());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ItemService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}


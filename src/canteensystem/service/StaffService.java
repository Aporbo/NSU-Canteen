/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canteensystem.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import canteensystem.component.staff.Addstaff;
import canteensystem.component.staff.Deletestaff;
import canteensystem.component.staff.Updatestaff;
import canteensystem.model.Staff;


public class StaffService {

    public StaffService() {
    }

    public List<Staff> getAll() {
        List<Staff> staffList = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileInputStream("storage/Staff.txt"))) {
            while (scanner.hasNextLine()) {

                String StaffLine = scanner.nextLine();

                String IStaffnfo[] = StaffLine.split(",");

                Staff staff = new Staff(IStaffnfo[0], IStaffnfo[1], Double.parseDouble(IStaffnfo[2]));

                staffList.add(staff);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Deletestaff.class.getName()).log(Level.SEVERE, null, ex);
        }
        return staffList;
    }

    public void create(Staff staff) {
        try (PrintWriter pw = new PrintWriter(new FileOutputStream("storage/Staff.txt", true))) {
            pw.println(staff.getId() + "," + staff.getName() + "," + staff.getSalary());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Addstaff.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public  boolean update(String sourceId, Staff updatestaff) {
        // Read all the items
        List<Staff> staffList = getAll();

        int indexToUpdate = -1;
        for (int i = 0; i < staffList.size(); i++) {
            Staff staff = staffList.get(i);

            if (staff.getId().equalsIgnoreCase(sourceId)) {
                indexToUpdate = i;
            }
        }

        if (indexToUpdate == -1) {
           return false;
        }

        staffList.set(indexToUpdate, updatestaff);

        try {
            Files.delete(Paths.get("storage/Staff.txt"));
        } catch (IOException ex) {
            Logger.getLogger(Updatestaff.class.getName()).log(Level.SEVERE, null, ex);
        }

        try (PrintWriter pw = new PrintWriter(new FileOutputStream("storage/Staff.txt"))) {
            staffList.forEach(Staff -> {
                pw.println(Staff.getId() + "," + Staff.getName() + "," + Staff.getSalary());
            });
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Updatestaff.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
    }

    public synchronized void delete(String StaffID) {
        List<Staff> StaffList = getAll();

        
        for (int i = 0; i < StaffList.size(); i++) {

            Staff labour = StaffList.get(i);

            if (labour.getId().equalsIgnoreCase(StaffID)) {
                StaffList.remove(labour);
             }
        }

        try {
            
            Files.delete(Paths.get("storage/Staff.txt"));
         } catch (IOException ex) {
            Logger.getLogger(StaffService.class.getName()).log(Level.SEVERE, null, ex);
        }
  
        try (PrintWriter pw = new PrintWriter(new FileOutputStream("storage/Staff.txt"))) {
            StaffList.forEach(labour -> {
                pw.println(labour.getId() + "," + labour.getName() + "," + labour.getSalary());
            });
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StaffService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

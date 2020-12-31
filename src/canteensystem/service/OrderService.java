/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canteensystem.service;
import java.util.ArrayList;
import canteensystem.model.Cart;
import canteensystem.model.CartItem;
import canteensystem.model.OrderLine;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class OrderService {
    
    private Cart cart;
    
    
     public List<OrderLine> getAll() {
        List<OrderLine> OrderList = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileInputStream("storage/orderLine.txt"))) {
            while (scanner.hasNextLine()) {

                String OrderLine = scanner.nextLine();

                String IStaffnfo[] = OrderLine.split(",");

                OrderLine order = new OrderLine(Integer.parseInt(IStaffnfo[0]), IStaffnfo[1],Integer.parseInt(IStaffnfo[2]),Double.parseDouble(IStaffnfo[3]),IStaffnfo[4],IStaffnfo[5]);

                OrderList.add(order);
            }
        } catch (FileNotFoundException ex) {
          
        }
        return OrderList;
    }
  
    
    public OrderService() {
        this.cart = new Cart(new ArrayList<>(), 0);
    }
    
    public void addToCart(CartItem cartItem) {
        this.cart.addItemToCart(cartItem);
    }
    
    public void clearCart() {
        this.cart = new Cart(new ArrayList<>(), 0);
    }
    
    public Cart getCart() {
        return this.cart;
    }
}

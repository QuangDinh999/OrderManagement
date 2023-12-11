package main.java;

import jdk.nashorn.internal.objects.Global;

import java.util.*;

public class Main {
    public static Scanner input = new Scanner(System.in);
    public static Queue_AbstractDataType<Order> orderQueueADT =  new Queue_Implement<>(100);

    public static int Order_id = 0;
    public static void Menu() {
        System.out.println("--------------Order Management--------------");
        System.out.println("|1. Add Order                               |");
        System.out.println("|2. Show Order List                         |");
        System.out.println("|3. search Order by ID                      |");
        System.out.println("|4. Approve Order                           |");
        System.out.println("|0. Exit                                    |");
        System.out.println("--------------Order Management--------------");
    }

    public static void SubMenu() {
        System.out.println("--------------Order Management--------------");
        System.out.println("|1. Coffee                                   |");
        System.out.println("|2. Lemon juice                              |");
        System.out.println("|3. Ice Tea                                  |");
        System.out.println("|0. Back                                     |");
        System.out.println("--------------Order Management--------------");
    }


    public static void AddOrder() {
        int subChoice = -1;
        int Product_id = 0;
        int OrderDetail_id = 0;
        Order order = new Order(++Order_id).clone();
        do{
            SubMenu();
            System.out.print("Enter your Choice: ");
            subChoice = input.nextInt();
            if(subChoice < 0 || subChoice > 4) {
                throw new RuntimeException("ERROR! Choose right number in the menu");
            }else {
                switch (subChoice){
                    case 1:
                        Product p1 = new Product(++Product_id, "Bac Siuuu", 20000);
                        OrderDetail orderDetail_1 = new OrderDetail(++OrderDetail_id);
                        System.out.print("Enter quantity of product:");
                        orderDetail_1.setAmount(input.nextInt());
                        orderDetail_1.setProduct(p1);
                        order.getOrderdetail().add(orderDetail_1);
                        break;
                    case 2:
                        Product p2 = new Product(++Product_id, "Ca phe", 25000);
                        OrderDetail orderDetail_2 = new OrderDetail(++OrderDetail_id);
                        System.out.print("Enter quantity of product:");
                        orderDetail_2.setAmount(input.nextInt());
                        orderDetail_2.setProduct(p2);
                        order.getOrderdetail().add(orderDetail_2);
                        break;
                    case 3:
                        Product p3 = new Product(++Product_id, "Tra Chanh", 14000);
                        OrderDetail orderDetail_3 = new OrderDetail(++OrderDetail_id);
                        System.out.print("Enter quantity of product:");
                        orderDetail_3.setAmount(input.nextInt());
                        orderDetail_3.setProduct(p3);
                        order.getOrderdetail().add(orderDetail_3);
                        break;
                }
            }
        }while (subChoice!=0);

        System.out.println("ORDER");
        System.out.print("Enter Date of Order: ");
        order.setDate(input.next());
        System.out.print("Enter Customer Name: ");
        order.setCustomerName(input.next());
        System.out.print("Enter Customer phone: ");
        order.setCustomerPhone(input.next());



        int total = 0;
        for (OrderDetail orders: order.getOrderdetail()) {
            total+= orders.getProduct().getPrice() * orders.getAmount();
        }
        order.setTotalAmount(total);
        orderQueueADT.enqueue(order);
        order.printOrder();
    }

    public static void main(String[] args) {
        int choice = -1;
        do {
            Menu();
            System.out.print("Enter your Choice: ");
            choice = input.nextInt();
            if(choice < 0 || choice > 5){
                throw new RuntimeException("ERROR! Choose right number in the menu");
            }else {
                switch (choice){
                    case 0:
                        System.out.println("Exit");
                        break;
                    case 1:
                        AddOrder();
                    break;
                    case 2:
                        System.out.println("------------------ORDER LIST------------------");
                        for (Order orders: orderQueueADT.Orderlist()) {
                            orders.printOrder();
                            System.out.println("           - - - - - - - - -               ");
                        }
                        System.out.println("---------------------------------------------");
                        break;
                    case 3:
                        System.out.println("Search: ");
                        int searchID = input.nextInt();
                        List<Order> order1 = orderQueueADT.Orderlist();
                        for (Order orderdetail : order1) {
                            if(orderdetail.getId() == searchID){
                                orderdetail.printOrder();
                            }
                        }
                        break;
                    case 4:
                        while (true){
                            Order order = orderQueueADT.dequeue();
                            order.setStatus(true);
                            order.printOrder();
                            if(orderQueueADT.isEmpty()){
                                break;
                            }
                        }
                        break;
                    case 5:
                        List<Order> order = orderQueueADT.Orderlist();
                        order.sort(Comparator.comparingLong(Order::getTotalAmount));
                        for (Order orderdetail : order) {
                            orderdetail.printOrder();
                        }
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + choice);
                }
            }
        }while (choice!=0);
    }
}
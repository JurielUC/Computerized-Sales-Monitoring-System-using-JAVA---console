package computerized.sales.monitoring.system;
import java.io.File;
import java.io.FileWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ComputerizedSalesMonitoringSystem {
 
    //Represent a node of the singly linked list    
    class Node
    {    
        String qty;
        String items;
        float netprice;
        float price;
        Node next;    
            
        public Node(String qty, String items, float netprice, float price) 
        {    
            this.qty = qty;  
            this.items = items;
            this.netprice = netprice;
            this.price = price;
            this.next = null;    
        }    
    }    
    //Represent the head and tail of the singly linked list    
    public Node head = null;    
    public Node tail = null;    
        
    //addNode() will add a new node to the list    
    public void addNode(String qty, String items, float netprice, float price) {    
        //Create a new node    
        Node newNode = new Node(qty, items, netprice, price);    
            
        //Checks if the list is empty    
        if(head == null) {    
            //If list is empty, both head and tail will point to new node    
            head = newNode;    
            tail = newNode;    
        }    
        else {    
            Node temp = newNode;
            temp.qty = qty;
            temp.items = items;
            temp.netprice = netprice;
            temp.price = price;
            temp.next = null;
            tail.next = temp;
            tail = temp; 
        }    
    }    
        
    //display() will display all the nodes present in the list    
    public void display() {    
        //Node current will point to head      
        Node current = head;
        if(current == null) {    
            System.out.println("\tList is empty");     
        }  
        else
        {
            System.out.println("\tThe list contains: ");    
            while(current != null) {    
                 //Prints each node by incrementing pointer    
                 System.out.print("\tQTY: " + current.qty);   
                 System.out.print("\t\tITEM: " + current.items); 
                 System.out.print("\t\tNETPRICE: " + current.netprice); 
                 System.out.println("\t\tPRICE: " + current.price); 
                 current = current.next;    
        }  
        }
    }    
    //removed an item to the list
    public void remove()
    {
        //when the user remove an item but it is already empty, it will display a text
        if(head == null)
        {
            System.out.println("\tThe list is already empty.\n");
            return;
        }
        else
        {
            if(head != tail)
            {  
                Node current = head;   
                while(current.next != tail) {  
                    current = current.next;  
                }  
                tail = current;  
                tail.next = null;  
            }  
            else {  
                head = tail = null;  
            } 
        }
    }
    //it is used to compute all prices
    public void sumOfallnodes()
    {
        if(head == null)
        {
            System.out.println("\tNo prices to compute.\n");
        }
        float sum = 0;
        float sum2 = 0;
        while(head != null)
        {
            sum = sum + head.netprice;
            sum2 = sum2 + head.price;
            head = head.next;
            System.out.print("\n\tTOTAL NETPRICE: " + sum);
            System.out.println("\t\t\tTOTAL PRICE: " + sum2);
        }
    }
    //it displays the all the options
    public static char menu()
    {
        Scanner sc = new Scanner(System.in);
        char choice;
        System.out.print("\t=======================================================================================\n");
        System.out.print("\t                                        Menu\n");
        System.out.print("\t=======================================================================================\n");
        System.out.print("\t1. Add an item");
        System.out.print("\t\t2. Show the list");
        System.out.print("\t3. Remove an Item");
        System.out.print("\t4. Total Price ");
        System.out.print("\n\t5. Calculator ");
        System.out.print("\t\t6. Help ");
        System.out.println("\t\t7. Exit ");
        System.out.print("\t=======================================================================================\n");
        System.out.print("\tChoose Number: ");
        choice = sc.next().charAt(0);
        System.out.print("\t=======================================================================================\n");
        return choice;
    } 
    public static int inventory() throws IOException 
    {    
        Scanner in = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        ComputerizedSalesMonitoringSystem sList = new ComputerizedSalesMonitoringSystem();
        Node head;
        Node tail;
        char choice;
        String qty = null;
        String items = null;
        float netprice = 0;
        float price = 0;
        
        System.out.print("\n");
        System.out.print("                    ÛÛ                                                       ÛÛ   ÛÛÛÛÛÛÛÛÛÛ         \n");
        System.out.print("          ÛÛÛÛÛÛÛÛÛÛÛÛ  Û   Û  ÛÛÛ  Û   Û Û ÛÛÛÛÛ  ÛÛÛ  ÛÛÛÛ  Û Û   Û  ÛÛÛÛ  ÛÛÛÛÛÛÛÛÛÛÛÛÛÛÛ         \n");
        System.out.print("        ÛÛÛÛÛÛÛÛÛÛÛÛÛÛ  ÛÛ ÛÛ Û   Û ÛÛ  Û Û   Û   Û   Û Û   Û Û ÛÛ  Û Û      ÛÛÛÛÛÛÛÛ                \n");
        System.out.print("        ÛÛÛÛÛ   ÛÛÛÛÛÛ  Û Û Û Û   Û Û Û Û Û   Û   Û   Û ÛÛÛÛ  Û Û Û Û Û  ÛÛ  ÛÛÛÛÛÛÛÛ                \n");
        System.out.print("        ÛÛÛÛÛÛÛÛÛÛÛÛÛÛ  Û   Û Û   Û Û  ÛÛ Û   Û   Û   Û Û   Û Û Û  ÛÛ Û   Û  ÛÛÛÛÛÛÛÛ                \n");
        System.out.print("          ÛÛÛÛÛÛÛÛÛÛÛÛ  Û   Û  ÛÛÛ  Û   Û Û   Û    ÛÛÛ  Û   Û Û Û   Û  ÛÛÛÛ  ÛÛÛÛÛÛÛÛÛÛÛÛÛÛÛÛÛÛ      \n");
        System.out.print("                    ÛÛ                                                       ÛÛ   ÛÛÛÛÛÛÛÛÛÛÛÛÛ      \n");
        
        String filename;
        System.out.print("\tUse '*.txt' (example 12/16/20.txt)\n");
        System.out.print("\tEnter Date(File Name): ");
        filename = sc.nextLine();
        do{
            choice = menu();
            switch(choice)
            {
                case '1':   
                        try{
                          System.out.print("\tQuantity: ");
                          qty = sc.nextLine();  
                          System.out.print("\tItem: ");
                          items = sc.nextLine(); 
                          System.out.print("\tNetprice: ");
                          netprice = in.nextFloat();
                          System.out.print("\tPrice: ");
                          price = in.nextFloat();
                          sList.addNode(qty, items, netprice, price);
                        }
                        catch(Exception e){
                            System.out.print("\t=======================================================================================\n");
                            System.out.println("\n\tInvalid Input. Try Again!");
                        }
                        {
                                File file = new File(filename);
                                FileWriter fw = new FileWriter(file, true);
                                PrintWriter myWriter = new PrintWriter(fw);
                                myWriter.print("Quantity: " + qty  + "\t");
                                myWriter.print("\tItem: " + items  + "\t\t");
                                myWriter.print("\tNet Price: " + netprice  + "\t");
                                myWriter.println("\tPrice: " + price  + "\t");
                                myWriter.println("===================================================================================================");
                                myWriter.close();
            }
                          break;
                case '2': sList.display();
                          break;
                case '3': sList.remove();
                          break;
                case '4': sList.sumOfallnodes();
                          break;
                case '5': calculator();
                          break;
                case '6': help();
                          break;
                case '7': System.out.println("\tSystem Shutdown. Thank You!");
                          System.exit(0); 
                          break;
                default: System.out.println("\tInvalid Input!");
            }
        }while(choice != '8');
        return inventory();
    }    
    
    
    
    public static void displayMenu()
    {
        System.out.println("\t=======================================================================================");
        System.out.println("\t                                      CALCULATOR");
        System.out.println("\t=======================================================================================");
        System.out.print("\t1. ADD");
        System.out.print("   2. SUBTRACT");
        System.out.print("   3. MULTIPLY");
        System.out.print("   4. DIVIDE");
    }
    //Calculator
    public static int calculator()
    {
        Scanner in = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        displayMenu();
        int ychoice;
        float a, b;
        char confirm;
        float sum;
        float subtract;
        float multiply;
        float divide;
        
        do
        {
            try{
            System.out.print("\n\tEnter your choice: ");
            ychoice = in.nextInt();
            System.out.print("\tFirst Number: ");
            a = in.nextInt();
            System.out.print("\tSecond Number: ");
            b = in.nextInt();
            

            
            sum = a + b;
            subtract = a - b;
            multiply = a * b;
            divide = a / b;
            
            switch(ychoice)
            {
                case 1: System.out.print("\tResult: " + sum);
                        break;
                case 2: System.out.print("\tResult: " + subtract);
                        break;
                case 3: System.out.print("\tResult: " + multiply);
                        break;
                case 4: System.out.print("\tResult: " + divide);
                        break;
                default:System.out.println("\tEnter Correct Operator!!!");
            }
            }
            catch(Exception e){
                System.out.print("\tInvalid Input! ");
            }
        System.out.print("\n\n\tPress Y to continue and N to exit: ");
        confirm = sc.next().charAt(0);
        }while(confirm=='y'||confirm=='Y');
        return 0;
    }
    //it is called when the user needs help
    public static int help()
    {
        Scanner sc = new Scanner(System.in);
        char choice;
        do{
        System.out.println("\tÛÛ DESCRIPTION:");
        System.out.println("\t=======================================================================================");
        System.out.println("\t  It's a computerized sales monitoring system which aims to lessen the hassle of hand ");
        System.out.println("\twriting and manual computing of sales income.");
        System.out.println("\t=======================================================================================");
        System.out.println("\tÛÛ INSTRUCTION:");
        System.out.println("\t=======================================================================================");
        System.out.println("\t  Simply understand and follow the instructions that were displayed by the computer ");
        System.out.println("\tto avoid errors.");
        System.out.println("\t=======================================================================================");
        System.out.println("\tÛÛ SALE MONITORING INSTRUCTION:");
        System.out.println("\t=======================================================================================");
        System.out.println("\tThere are 5 choices in the menu.");
        System.out.println("\to To add an item enter 1.");
        System.out.println("\to To show the list of items enter 2.");
        System.out.println("\to To remove an item enter 3.");
        System.out.println("\to To get the total net price and price enter 4.");
        System.out.println("\to To show the calculator enter 5.");
        System.out.println("\to If you need help enter 6.");
        System.out.println("\tAvoid using space when entering an items! You can use underscore (_) as space.");
        System.out.println("\tDo not use character A-Z / a-z when entering Net Price and Price;");
        System.out.println("\tAll data that you've entered will be going to the text(.txt) file that you made.;");
        System.out.println("\tYou can see your created file inside the folder of the program.");
        System.out.println("\tThe only way to remove data from the file is to erase it from the file manually.");
        System.out.println("\t=======================================================================================");
        System.out.println("\tÛÛ CALCULATOR INSTRUCTION:");
        System.out.println("\t=======================================================================================");
        System.out.println("\tPress 1 for addition. ");
        System.out.println("\tPress 2 for subraction. ");
        System.out.println("\tPress 3 for multiplication. ");
        System.out.println("\tPress 4 for division.");
        System.out.println("\tChoose between 1-4 then enter first and second number and see the result. ");
        
        System.out.print("\tDo you want to back? ENTER Y: ");
        choice = sc.next().charAt(0);
        }while(choice == 'N'|| choice == 'n');
        return 0;
    }
    //Main
    public static void main(String[] args) throws IOException
    {
        inventory();
    }
}
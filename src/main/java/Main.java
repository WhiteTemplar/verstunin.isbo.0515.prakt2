import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

import java.util.Scanner;

/**
 * Created by admin on 14.04.2017.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Server server = new Server(80);
        ServletContextHandler h = new ServletContextHandler();
        h.addServlet(TestServlet.class, "/");
        server.setHandler(h);
        server.start();
        ToDoArray list= new ToDoArray();
        Scanner input = new Scanner(System.in);
        int choice = 0;
        while (true){
            System.out.println();
            System.out.println("Type 1 to add string");
            System.out.println("Type 2 to delete string");
            System.out.println("Type 3 to view a string");
            System.out.println("Select an option");
            choice= input.nextInt();
            if (choice == 1){
                String action = input.nextLine();
                list.add(action);
                break;
            }
            if (choice == 2){
                int number = Integer.parseInt(input.nextLine());
                list.delete(number);
                break;
            }
            if (choice == 3){
                for(int i=0;i<=list.view().size();i++)
                    System.out.println(list.view());
                break;
            }
        }
    }
}


import java.util.Scanner;

public class tmain{

    public static void hilfe()
    {
        System.out.println("Es gibt diese Commands:");
        System.out.println("help --) für Hilfe");
        System.out.println("show --) listet alle gekauften Tickets auf");
        System.out.println("buy --) kauft tickets");
        System.out.println("newcostomer --) registriert neuen kunde");
        System.out.println("end --) beendet das programm");
        System.out.println();

    }

    public static void main(String[] args) {
        Ticket ticket= new Ticket();
        Kunde Kunden = new Kunde();
        Tablecreate Tablenew = new Tablecreate();
       
        Tablenew.createNewDatabase("shop.db");
        Kunden.kundecreate("Torben", 6176, "Austria");
        Kunden.kundecreate("Jens", 6020, "Austria");
        ticket.generateTicketart("AcDc", 10000, "A");
        ticket.generateTicketart("IronMaiden", 10000, "C");
        boolean theend= false;
        Scanner s = new Scanner(System.in);
        System.out.println("Type help for Help");
       while( theend != true)
        {
        switch(s.nextLine()){
            case "newcustomer":System.out.println("Gebe Name, Postleizahl und Land an"); Kunden.kundecreate(s.nextLine(), s.nextInt(), s.nextLine()); break;
            case "buy": Kunden.kundelist(); ticket.Ticketbuy();  break;   
            case "show": ticket.Ticketshow(); break;
            case "end": theend=true; break;
            case "help": hilfe(); break;
        }
       }
        s.close();

        }

}
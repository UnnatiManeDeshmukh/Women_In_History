package history_of_women;

import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DatabaseManager.createTable();

        while (true) {
            System.out.println("\n--- Women in History Menu ---");
            System.out.println("1. Insert  2. Display  3. Update  4. Delete  5. Exit");
            System.out.print("Choice: ");
            int ch = sc.nextInt(); sc.nextLine();

            if (ch == 5) break;

            switch (ch) {
                case 1:
                    System.out.print("Name: "); String name = sc.nextLine();
                    System.out.print("Birth Year: "); int year = sc.nextInt(); sc.nextLine();
                    System.out.print("Country: "); String country = sc.nextLine();
                    System.out.print("Contribution: "); String contrib = sc.nextLine();
                    DatabaseManager.insert(new Woman(name, year, country, contrib));
                    System.out.println("✅ Inserted.");
                    break;

                case 2:
                    List<Woman> list = DatabaseManager.fetchAll();
                    for (Woman w : list) {
                        System.out.printf("ID: %d | Name: %s | Year: %d | Country: %s | Contribution: %s%n",
                                w.getId(), w.getName(), w.getBirthYear(), w.getCountry(), w.getContribution());
                    }
                    break;

                case 3:
                    System.out.print("ID to Update: "); int id = sc.nextInt(); sc.nextLine();
                    System.out.print("New Name: "); name = sc.nextLine();
                    System.out.print("New Year: "); year = sc.nextInt(); sc.nextLine();
                    System.out.print("New Country: "); country = sc.nextLine();
                    System.out.print("New Contribution: "); contrib = sc.nextLine();
                    DatabaseManager.update(new Woman(id, name, year, country, contrib));
                    System.out.println("🔁 Updated.");
                    break;

                case 4:
                    System.out.print("ID to Delete: "); id = sc.nextInt();
                    DatabaseManager.delete(id);
                    System.out.println("🗑️ Deleted.");
                    break;

                default:
                    System.out.println("❌ Invalid option.");
            }
        }

        sc.close();
        System.out.println("👋 Exiting...");
    }
}

import java.util.Set;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class MainLaptop {

  public static void filterLaptops(Set<laptop> laptops, Map<String, String> filters, Scanner scanner) {
    boolean notFound = true;
    for (laptop laptop : laptops) {
        boolean match = true;
        for (Map.Entry<String, String> entry : filters.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            switch (key) {
                case "OS":
                    if (!laptop.getOS().equals(value)) {
                        match = false;
                    }
                    break;
                case "RAM":
                    if (laptop.getRAM() < Integer.parseInt(value)) {
                        match = false;
                    }
                    break;
                case "HDD":
                    if (laptop.getHDD() < Integer.parseInt(value)) {
                        match = false;
                    }
                    break;
                case "BRAND":
                    if (!laptop.getBrand().equals(value)) {
                        match = false;
                    }
                    break;
            }
        }
        if (match) {
            if (notFound){
              System.out.println("По указанным критириям подобраны следующие ноутбуки:");
              notFound = false;   
            }
            System.out.println(laptop);
        }
    }
    if (notFound){
      
      System.out.print("По указанным критириям ноутбуки не найдены. Повторить поиск (y/n)? ");
      String answer = scanner.nextLine();
      
      if (answer.equalsIgnoreCase("y")) {
        askFilters(laptops, scanner); 
      }
    }
  }
  
  public static void askFilters(Set<laptop> laptops, Scanner scanner) {
    System.out.print("Введите через ',' критерии фильтрации (OS, RAM, HDD, brand): ");
    String criteria = scanner.nextLine();

    // Разбить введенные критерии на отдельные фильтры
    String[] filters = criteria.split(",");
    Map<String, String> filterMap = new HashMap<>();
    for (String filter : filters) {
        filter = filter.trim().toUpperCase();
        if (!filter.equals("OS") && !filter.equals("RAM") && !filter.equals("HDD") && !filter.equals("BRAND")) {
          System.out.println("Введен неопознанный критерий " + filter);
          return; 
        }

        Set<Object> var = new TreeSet<>();
        for (laptop laptop : laptops) {
          switch (filter) {
            case "OS":
                var.add(laptop.getOS());
                break;
            case "RAM":
                var.add(laptop.getRAM());
                break;
            case "HDD":
                var.add(laptop.getHDD());
                break;
            case "BRAND":
                var.add(laptop.getBrand());
                break;
          }
        }
        System.out.print("Введите значение для критерия " + filter +" "+var+ ": ");
        String value = scanner.nextLine();
        filterMap.put(filter, value);
    }
   
    // Выполнить фильтрацию и вывести результат
    filterLaptops(laptops, filterMap, scanner);
      }

  public static void main(String[] args) {
    
    Set<laptop> laptops = new HashSet<>();
    laptops.add(new laptop("Windows", 16, 512, "Lenovo"));
    laptops.add(new laptop("Windows", 32, 1024, "HP"));
    laptops.add(new laptop("Windows", 16, 1024, "Lenovo"));
    laptops.add(new laptop("Windows", 8, 512, "IRBIS"));
    laptops.add(new laptop("Astra Linux", 32, 4096, "IRBIS"));
    laptops.add(new laptop("MacOS", 8, 512, "MacBook"));
    laptops.add(new laptop("MacOS", 32, 1024, "MacBook"));
    laptops.add(new laptop("Linux", 8, 512, "HP"));
    laptops.add(new laptop("Linux", 16, 1024, "Lenovo"));
    
    Scanner scan = new Scanner(System.in);
    askFilters(laptops, scan);

    scan.close();
  }
}

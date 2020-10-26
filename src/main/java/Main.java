import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class Main {

    private static void printGroupedEmployeesBasedOnTitle(List<Employee> employeeList) throws Exception {

        Map<String, List<String>> groupedEmployees = employeeList.stream()
                .collect(groupingBy(p -> p.title, mapping((Employee e) -> "Name: " + e.name + " - " + e.phoneNum, toList())));
        for (String key : groupedEmployees.keySet()) {
            List t = groupedEmployees.get(key);
            if (t.size() < 2)
                throw new Exception("Employees with job title " + key + " are less than 2");
            System.out.println("Title " + key + " " + t.size());
            for (Object s : t)
                System.out.println(s);
        }

    }


    public static void main(String[] args) {
        List<Employee> input = Arrays.asList(
                new Employee("Youmna", "SE", 01132435353),
                new Employee("Ali", "SE", 01132435353),
                new Employee("Abdelrahman", "ASE", 01132435353),
                new Employee("Abdelrahman", "ASE", 01132435353)
        );
        try {
            printGroupedEmployeesBasedOnTitle(input);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


}


//    forEach(e -> {
//                  List<Employee> temp = groupedEmployees.get(e.title);
//                  if(temp == null) {
//                      List<Employee> et = new ArrayList<>();
//                      et.add(e);
//                      groupedEmployees.put(e.title,et);
//                  }else{
//                      temp.add(e);
//                  }
//              });
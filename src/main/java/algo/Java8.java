package algo;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8 {
    static class Employee {
        Employee(int i, String n, int s) {
            id = i;
            name = n;
            salary = s;
        }
        String name;
        int id;
        int salary;
        public int getSalary() {
            return salary;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Employee employee = (Employee) o;
            return id == employee.id &&
                    salary == employee.salary &&
                    Objects.equals(name, employee.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, id, salary);
        }
    }
    static class Department {
        Department(String n) {
            name = n;
        }
        String name;
        List<Employee> employees;
    }

    public static void main(String[] args) {

        Employee e1 = new Employee(1,"Nalin", 2000);
        Employee e0 = new Employee(0,"Nalin", 2000);
        Employee e2 = new Employee(2,"Nipun", 3000);
        Employee e3 = new Employee(3,"Sarthak", 1000);
        Employee e4 = new Employee(4,"Yashu", 500);
        Department science = new Department("Science");
        science.employees.add(e1);
        science.employees.add(e0);
        science.employees.add(e2);
        Department commerce = new Department("Commerce");
        commerce.employees.add(e3);
        commerce.employees.add(e4);

        List<Department> depts = new ArrayList<>();
        depts.add(science);
        depts.add(commerce);
        int a [] = {1,2,3};
        Stream.of(a);
        int sum = Arrays.stream(a).filter(i->i%2==0).sum();
        List<Integer> l = Arrays.asList(1,2,3);
        List<Float> f = Arrays.asList(1.0f,2.0f,3.0f);
        List<Double> d = Arrays.asList(1.0,2.0,3.0);
        l.stream().filter(i->i%2==0).collect(Collectors.toList());
        System.out.println(sum);
        //l.stream().filter(i->i%2==0).collect(Collectors.summingInt());

        StringJoiner j = new StringJoiner("","","");
        /*BiConsumer<StringJoiner, CharSequence> cn = (jj,kk) -> {
            jj.add(kk);
        };*/
        Function<String,Integer> f1 = String::length;
        //Supplier<List> f2 = List::add;
        BiConsumer<List<Integer>,Integer> f0 = List::add;
        BiFunction<List<Integer>,Integer,Boolean> f4 = List::add;

        /**
         *
         */
        double dsum;
        float fsum;
        sum = l.stream().filter(i->i%2==0).collect(Collectors.summingInt(t-> t));
        sum = l.stream().filter(i -> i % 2 == 0).mapToInt(at -> at).sum();
        dsum = d.stream().filter(i -> i % 2 == 0).mapToDouble(at -> at).sum();
        dsum = l.stream().filter(i->i%2==0).collect(Collectors.summingDouble(t-> t));
        dsum = f.stream().filter(i -> i % 2 == 0).mapToDouble(at -> at).sum();
        //sum = l.stream().filter(i -> i % 2 == 0).map(at -> at).sum();

        //total salary
        depts.stream().map(dd->dd.employees).flatMap(List::stream).collect(Collectors.summingInt(Employee::getSalary));
        int ssum = depts.stream().map(dd -> dd.employees).flatMap(List::stream).mapToInt(Employee::getSalary).sum();
        System.out.println("ssum "+ssum);
        Stream.of(depts.stream().map(dd -> dd.employees).flatMap(List::stream).mapToInt(Employee::getSalary).distinct()).forEach(System.out::println);
        System.out.println("ssum "+ssum);
        OptionalInt smax = depts.stream().map(dd -> dd.employees).flatMap(List::stream).mapToInt(Employee::getSalary).max();
        if(smax.isPresent())
        System.out.println("smax "+smax.getAsInt());

        ssum = depts.stream().map(dd -> dd.employees).flatMap(List::stream).mapToInt(Employee::getSalary).reduce(0,(in1,in2)->in1+in2);
        System.out.println("ssum "+ssum);
        ssum = depts.stream().map(dd -> dd.employees).flatMap(List::stream).mapToInt(Employee::getSalary).reduce((in1,in2)->in1+in2).getAsInt();
        System.out.println("ssum "+ssum);
        OptionalDouble doub = depts.stream().map(dd -> dd.employees).flatMap(List::stream).mapToInt(Employee::getSalary).average();
        System.out.println("doub "+doub);
        long scnt = depts.stream().map(dd -> dd.employees).flatMap(List::stream).mapToInt(Employee::getSalary).count();
        System.out.println("scnt "+scnt);
        depts.stream().map(dd -> dd.employees).flatMap(List::stream).mapToInt(Employee::getSalary).sorted().forEachOrdered(System.out::println);
        boolean sSal_Gr_300 = depts.stream().map(dd -> dd.employees).flatMap(List::stream).mapToInt(Employee::getSalary).anyMatch(sal -> sal > 300);
        System.out.println("sSal_Gr_300 "+sSal_Gr_300);

        boolean sAll_Sal_Gr_0 = depts.stream().map(dd -> dd.employees).flatMap(List::stream).mapToInt(Employee::getSalary).allMatch(sal -> sal >0);
        System.out.println("sAll_Sal_Gr_0 "+sAll_Sal_Gr_0);

        /*
        depts.stream().map(dd -> dd.employees).flatMap(List::stream).mapToInt(Employee::getSalary).findAny();
        depts.stream().map(dd -> dd.employees).flatMap(List::stream).mapToInt(Employee::getSalary).findFirst();
        depts.stream().map(dd -> dd.employees).flatMap(List::stream).mapToInt(Employee::getSalary).peek();
        int res = depts.stream().map(dd -> dd.employees).flatMap(List::stream).map(ele->new ArrayList<>(ele.salary))
                .flatMap(Stream::of).mapToInt(sal->sal);
        depts.stream().map(dd -> dd.employees).flatMap(List::stream).mapToInt(Employee::getSalary).boxed();
        depts.stream().map(dd -> dd.employees).flatMap(List::stream).mapToInt(Employee::getSalary).forEachOrdered();
        depts.stream().map(dd -> dd.employees).flatMap(List::stream).mapToInt(Employee::getSalary).limit();
        depts.stream().map(dd -> dd.employees).flatMap(List::stream).mapToInt(Employee::getSalary).toArray();
        depts.stream().map(dd -> dd.employees).flatMap(List::stream).mapToInt(Employee::getSalary).noneMatch();
        depts.stream().map(dd -> dd.employees).flatMap(List::stream).mapToInt(Employee::getSalary).mapToDouble();
        depts.stream().map(dd -> dd.employees).flatMap(List::stream).mapToInt(Employee::getSalary).asDoubleStream();;*/
        //average
        //depts.stream().map(dd -> dd.employees).flatMap(List::stream).collect(Collectors.)

        /*int [] a = new int[2];
        IntStream.range(0,1).map(i->a[i]).*/
    }
}

package org.g1rix.config.Reflection;

import java.lang.reflect.*;
import java.util.Arrays;

public class ReflectionDemo {
    static void main(String[] args) throws Exception{

        Class<Employee> employeeClass = Employee.class;

//        getName method get the name of the class by using the reference employeeClass
        System.out.println("Name of the Class: " + employeeClass.getName());

//        getField method is used to get only the public field/variable present in the Employee Class
        Field fields[] = employeeClass.getFields();
        for (Field field : fields){
            System.out.println(field.getName()
                    + ":"
                    + field.getType().getSimpleName()
            );
        }

//        getDeclaredField method has the ability of getting private and public field/variable present in the Employee Class
        fields = employeeClass.getDeclaredFields();
        for (Field field : fields)
            System.out.println(field.getName()
                    + ":"
                    + field.getType().getSimpleName()
            );

//        getMethods method returns array of methods available in Employee Class,
//        where it also able to get the Super Class Inherited public methods/members along with Sub Class public methods/members
//        the getReturnType method has the ability of get the method's return type and the getParameter method get the type of parameter which we need to pass
        Method methods[] = employeeClass.getMethods();
        for (Method method : methods)
            System.out.println(method.getName()
                    + ":"
                    + method.getReturnType()
                    + ":"
                    + Arrays.toString(method.getParameters())
            );

//        getMethods method returns array of methods available in Employee Class,
//        where it also able to get the Super Class Inherited public and private methods/members along with Sub Class public and private methods/members
//        the getReturnType method has the ability of get the method's return type and the getParameter method get the type of parameter which we need to pass
        methods = employeeClass.getDeclaredMethods();
        for (Method method : methods)
            System.out.println(method.getName()
                    + ":"
                    + method.getReturnType()
                    + ":"
                    + Arrays.toString(method.getParameters())
            );

//        Constructor is the class in java, by using the getConstructors method the public constructors are acquired and
//        by using the getDeclaredConstructors method the public and private constructors are acquired as array
        Constructor<?> constructors[] = employeeClass.getConstructors();
        for (Constructor constructor : constructors)
            System.out.println(constructor);

        constructors = employeeClass.getDeclaredConstructors();
        for (Constructor constructor : constructors)
            System.out.println(constructor);

//        by setting the accessibility of the class's metadata we can access the private members, fields, constructors
        constructors[0].setAccessible(true);
//        access the no argument constructor and create the object dynamically using newInstance method
        constructors[0].newInstance();

//      it passes the three argument constructor and create the object dynamically using the newInstance method
        constructors[1].newInstance(102, "Giridharan", "Company Name");

//        by using the setAccessible method we can are able to access and mutate the private variable and methods
        Employee employee = new Employee(103, "g1rix" , "company");
        fields[0].setAccessible(true);
        System.out.println("Before :" +fields[0].get(employee));

        fields[0].set(employee, 104);
        System.out.println("After :" + fields[0].get(employee));

//        we can directly use the name of the method to get it using getDeclaredMethod  and invoke it by using the invoke method by passing the object of the class
        Method method = employeeClass.getDeclaredMethod("display");
        method.invoke(employee);

//        we can even use the array we got, if the respective method have no arguments to pass we can pass the args(argument) has null to invoke the method
        methods[1].setAccessible(true);
        methods[1].invoke(employee, null);

    }
}

package constructorApi;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class practiceConstructor {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        printConstructorData(Person.class);
        printConstructorData(Address.class);

        Person person = createInstanceWithArgument(Person.class);
        System.out.println(person.toString());

        Person person2 = createInstanceWithArgument(Person.class, "john", 20);
        System.out.println(person2.toString());

        Address address = createInstanceWithArgument(Address.class, "abc", 123);
        Person person3 = createInstanceWithArgument(Person.class, "john", 20, address);
        System.out.println(person3.toString());


    }

    public static <T> T createInstanceWithArgument(Class<T> Classes, Object... args) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        for (Constructor<?> constructor : Classes.getConstructors()) {
            if (constructor.getParameterTypes().length == args.length) {
                return (T) constructor.newInstance(args);

            }
        }
        System.out.println("an appropriate constructor not found");
        return null;
    }

    public static void printConstructorData(Class<?> clazz) throws NoSuchMethodException {
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        System.out.printf("class %s has %d declared constructors", clazz, constructors.length);

        for (int i = 0; i < constructors.length; i++) {
            Class<?>[] parameterTypes = constructors[i].getParameterTypes();

            List<String> parameterTypesName = Arrays.stream(parameterTypes)
                    .map(type -> type.getSimpleName())
                    .collect(Collectors.toList());
            System.out.println(parameterTypesName);
        }

    }


    public static class Person {
        private Address address;
        private String name;
        private int age;

        public Person() {
            this.name = "anonimous";
            this.age = 0;
            this.address = null;
        }

        public Person(String name) {
            this.name = name;
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Person(String name, int age, Address address) {
            this.address = address;
            this.name = name;
            this.age = age;
        }


        @Override
        public String toString() {
            return "Person{" +
                    "address=" + address +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static class Address {
        private String street;
        private int number;

        public Address(String street, int number) {
            this.street = street;
            this.number = number;
        }

        @Override
        public String toString() {
            return "Address{" +
                    "street='" + street + '\'' +
                    ", number=" + number +
                    '}';
        }
    }
}

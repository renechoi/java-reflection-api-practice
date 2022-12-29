package gatewayAndWildCard;

import java.util.HashMap;
import java.util.Map;

public class practiceApi {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<String> stringClass = String.class;

        Map<String, Integer> mapObject = new HashMap<>();

        Class<?> hashMapClass = mapObject.getClass();

        Class<?> squareClass = Class.forName("gatewayAndWildCard.practiceApi$Square");

        printClassInfo(stringClass, hashMapClass, squareClass);
    }


    private static void printClassInfo(Class<?>... classes){


        for (Class<?> clazz : classes){
            System.out.printf("class name %s :", clazz.getSimpleName());
            System.out.printf("package name %s :", clazz.getPackageName());

            Class<?> [] implementedInterfaces = clazz.getInterfaces();

            for (Class<?> implementedInterface : implementedInterfaces){
                System.out.println(implementedInterface.getSimpleName());
            }
        }

    }

    private static class Square implements drawable{

        @Override
        public int getNumberOfCorners() {
            return 4;
        }
    }

    private static interface drawable{
        int getNumberOfCorners();
    }

    private enum Color{
        BLUE,
        RED,
        YELLOW
    }
}

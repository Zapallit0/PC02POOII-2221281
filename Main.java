import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Random n = new Random();
        int random=n.nextInt(100);

        List<Integer> randomNumbers = new java.util.ArrayList<>(IntStream.range(0, random)
                .mapToObj(i -> (int) (Math.random() * 50))
                .toList());

        randomNumbers.add(2);
        randomNumbers.add(2);
        System.out.println(randomNumbers);

        System.out.println("**************************************************************************");
        //1.Numeros pares
        randomNumbers.stream().filter(number -> number % 2 == 0).toList().forEach(System.out::println);


        System.out.println("**************************************************************************");
        //2.Numeros que comiencen por 5
        randomNumbers.stream().filter(number -> String.valueOf(number).startsWith("5")).forEach(System.out::println);


        System.out.println("*************************************************************************");
        //3.Imprimir los numeros que se duplican
        List<Integer> duplicates = randomNumbers.stream()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();

        duplicates.forEach(System.out::println);


        System.out.println("*************************************************************************");
        //4.Imprimir la cantidad de numeros en la lista
        System.out.println((long) randomNumbers.size());


        System.out.println("*************************************************************************");
        //5. Listas en orden descendente
        List<Integer> listaDescendente=randomNumbers.stream()
                .sorted((a, b) -> Integer.compare(b, a))
                .toList();
        System.out.println(listaDescendente);

        System.out.println("*************************************************************************");
        //6.devuelve true si algún valor aparece al menos tres veces en el array y devuelve falso si cada elemento es distinto.

        System.out.println("*************************************************************************");
        //7.Concatenar 2 arrays
        String[] A = {"1", "2", "3", "4", "5", "8", "23"};
        String[] B = {"4", "6", "8", "0", "2"};
        String[] AB= Stream.concat(Arrays.stream(A), Arrays.stream(B))
                .toArray(String[]::new);
        Arrays.stream(AB)
                .forEach(element -> System.out.print(element + " "));


        System.out.println("*************************************************************************");
        //8. Dado una lista de números enteros aleatorios, calcular el cubo de los números de   los elementos de lista y filtrar números mayores a 50.

        List<Integer> cubosMayoresA50 = randomNumbers.stream()
                .map(numero -> numero * numero * numero) // Calcula el cubo
                .filter(cubo -> cubo > 50) // Filtra los mayores a 50
                .collect(Collectors.toList());
        System.out.println(cubosMayoresA50);

        System.out.println("*************************************************************************");

        //9. ¿Cómo contabilizar el total de todos las palabras de un arreglo de cadena?


        System.out.println("*************************************************************************");

        //10.


        System.out.println("*************************************************************************");
        //11.¿Qué te devuelve el método findFirst() y findAny() y qué diferencias tiene?

        List<String> users = Arrays.asList("Amalia", "Jose", "Teresa", "Ana", "Daniel", "Alberto", "María");
        Optional<String> findFirst =
                users.parallelStream().filter(s ->
                        s.startsWith("A")).findFirst();
        Optional<String> findAny =
                users.parallelStream().filter(s ->
                        s.startsWith("A")).findAny();
        System.out.println(findAny);
        System.out.println(findFirst);

        System.out.println("*************************************************************************");
        //12. ¿Qué imprime los siguientes fragmentos de código y explique cuál es la diferencia entre map y flatmap?
        Map<String, List<String>> user = new HashMap<>();
        user.put("Carolina", Arrays.asList("051-922-977234",
                "051-998-92223"));
        user.put("Bertha", Arrays.asList("051-991-927204",
                "051-991-96263"));
        user.put("Marco", Arrays.asList("051-931-977003",
                "051-961-98861"));
        List<String> names = user.keySet().stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.print(names);
        List<String> phones = user.values().stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.println(phones);


        System.out.println("*************************************************************************");



    }
}

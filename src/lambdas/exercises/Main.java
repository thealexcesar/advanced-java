package lambdas.exercises;

import lambdas.exercises.domain.Person;
import lambdas.exercises.service.OperationService;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    private static final int AGE = 10;

    public static void main(String[] args) {
        OperationService service = new OperationService();

        List<Person> characters = Arrays.asList(
                new Person("Goku", 45, "Saiyan Warrior", "Dragon Ball Z"),
                new Person("Naruto Uzumaki", 17, "Ninja", "Naruto"),
                new Person("Luffy", 23, "Pirate", "One Piece"),
                new Person("Light Yagami", 17, "Student", "Death Note"),
                new Person("Edward Elric", 15, "Alchemist", "Fullmetal Alchemist"),
                new Person("Inuyasha", 200, "Half-Demon", "Inuyasha"),
                new Person("Saitama", 25, "Hero", "One Punch Man"),
                new Person("Kirito", 17, "Swordman", "Sword Art Online"),
                new Person("Dante", 30, "Demon Hunter", "Devil May Cry"),
                new Person("Cloud Strife", 21, "Mercenary", "Final Fantasy VII"),
                new Person("Link", 17, "Hero", "The Legend of Zelda"),
                new Person("Samus Aran", 30, "Bounty Hunter", "Metroid"),
                new Person("Geralt of Rivia", 35, "Witcher", "The Witcher"),
                new Person("Kratos", 40, "God of War", "God of War"),
                new Person("Jin Kazama", 21, "Fighter", "Tekken"),
                new Person("Ryu", 25, "Martial Artist", "Street Fighter")
        );

        List<String> names = characters.stream()
                .map(Person::getName)
                .collect(Collectors.toList());

        List<Integer> ages = characters.stream()
                .map(Person::getAge)
                .collect(Collectors.toList());

        Function<List<?>, String> listToStringFunction = list ->
                list.stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(", "));


        System.out.println("\nLista Geral:\n\u001B[32mNames: " + listToStringFunction.apply(names));
        System.out.println("Ages: " + listToStringFunction.apply(ages));
        System.out.println("\u001B[0m\n");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("[1] Filtrar idades pares");
            System.out.println("[2] Dobrar cada elemento");
            System.out.println("[3] Verificar se todos os elementos são maiores 10 anos");
            System.out.println("[4] Encontrar o maior idade");
            System.out.println("[5] Converter strings para maiúsculas");
            System.out.println("[6] Ordenar strings por comprimento");
            System.out.println("[7] Agrupar pessoas por idade");
            System.out.println("[8] Calcular a média das idades");
            System.out.println("[9] Remover elementos duplicados");
            System.out.println("[10] Combinar duas listas intercalando elementos");
            System.out.print("Digite o número da opção: ");

            int option = -1;
            boolean validInput = false;

            while (!validInput) {
                try {
                    option = scanner.nextInt();
                    validInput = true;
                } catch (InputMismatchException e) {
                    System.err.println("Entrada inválida. Por favor, digite um número inteiro.");
                    scanner.next();
                }
            }

            scanner.nextLine();

            switch (option) {
                case 1 -> System.out.println("Idades pares: " + service.filterEvenNumbers(ages));
                case 2 -> System.out.println("Idades dobradas: " + service.doubleElements(ages));
                case 3 -> System.out.println("Todos os personagens têm mais de "+AGE+" anos: " + service.areAllElementsGreaterThan(ages, AGE));
                case 4 -> service.findMax(ages).ifPresent(max -> System.out.println("Maior idade: " + max));
                case 5 -> System.out.println("Strings em maiúsculas: " + service.convertToUpperCase(names));
                case 6 -> System.out.println("Strings ordenadas por comprimento: " + service.sortByLength(names));
                case 7 -> System.out.println("Pessoas agrupadas por idade: " + service.groupPeopleByAge(characters));
                case 8 -> System.out.println("Média das idades: " + service.calculateAverage(ages));
                case 9 -> System.out.println("Idades distintas: " + service.removeDuplicates(ages));
                case 10 -> System.out.println("Listas combinadas: " + service.combineListsInterleaving(names, ages));
                default -> System.err.println("Opção inválida.");
            }
        }
    }
}

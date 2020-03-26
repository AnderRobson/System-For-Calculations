package codes;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        Scanner Input = new Scanner(System.in);
        User User;
        String validated;
        byte option;

        do {
            do {
                System.out.println("Login :");
                String login = Input.nextLine();

                System.out.println("Senha :");
                String password = Input.nextLine();

                User = new User();

                validated = User.validateLogin(login, password);

                System.out.println(validated);
            } while (!User.getSUCCESS().equals(validated));


            System.out.println("Digite um número :");
            int value = Input.nextInt();

            Number ClassNumber = new Number(value);
            do {
                System.out.println("1 – Visualizar o número digitado");
                System.out.println("2 – Alterar o número");
                System.out.println("3 – Visualizar Fatorial do número");
                System.out.println("4 – Visualizar somatório do número");
                System.out.println("5 – Visualizar quantidade de múltiplos do número");
                System.out.println("6 – Ver se o número é primo");
                System.out.println("7 – Deslogar");
                System.out.println("0 - Sair");

                option = Input.nextByte();

                switch (option) {
                    case 1:
                        value = ClassNumber.getValue();
                        System.out.println("O número digitado foi : " + value);
                        break;
                    case 2:
                        System.out.println("Digite o novo número : ");
                        ClassNumber.setValue(Input.nextInt());
                        value = ClassNumber.getValue();
                        System.out.println("O novo número digitado foi : " + value);
                        break;
                    case 3:
                        value = ClassNumber.calculateFactorial();
                        System.out.println("O fatorial do número é : " + value);
                        break;
                    case 4:
                        value = ClassNumber.calculateSum();
                        System.out.println("A somatória do número é : " + value);
                        break;
                    case 5:
                        value = ClassNumber.calculateMultiples();
                        System.out.println("A somatória dos multiplos do número é : " + value);
                        break;
                    case 6:
                        String text = ClassNumber.verifyIfAndCousin();
                        System.out.println("O número é : " + text);
                        break;
                    case 7:
                        System.out.println("Deslogado !");
                    case 0:
                        break;
                    default:
                        System.out.println("Opção invalida !");
                }
            } while (option != 7 && option != 0);

//            Limpando enter do ultimo nextByte()
            Input.nextLine();
        } while (option != 0);

        System.out.print("Até mais !");
    }
}

package p03_BankAccount;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        LinkedHashMap<Integer, BankAccount> bank = new LinkedHashMap<>();

        while (!command.equals("End")) {
            String[] tokens = command.split("\\s+");

            switch (tokens[0]) {
                case "Create":
                    BankAccount account = new BankAccount();
                    bank.put(account.getId(), account);
                    System.out.printf("Account ID%d created%n", account.getId());
                    break;
                case "Deposit":
                    int id = Integer.parseInt(tokens[1]);
                    int amount = Integer.parseInt(tokens[2]);

                    if (bank.containsKey(id)) {
                        account = bank.get(id);
                        account.deposit(amount);
                        System.out.println("Deposited " + amount + " to ID" + id);
                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;
                case "SetInterest":
                    double interest = Double.parseDouble(tokens[1]);
                    BankAccount.setInterestRate(interest);
                    break;
                case "GetInterest":
                    id = Integer.parseInt(tokens[1]);

                    if (bank.containsKey(id)) {
                        account = bank.get(id);
                        int years = Integer.parseInt(tokens[2]);

                        System.out.printf("%.2f%n", account.getInterestRate(years));
                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;
            }

            command = scanner.nextLine();
        }
    }
}
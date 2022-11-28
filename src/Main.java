import java.util.Scanner;

class Main {
        public static int taxEarningsMinusSpendings(int earnings, int spendings) {
            int tax = (earnings - spendings) * 15 / 100;
            if (tax >= 0) {
                return tax;
            } else {

                return 0;
            }
        }
        public static int taxEarnings (int spendings){
            int tax = spendings * 6 / 100;
            if (tax >= 0) {
                return tax;
            }else {
                return 0;
            }
        }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int earnings = 0;    // доходы
        int spendings = 0;   // расходы

        while (true) {
            System.out.println("Выберите операцию и введите её номер:");
            System.out.println("1. Добавить новый доход");
            System.out.println("2 Добавить новый расход");
            System.out.println("3. Выбрать ситему налогооблажения");

            String input = scanner.nextLine();
            if (input.equals("end")) {
                System.out.println("ОТЧЕТ");
                System.out.println("ваш доход составил: " + earnings);
                System.out.println("ваш расход составил: " + spendings);
                System.out.println("налог по первой системе составил: " + taxEarnings(earnings));
                int tax6 = taxEarnings(earnings);
                System.out.println("налог по второй системе: " + taxEarningsMinusSpendings(earnings, spendings));
                int tax15 = taxEarningsMinusSpendings(earnings, spendings);
                int income1 = earnings - spendings - tax6;
                int income2 = earnings - tax15 - spendings;
                if(income1 > income2){
                    System.out.println("выгодная система обложения №1 " + "(" +income1 + ")");
                }else {
                    System.out.println("выгодная систем обложения №2 " + "(" + income2 + ")");
                }
                break;
            } else {
                int operation = Integer.parseInt(input);
                switch (operation) {
                    case 1:
                        System.out.println("Введите сумму дохода:");
                        String moneyStr = scanner.nextLine(); // Не используйте тут nextInt (!)
                        int money = Integer.parseInt(moneyStr);
                        earnings += money;
                        System.out.println("ваш доход " + earnings);
                        break;
                    case 2:
                        System.out.println("введите сумму расходов:");
                        String moneySpn = scanner.nextLine();
                        int spend = Integer.parseInt(moneySpn);
                        spendings += spend;
                        System.out.println("ваш расход состовлят: " + spendings);
                        break;
                    case 3:
                        System.out.println("Выберите операцию и введите её номер:");
                        System.out.println("1 налог 6% от дохода");
                        System.out.println("2 налог 15% от доходов и расходов");
                        String operation2 = scanner.nextLine();
                        int operationTax = Integer.parseInt(operation2);
                        if (operationTax == 1) {
                            int tax6 = taxEarnings(earnings);
                            System.out.println(tax6);
                        } else if (operationTax == 2) {
                            int tax15 = taxEarningsMinusSpendings(earnings, spendings);
                            System.out.println(tax15);
                        } else {
                            System.out.println("нет такой команды");
                        }
                        break;
                    default:
                        System.out.println("нет такой команды");
                }

            }
        }
    }
}

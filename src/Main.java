import java.util.Scanner;
import java.util.function.DoubleFunction;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Newton();
        input.close();
    }

    static void Newton(){
        DoubleFunction<Double> fun;
        DoubleFunction<Double> funDeriv;

        while(true){
            System.out.println("Wybierz przykład:");
            System.out.println("1) f(x) = x^2 - 21");
            System.out.println("2) f(x) = e^x(x^2 - 21)");
            System.out.println("3) f(x) = x^3 + x + 1");
            System.out.println("4) f(x) = x^2 + 2");
            System.out.println("x) end");

            Scanner input = new Scanner(System.in);
            String s = input.next();

            switch (s) {
                case "1":
                    fun = (x) -> x * x - 21;
                    funDeriv = (x) -> 2 * x;
                    break;
                case "2":
                    fun = (x) -> Math.exp(x) * (x * x - 21);
                    funDeriv = (x) -> Math.exp(x) * (x * x + 2*x - 21);
                    break;
                case "3":
                    fun = (x) -> x * x * x + x + 1;
                    funDeriv = (x) -> 3 * x * x + 1;
                    break;
                case "4":
                    fun = (x) -> x * x + 2;
                    funDeriv = (x) -> 2 * x;
                    break;
                case "x":
                    System.exit(0);
                default:
                    System.out.println("Podaj jeszcze raz: \n");
                    continue;
            }

            System.out.println("Podaj wartości pierwszego przybliżenia x0: ");
            double x0 = input.nextDouble();

            while(funDeriv.apply(x0) == 0){
                System.out.println("Podaj prawidlowe przyblizenie:");
                x0 = input.nextDouble();
            }

            System.out.println("Dokładność (epsilon > 0):");
            double epsilon = input.nextDouble();
            while(epsilon <= 0){
                System.out.println("Podaj prawidlową dokładność:");
                epsilon = input.nextDouble();
            }


            int n = 0;
            double x1;

            while(Math.abs(fun.apply(x0)) > epsilon){
                if(funDeriv.apply(x0) == 0){
                    System.out.println("Wartosc pochodnej równa 0.");
                    break;
                }

                x1 = x0 - fun.apply(x0) / funDeriv.apply(x0);
                x0 = x1;
                n++;

                if(n == 32){
                    System.out.println("Nie udalo sie znalezc rozwiazania w 32 krokach.");
                    System.exit(0);
                }
            }

            System.out.println(n + ": " + x0 + "\n");
        }
    }
}

import java.util.Scanner;

/**
 *
 * @author Eren Çetinkaya Cruz
 */
public class IkinciDereceDenkleminKokunuBulma {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("(ax²+bx+c) olmak üzere a, b ve c sıralanacak şekilde sayıları ekrana giriniz.");
        System.out.println("a sayısını giriniz.");
        double a = sc.nextInt();

        System.out.println("b sayısını giriniz.");
        double b = sc.nextInt();

        System.out.println("c sayısını giriniz.");
        double c = sc.nextInt();

        double delta = (b * b) - (4 * a * c);

        if (delta > 0) {
            double x1 = ((-1 * b) - Math.sqrt(delta)) / (2 * a);
            double x2 = ((-1 * b) + Math.sqrt(delta)) / (2 * a);
            System.out.println("x1=  " + x1 + "  x2=  " + x2);
        }

        if (delta < 0) {
            System.out.println("Denklemin Gerçel Kökü Yoktur.");
        }

        if (delta == 0) {
            double x = (-1 * b) / (2 * a);
            System.out.println("Çakışık kökü var x1= x2=  " + x);
        }

    }
}

import java.util.*;

public class Main
{
    public static void main(String args[])
    {
        Scanner _sc = new Scanner(System.in);
        int a;
        int b;
        double c;
        int d;
        String waowMyString;
        String testString2;
        waowMyString = "helloioii";
        a = 1;
        b = 2;
        c = _sc.nextDouble();
        _sc.nextLine();
        testString2 = "helloioiiasdasd";
        System.out.println(a);
        if (b > 5)
        {
            System.out.println(b);
            if (b == 3)
            {
                System.out.println("b igual a 3");
                if (b + 1 == 4)
                {
                    System.out.println("b igual a 4");
                }

            }

        }

        do
        {
            System.out.println(b);
            b = b + 5 * 3;
        } while (b < 50);

        System.out.println("oi aqui esta o valor da soma");
        System.out.println(b);
        c = 20.0;
        while (c <= 111.11)
        {
            System.out.println("legal");
            if (c > 112.0)
            {
                System.out.println("passou parando");
                break;

            }

            c = c + 15.9;
        }


    }
}

import java.util.*; 
public class Main { 
	public static void main(String args[]) {
		Scanner _sc = new Scanner(System.in);
		int a;
		int b;
		double c;
		int d;
		String waowMyString;
		String testString2;
		waowMyString = "helloioii";
		a = 2;
		b = 1+2*3/a;
		System.out.println("a variavel b vale ");
		System.out.println(b);
		c = _sc.nextDouble(); _sc.nextLine();
		System.out.println(a);
		if (b!=5) {
System.out.println(b);
if (b==4) {
System.out.println("b igual a 4");
if (b+1==5) {
System.out.println("b mais um fica igual a 5");
}

}

}
else {
System.out.println("b nao vale 5");
}

		do {
System.out.println(b);
b = b+5*3;
}while (b<50);

		System.out.println("oi aqui esta o valor da soma");
		System.out.println(b);
		c = 20.0;
		while (c<=111.11) {
System.out.println("legal");
if (c>112.0) {
System.out.println("passou parando");
break;

}

c = c+15.9;
}

		_sc.close();

	}
}

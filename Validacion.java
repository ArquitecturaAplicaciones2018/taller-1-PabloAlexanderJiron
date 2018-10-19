package ec.edu.utpl.arqapl.rational;
import java.util.List;//Paquete para Lista de numeros
import java.util.stream.Collectors;
public class Validacion {
    public static void main(String[] args) {
        var rationals = List.of(
                new Rational(1, 4),
                new Rational(1, 8),
                new Rational(3, 4),
                new Rational(7, 8));
        //Imperativo
        var unMedio = new Rational(1, 2);//se da los valores racionales para comparar
        //for(Rational r : rationals){
         //   if(r.isLessThan(unMedio)){
         //       System.out.println(r);
        //    }
    //    }
        System.out.println(" FRACCIONES MAYORES A 1/2 ");
        rationals.stream()
                .filter(r -> r.isLessThan(new Rational(1, 2))).
                forEach(System.out::println);
        //--------------------------------------------------------------------------------

        System.out.println("SUMA FRACCIONES");
        Rational suma = rationals.
                stream().
                reduce(new Rational(0, 1),
                        (a, b) -> a.plus(b));
        System.out.println(suma);
        //--------------------------------------------------------------------------------

        System.out.println("FRACCION MAYOR");
        Rational rmayor =rationals.stream()
                .reduce(unMedio,(a,b) -> a.getGreater(b));
        System.out.println(rmayor);
        //--------------------------------------------------------------------------------

        System.out.println("SUMA DE NUMERADORES");
        int sumaNumeradores = rationals.
                stream().
                mapToInt(Rational::getNumerator).
                sum();
        System.out.println(sumaNumeradores);
        //--------------------------------------------------------------------------------

        System.out.println("VALORES DE LOS NUMERADORES");
        List<Integer> numeradores = rationals.
                stream().
                mapToInt(Rational::getNumerator).
                boxed().
                collect(Collectors.toList());
        System.out.println(numeradores);
        //-------------------------------------------------------------------------------

        System.out.println("NUMERO MAYOR Y MENOR");
        int mayor;
        int menor;
        mayor = rationals.
                stream().
                mapToInt(Rational::getNumerator).
                max().
                getAsInt();
        menor = rationals.
                stream().
                mapToInt(Rational::getNumerator).
                min().
                getAsInt();

        System.out.printf("NUMERADOR MAYOR = %d, NUMERADOR MENOR = %d\n",
                mayor,
                menor);
        //--------------------------------------------------------------------------------
        System.out.println("PROMEDIO DE NUMERADORES");
        double promNume = rationals.
                stream().
                mapToInt(Rational::getNumerator).
                average().
                getAsDouble();
        System.out.println(promNume);
    }
}

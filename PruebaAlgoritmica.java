import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class PruebaAlgoritmica {

    public static void main(String args[]) {
        for (int i = 0; i < 4; i+=2) {
            System.out.println(i);
        }
        System.out.println(i);

        Scanner scan = new Scanner(System.in);
        System.out.println("Escoja el ejercicio para ejecutar");
        System.out.println("1.ParOImpar");
        System.out.println("2.Personas");
        System.out.println("3.Horas Trabajadas");

        switch (scan.nextInt()) {
            case 1:
                System.out.println("LEER NUMERO:");
                int numero = scan.nextInt();

                boolean par = false;
                if (numero%2==0) {
                    par = true;
                    numero--;
                }
                
                while (numero != 0) {
                    if (!par && numero%2!=0) {
                        System.out.println(numero);
                    } else if (par && numero%2==0) {
                        System.out.println(numero);
                    }
                    numero--;
                }
                break;
            case 2:

                class Persona {
                    String sexo;
                    int edad; 
                    Persona(String sexo, int edad) {
                        this.sexo = sexo;
                        this.edad = edad;
                    }

                    public int getEdad() {
                        return edad;
                    }

                    public String getSexo() {
                        return sexo;
                    }
                }

                Vector<Persona> personas = new Vector<Persona>(50);

                for (int i = 0; i < 50; i++) {
                    int edadAleatoria = (int)Math.floor(Math.random() * (100 - 1 + 1) + 1);
                    String sexoAleatorio = (int)Math.floor(Math.random() * (1 - 0 + 1) + 0) == 1 ? "Hombre" : "Mujer" ;
                    Persona p = new Persona(sexoAleatorio,edadAleatoria);
                    personas.add(p);
                    System.out.println(p.getEdad() + " " + p.getSexo());
                }

                System.out.println("Mayores de edad:" + personas.stream().filter(p -> p.getEdad() >= 18).count());
                System.out.println("Menores de edad:" + personas.stream().filter(p -> p.getEdad() < 18).count());
                System.out.println("Hombres mayores de edad:" + personas.stream().filter(p -> p.getEdad() >= 18 && p.getSexo() == "Hombre").count());
                System.out.println("Mujeres mayores de edad:" + personas.stream().filter(p -> p.getEdad() >= 18 && p.getSexo() == "Mujer").count());
                System.out.println("Porcentaje de mayores de edad en la muestra:" + (Double.valueOf(personas.stream().filter(p -> p.getEdad() >= 18).count())/50)*100 + "%");
                System.out.println("Porcentaje de mujeres en la muestra:" + (Double.valueOf(personas.stream().filter(p -> p.getSexo() == "Mujer").count())/50)*100 + "%");

                break;
            case 3:
                System.out.println("HORAS TRABAJADAS:");
                int horasTrabajadas = scan.nextInt();
                System.out.println("TARIFA:");
                int tarifa = scan.nextInt();

                if (horasTrabajadas > 40) {
                    tarifa = (tarifa/2) + tarifa;
                }
                
                System.out.println("Sueldo:" + " " + horasTrabajadas * tarifa);

                break;
        }
    }
}

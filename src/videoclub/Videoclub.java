/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videoclub;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author infor04
 */
public class Videoclub {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        ArrayList<Pelicula> listaPeliculas = new ArrayList<>();

        //Incializar la lista de Peliculas para pruebas (con 2 películas y 2999 copias en total)
        Pelicula P = new Pelicula("El Padrino I", "Francis Ford Coppola", "Drama", "1972", "180", 2000);
        listaPeliculas.add(P);
        P = new Pelicula("El Padrino II", "Francis Ford Coppola", "Drama", "1974", "190", 999);
        listaPeliculas.add(P);

        boolean salir = false;

        while (!salir) {
            System.out.println("=========================");
            System.out.println("=        M E N Ú        =");
            System.out.println("=========================");
            System.out.println(" 1 - Añadir película");
            System.out.println(" 2 - Reservar película");
            System.out.println(" 3 - Buscar película");
            System.out.println(" 4 - Salir");
            System.out.println("=========================");

            switch (pedirOpcion()) {
                case 1: {
                    /*Añadir película*/
                    anadirPelicula(listaPeliculas);
                    break;
                }
                case 2: {
                    /*Reservar película*/
                    reservarPelicula(listaPeliculas);
                    break;
                }
                case 3: {
                    /*Buscar película*/
                    buscarPelicula(listaPeliculas);
                    break;
                }
                case 4: {
                    salir = true;
                    break;
                }
                default: {
                    System.out.println("Opción no válida");
                    break;
                }
            }
        }

    }

    public static int pedirOpcion() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Introduce la opción que deseas:");
        return leer.nextInt();
    }

    public static String pedirBusqueda() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Introduce el texto a buscar:");
        return leer.next();
    }

    public static void anadirPelicula(ArrayList<Pelicula> lista) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Introduce la cantidad de copias a introducir");
        int c = leer.nextInt();
        if (c + Pelicula.total <= Pelicula.TOTAL_MAX) {
            Pelicula.total = Pelicula.total + c;
            System.out.println("Introduce el título de la película: ");
            String tit = leer.next();
            System.out.println("Introduce el nombre del director: ");
            String dir = leer.next();
            System.out.println("Introduce el género de la peli: ");
            String gen = leer.next();
            System.out.println("Introduce el año de estreno de la peli: ");
            String a = leer.next();
            System.out.println("Introduce la duración de la peli: ");
            String dur = leer.next();
            Pelicula P = new Pelicula(tit, dir, dur, gen, a, c);
            lista.add(P);
            P.imprimirPelicula();
        } else {
            System.out.println("No cabe esa cantidad de copias");
        }
    }

    public static void reservarPelicula(ArrayList<Pelicula> lista) {
        Scanner leer = new Scanner(System.in);
        listarPeliculas(lista);
        System.out.println("Introduce el ID de la películas que quieres reservar: ");
        int id = leer.nextInt() - 1;
        if (id < lista.size()) {
            if (lista.get(id).isDisponibilidad()) {
                lista.get(id).setReservas(1); //aoumenta en 1 las reservas
                if (lista.get(id).getReservas() == lista.get(id).getCopias()) {
                    lista.get(id).setDisponibilidad(false);
                }
                System.out.println("Película reservada");
            } else {
                System.out.println("Película no disponible");
            }
        } else {
            System.out.println("No existe ese ID");
        }
    }

    public static void listarPeliculas(ArrayList<Pelicula> lista) {
        System.out.println("============================");
        System.out.println("     Lista de Películas     ");
        System.out.println("============================");
        for (int i = 0; i < lista.size(); i++) {
            lista.get(i).imprimirPelicula();
        }
    }

    public static void buscarPelicula(ArrayList<Pelicula> lista) {
        boolean encontrado = false;
        System.out.println("=========================");
        System.out.println("=     B U S C A R       =");
        System.out.println("=========================");
        System.out.println(" 1 - por título");
        System.out.println(" 2 - por director");
        System.out.println(" 3 - por género");
        System.out.println(" 4 - por año");
        System.out.println(" 5 - por duración");
        System.out.println("=========================");
        int opcion = pedirOpcion();
        String busqueda = pedirBusqueda().toLowerCase();

        // búsqueda parametrizada
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getBusqueda(opcion).contains(busqueda)) {
                lista.get(i).imprimirPelicula();
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontrado nada");
        }
    }
}

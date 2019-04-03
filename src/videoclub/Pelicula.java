/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videoclub;

/**
 *
 * @author infor04
 */
public class Pelicula {

    // Atributos
    private static int ultimo_id = 1;
    public static final int TOTAL_MAX = 3000;
    public static int total = 0;

    private int id;
    private String titulo;
    private String director;
    private String duracion;
    private String genero;
    private String ano; //año
    private boolean disponibilidad;
    private int copias;
    private int reservas;

    //Constructores
    public Pelicula() {
    }

    public Pelicula(String titulo, String director, String duracion, String genero,
            String ano, int copias) {
        this.id = ultimo_id++;
        this.titulo = titulo;
        this.director = director;
        this.duracion = duracion;
        this.genero = genero;
        this.ano = ano;
        this.disponibilidad = true;
        this.copias = copias;
        this.reservas = 0;
    }

    public Pelicula(Pelicula P1) {
        this.titulo = P1.titulo;
        this.director = P1.director;
        this.duracion = P1.duracion;
        this.genero = P1.genero;
        this.ano = P1.ano;
        this.disponibilidad = P1.disponibilidad;
        this.copias = P1.copias;
        this.reservas = P1.reservas;
    }

    //Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public int getCopias() {
        return copias;
    }

    public void setCopias(int copias) {
        this.copias = copias;
    }

    public int getReservas() {
        return reservas;
    }

    public void setReservas(int reservas) {
        this.reservas += reservas;
    }

    // Métodos
    public void imprimirPelicula() {
        System.out.print("ID: " + this.id + ", ");
        System.out.print("Título: " + this.titulo + ", ");
        System.out.print("Director: " + this.director + ", ");
        System.out.print("Género: " + this.genero + ", ");
        System.out.print("Año: " + this.ano + ", ");
        System.out.print("Duración: " + this.duracion + " minutos, ");
        if (this.disponibilidad) {
            System.out.print("Estado: Disponible");
        } else {
            System.out.print("Estado: No disponible");
        }
        System.out.println();
    }

    public String getBusqueda(int opcion) {
        String busqueda;
        switch (opcion) {
            case 1: {
                // por título
                busqueda = this.titulo;
                break;
            }
            case 2: {
                //por director
                busqueda = this.director;
                break;
            }
            case 3: {
                //por género
                busqueda = getGenero();
                break;
            }
            case 4: {
                //por año
                busqueda = getAno();
                break;
            }
            case 5: {
                //por duración
                busqueda = getDuracion();
                break;
            }
            default: {
                System.out.println("Opción no válida");
                busqueda = "";
                break;
            }
        }
        return busqueda.toLowerCase();
    }

}

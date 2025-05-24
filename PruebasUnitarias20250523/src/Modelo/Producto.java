package Modelo;

public class Producto {
    /**
     * Nombre del producto
     */
    private String nombre;
    /**
     * Precio del producto
     */
    private int precio;
    /**
     * DescripciÃ³n del producto
     */
    private String descripcion;
    /**
     * Numero de unidades en el almacÃ©n
     */
    private int numeroDeUnidadesEnAlmacen = 0;

    public Producto(String nombre, int precio, String descripcion) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return nombre;
    }

    public void setNumeroDeUnidadesEnAlmacen(int numeroDeUnidadesEnAlmacen) {
        this.numeroDeUnidadesEnAlmacen = numeroDeUnidadesEnAlmacen;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean esMasCaro(Producto producto2) {
        return this.precio > producto2.precio;
    }

    public void quitarUnidadDeAlmacen() {
        numeroDeUnidadesEnAlmacen = numeroDeUnidadesEnAlmacen - 1;
    }

    public void anhadirUnidadAlAlmacen() {
        numeroDeUnidadesEnAlmacen = numeroDeUnidadesEnAlmacen + 1;
    }

    public int getNumeroDeUnidadesEnAlmacen() {
        return numeroDeUnidadesEnAlmacen;
    }

}
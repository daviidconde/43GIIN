package Modelo.Test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Modelo.CarroDeLaCompra;
import Modelo.Producto;

public class CarritoTests {
    static Producto producto1, producto2;
    static CarroDeLaCompra carro;

    @BeforeClass
    public static void beforeClass() {
        producto1 = new Producto("Samsung Galaxy", 500, "Version 6");
        producto2 = new Producto("Iphone", 1000, "Version 15");
        carro = new CarroDeLaCompra();
    }

    @Before
    public void setUp() {
        System.out.println("before");
    }

    @Test
    public void testAnhadirProductoAlCarro() {
        assertEquals("Comprobamos el carro de la compra esta vacio ", CarroDeLaCompra.ESTADO.VACIO, carro.getEstado());
        assertEquals("Comprobamos el precio del carro tras incorporar el Samsung Galaxy", 0, carro.getTotal());

        carro.anhadirProductoAlCarrro(producto1);
        assertEquals("Comprobamos el precio del carro tras incorporar el Samsung Galaxy", 500, carro.getTotal());

        carro.anhadirProductoAlCarrro(producto2);
        assertEquals("Comprobamos el precio del carro tras incorporar el Iphone", 1500, carro.getTotal());

        assertEquals("Comprobamos que el carro esta preparado", CarroDeLaCompra.ESTADO.PREPARADO, carro.getEstado());
    }

    @After
    public void tearDown() {
        System.out.println("After tearDown()");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("afterClass()");
    }

    /** Pruebas David Rodríguez Conde */
    @Test
    public void testCambioDeEstadoACarroPreparado() {
        CarroDeLaCompra carro = new CarroDeLaCompra();
        Producto p = new Producto("Teclado Logitech", 30, "Gaming");

        assertEquals(CarroDeLaCompra.ESTADO.VACIO, carro.getEstado());

        carro.anhadirProductoAlCarrro(p);
        assertEquals(CarroDeLaCompra.ESTADO.PREPARADO, carro.getEstado());
    }

    @Test
    public void testQuitarProductoYActualizarTotal() {
        CarroDeLaCompra carro = new CarroDeLaCompra();
        Producto p = new Producto("Raton UPI", 40, "Inalámbrico");
        carro.anhadirProductoAlCarrro(p);

        carro.quitarProductoDelCarrro(0, 40);
        assertEquals(0, carro.getTotal());
    }

}
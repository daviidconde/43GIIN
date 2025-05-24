package Modelo.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Modelo.CarroDeLaCompra;
import Modelo.Producto;

public class ProductoTest {
    static Producto producto1;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("beforeClass()");
        producto1 = new Producto("Samsung Galaxy", 300, "versuion 6");
        assertEquals("Comprobamos el numero de unidades para este producto", 0,
                producto1.getNumeroDeUnidadesEnAlmacen());
        for (int i = 0; i < 10; i++) {
            producto1.anhadirUnidadAlAlmacen();
        }
        assertEquals("Comprobamos el numero de unidades para este producto", 10,
                producto1.getNumeroDeUnidadesEnAlmacen());
    }

    @Before
    public void setUp() {
        System.out.println("before");
        producto1.quitarUnidadDeAlmacen();
    }

    @Test
    public void testQuitarUnidadDelAlmacen() {
        assertEquals("Comprobamos el numero de unidades para este producto", 9,
                producto1.getNumeroDeUnidadesEnAlmacen());
    }

    @After
    public void tearDown() {
        System.out.println("After tearDown()");
        producto1.anhadirUnidadAlAlmacen();
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("afterClass()");
        for (int i = 0; i < 10; i++) {
            producto1.quitarUnidadDeAlmacen();
        }
        assertEquals("Comprobamos el numero de unidades para este producto", 0,
                producto1.getNumeroDeUnidadesEnAlmacen());
    }


    /** Pruebas David Rodríguez Conde */
    @Test
    public void testSetYGetDescripcion() {
        Producto producto = new Producto("Impresora Samsung Xpress", 150, "Inicial");
        producto.setDescripcion("Impresora multifunción láser");

        assertEquals("Impresora multifunción láser", producto.getDescripcion());
    }

    @Test
    public void testQuitarUnidadCuandoAlmacenVacio() {
        Producto producto = new Producto("Disco externo", 80, "USB 3.0");

        producto.quitarUnidadDeAlmacen();  // Debería quedar en -1, lo cual es incorrecto
        assertTrue("El almacén no debería tener unidades negativas", 
                producto.getNumeroDeUnidadesEnAlmacen() >= 0);
    }

    @Test
    public void testMultiplesUnidades() {
        Producto producto = new Producto("Webcam Sony", 60, "Full HD");

        for (int i = 0; i < 7; i++) {
            producto.anhadirUnidadAlAlmacen();
        }

        assertEquals(7, producto.getNumeroDeUnidadesEnAlmacen());
    }
}
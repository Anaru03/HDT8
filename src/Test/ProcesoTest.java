package Test;

import Model.Proceso;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProcesoTest {

    @Test
    public void testCompareTo() {
        // Crea dos objetos Proceso con valores PR diferentes
        Proceso p1 = new Proceso("proceso1", "usuario1", 10);
        Proceso p2 = new Proceso("proceso2", "usuario2", 5);

        // Comprueba que p1 es mayor que p2 (porque tiene un valor PR más alto)
        assertTrue(p1.compareTo(p2) > 0);

        // Comprueba que p2 es menor que p1 (porque tiene un valor PR más bajo)
        assertTrue(p2.compareTo(p1) < 0);

        // Crea dos objetos Proceso con el mismo valor PR
        Proceso p3 = new Proceso("proceso3", "usuario3", 8);
        Proceso p4 = new Proceso("proceso4", "usuario4", 2);
        p3.setPR(p4.getPR()); // Establece los valores PR como iguales

        // Comprueba que p3 y p4 son iguales (porque tienen el mismo valor PR)
        assertTrue(p3.compareTo(p4) == 0);
        assertTrue(p4.compareTo(p3) == 0);
    }
}

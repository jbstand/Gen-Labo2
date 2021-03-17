package ch.heigvd.deuxentiers;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DeuxEntiersTest {
    @Test
    void divise() {
        DeuxEntiers septTrois = new DeuxEntiers(7, 3);
        assertEquals(2, septTrois.divise());
    }

    @Test
    void modulo() {
        DeuxEntiers septTrois = new DeuxEntiers(7, 3);
        assertEquals(1, septTrois.modulo());
    }

    @Test
    void diviseParZero() {
        DeuxEntiers septZero = new DeuxEntiers(7, 0);
        assertThrows(ArithmeticException.class, () -> septZero.divise());
    }
}

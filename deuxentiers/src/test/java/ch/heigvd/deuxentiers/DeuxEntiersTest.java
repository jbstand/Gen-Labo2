package ch.heigvd.deuxentiers;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DeuxEntiersTest {
    @Test
    void divise() {
        DeuxEntiers septTrois = new DeuxEntiers(7, 3);
        assertEquals(2, septTrois.divise());
    }
}

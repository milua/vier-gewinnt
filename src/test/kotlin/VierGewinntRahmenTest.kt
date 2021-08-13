import viergewinnt.Farbe
import viergewinnt.Spalte
import viergewinnt.VierGewinntRahmen
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class VierGewinntRahmenTest {
    @Test
    fun givenLeererRahmen_whenDreiGelbeSteineUebereinander_thenSpielUnentschieden() {
        // Arrange
        var vierGewinntRahmenUnderTest: VierGewinntRahmen = VierGewinntRahmen()

        // Act
        vierGewinntRahmenUnderTest.einsetzen(Spalte.EINS, Farbe.GELB)
        vierGewinntRahmenUnderTest.einsetzen(Spalte.EINS, Farbe.GELB)
        vierGewinntRahmenUnderTest.einsetzen(Spalte.EINS, Farbe.GELB)

        // Assert
        assertFalse(vierGewinntRahmenUnderTest.isVierSteineUebereinander(Spalte.EINS))
    }

    @Test
    fun givenLeererRahmen_whenVierGelbeSteineUebereinander() {
        // Arrange
        var vierGewinntRahmenUnderTest: VierGewinntRahmen = VierGewinntRahmen()
        vierGewinntRahmenUnderTest.einsetzen(Spalte.EINS, Farbe.GELB)
        vierGewinntRahmenUnderTest.einsetzen(Spalte.EINS, Farbe.GELB)
        vierGewinntRahmenUnderTest.einsetzen(Spalte.EINS, Farbe.GELB)

        //Act
        vierGewinntRahmenUnderTest.einsetzen(Spalte.EINS, Farbe.GELB)

        // Assert
        assertTrue(vierGewinntRahmenUnderTest.isVierSteineUebereinander(Spalte.EINS))
    }

    @Test
    fun isVierDiagonal_returnTrue() {
        // Arrange
        var vierGewinntRahmenUnderTest: VierGewinntRahmen = VierGewinntRahmen()
        /* 1 */
        vierGewinntRahmenUnderTest.einsetzen(Spalte.EINS, Farbe.GELB)
        /* 2 */
        vierGewinntRahmenUnderTest.einsetzen(Spalte.ZWEI, Farbe.ROT)
        vierGewinntRahmenUnderTest.einsetzen(Spalte.ZWEI, Farbe.GELB)
        /* 3 */
        vierGewinntRahmenUnderTest.einsetzen(Spalte.DREI, Farbe.ROT)
        vierGewinntRahmenUnderTest.einsetzen(Spalte.DREI, Farbe.ROT)
        vierGewinntRahmenUnderTest.einsetzen(Spalte.DREI, Farbe.GELB)
        /* 4 */
        vierGewinntRahmenUnderTest.einsetzen(Spalte.VIER, Farbe.ROT)
        vierGewinntRahmenUnderTest.einsetzen(Spalte.VIER, Farbe.ROT)
        vierGewinntRahmenUnderTest.einsetzen(Spalte.VIER, Farbe.ROT)

        // Act
        vierGewinntRahmenUnderTest.einsetzen(Spalte.VIER, Farbe.GELB)

        //Assert
        assertTrue(vierGewinntRahmenUnderTest.isVierDiagonal(Spalte.VIER))
    }

    @Test
    fun setZuletztEingefuegtePositionCorrectly() {
        // Arrange
        var vierGewinntRahmenUnderTest: VierGewinntRahmen = VierGewinntRahmen()

        // Act
        vierGewinntRahmenUnderTest.einsetzen(Spalte.VIER, Farbe.GELB)

        // Assert
        assertEquals(vierGewinntRahmenUnderTest.zuletztEingefuegtePosition, Pair(3, 0))
    }

    @Test
    fun einsetzen_whenEinsetzenInSpalte_thenFarbeIstInRahmen() {
        // Arrange
        var vierGewinntRahmenUnderTest: VierGewinntRahmen = VierGewinntRahmen()

        // Act
        vierGewinntRahmenUnderTest.einsetzen(Spalte.EINS, Farbe.GELB)

        // Assert
        assertEquals(vierGewinntRahmenUnderTest.rahmen[0][0], Farbe.GELB);
    }

    @Test
    fun isSpalteGefuellt_whenLeereSpalte_thenReturnTrue() {
        // Arrange
        var vierGewinntRahmenUnderTest: VierGewinntRahmen = VierGewinntRahmen()

        // Act
        val gefuellt = vierGewinntRahmenUnderTest.isSpalteGefuellt(Spalte.EINS)

        // Assert
        assertFalse(gefuellt);
    }

    @Test
    fun isSpalteGefuellt_whenSpalteFastGefuellt_thenReturnTrue() {
        // Arrange
        var vierGewinntRahmenUnderTest: VierGewinntRahmen = VierGewinntRahmen()
        vierGewinntRahmenUnderTest.einsetzen(Spalte.EINS, Farbe.ROT)
        vierGewinntRahmenUnderTest.einsetzen(Spalte.EINS, Farbe.GELB)
        vierGewinntRahmenUnderTest.einsetzen(Spalte.EINS, Farbe.GELB)
        vierGewinntRahmenUnderTest.einsetzen(Spalte.EINS, Farbe.GELB)
        vierGewinntRahmenUnderTest.einsetzen(Spalte.EINS, Farbe.GELB)

        // Act
        val gefuellt = vierGewinntRahmenUnderTest.isSpalteGefuellt(Spalte.EINS)

        // Assert
        assertFalse(gefuellt);
    }

    @Test
    fun whenEinsetzenBereitsGefuellteSpalte_thenReturnTrue() {
        // Arrange
        var vierGewinntRahmenUnderTest: VierGewinntRahmen = VierGewinntRahmen()
        // füllt Spalte voll
        vierGewinntRahmenUnderTest.einsetzen(Spalte.EINS, Farbe.ROT)
        vierGewinntRahmenUnderTest.einsetzen(Spalte.EINS, Farbe.GELB)
        vierGewinntRahmenUnderTest.einsetzen(Spalte.EINS, Farbe.GELB)
        vierGewinntRahmenUnderTest.einsetzen(Spalte.EINS, Farbe.GELB)
        vierGewinntRahmenUnderTest.einsetzen(Spalte.EINS, Farbe.GELB)
        vierGewinntRahmenUnderTest.einsetzen(Spalte.EINS, Farbe.GELB)

        // Act
        val gefuellt = vierGewinntRahmenUnderTest.isSpalteGefuellt(Spalte.EINS)

        // Assert
        assertTrue(gefuellt);
    }
}

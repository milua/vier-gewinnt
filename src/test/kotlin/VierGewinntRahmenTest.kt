import viergewinnt.Farbe
import viergewinnt.Spalte
import viergewinnt.VierGewinntRahmen
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class VierGewinntRahmenTest {
    @Test
    fun isVierSteineUebereinander_withDreiGelbeSteineUebereinander() {
        // Arrange
        var vierGewinntRahmenUnderTest: VierGewinntRahmen = VierGewinntRahmen()

        // Act
        vierGewinntRahmenUnderTest.einsetzen(Spalte.EINS, Farbe.GELB)
        vierGewinntRahmenUnderTest.einsetzen(Spalte.EINS, Farbe.GELB)
        vierGewinntRahmenUnderTest.einsetzen(Spalte.EINS, Farbe.GELB)

        // Assert
        assertFalse(vierGewinntRahmenUnderTest.isVierSteineUebereinander(Farbe.GELB))
    }

    @Test
    fun isVierSteineUebereinander_withVierGelbeSteineUebereinander() {
        // Arrange
        var vierGewinntRahmenUnderTest: VierGewinntRahmen = VierGewinntRahmen()
        vierGewinntRahmenUnderTest.einsetzen(Spalte.EINS, Farbe.GELB)
        vierGewinntRahmenUnderTest.einsetzen(Spalte.EINS, Farbe.GELB)
        vierGewinntRahmenUnderTest.einsetzen(Spalte.EINS, Farbe.GELB)

        //Act
        vierGewinntRahmenUnderTest.einsetzen(Spalte.EINS, Farbe.GELB)

        // Assert
        assertTrue(vierGewinntRahmenUnderTest.isVierSteineUebereinander(Farbe.GELB))
    }

    @Test
    fun isVierSteineUebereinander_withLeererRahmen() {
        // Arrange
        var vierGewinntRahmenUnderTest: VierGewinntRahmen = VierGewinntRahmen()

        // Assert
        assertFalse(vierGewinntRahmenUnderTest.isVierSteineUebereinander(Farbe.GELB))
    }


    @Test
    fun isVierSteineUebereinander_withAndereFarbeDarunter() {
        // Arrange
        var vierGewinntRahmenUnderTest: VierGewinntRahmen = VierGewinntRahmen()
        vierGewinntRahmenUnderTest.einsetzen(Spalte.EINS, Farbe.GELB)
        vierGewinntRahmenUnderTest.einsetzen(Spalte.EINS, Farbe.GELB)
        vierGewinntRahmenUnderTest.einsetzen(Spalte.EINS, Farbe.GELB)
        vierGewinntRahmenUnderTest.einsetzen(Spalte.EINS, Farbe.ROT)
        vierGewinntRahmenUnderTest.einsetzen(Spalte.EINS, Farbe.GELB)

        // Assert
        assertFalse(vierGewinntRahmenUnderTest.isVierSteineUebereinander(Farbe.GELB))
    }

    @Test
    fun isVierDiagonal_nachObenLinks_returnTrue() {
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
        assertTrue(vierGewinntRahmenUnderTest.isVierDiagonal())
    }

    @Test
    fun isVierDiagonal_nachUntenRechts_returnTrue() {
        // Arrange
        var vierGewinntRahmenUnderTest: VierGewinntRahmen = VierGewinntRahmen()
        /* 1 */
        vierGewinntRahmenUnderTest.einsetzen(Spalte.VIER, Farbe.GELB)
        /* 2 */
        vierGewinntRahmenUnderTest.einsetzen(Spalte.DREI, Farbe.ROT)
        vierGewinntRahmenUnderTest.einsetzen(Spalte.DREI, Farbe.GELB)
        /* 3 */
        vierGewinntRahmenUnderTest.einsetzen(Spalte.ZWEI, Farbe.ROT)
        vierGewinntRahmenUnderTest.einsetzen(Spalte.ZWEI, Farbe.ROT)
        vierGewinntRahmenUnderTest.einsetzen(Spalte.ZWEI, Farbe.GELB)

        /* 4 */
        vierGewinntRahmenUnderTest.einsetzen(Spalte.EINS, Farbe.ROT)
        vierGewinntRahmenUnderTest.einsetzen(Spalte.EINS, Farbe.ROT)
        vierGewinntRahmenUnderTest.einsetzen(Spalte.EINS, Farbe.ROT)

        // Act
        vierGewinntRahmenUnderTest.einsetzen(Spalte.EINS, Farbe.GELB)

        //Assert
        assertTrue(vierGewinntRahmenUnderTest.isVierDiagonal())
    }

    @Test
    fun isVierDiagonal_nachObenRechts_returnTrue() {
        // Arrange
        var vierGewinntRahmenUnderTest: VierGewinntRahmen = VierGewinntRahmen()

        vierGewinntRahmenUnderTest.einsetzen(Spalte.VIER, Farbe.ROT)
        vierGewinntRahmenUnderTest.einsetzen(Spalte.VIER, Farbe.ROT)
        vierGewinntRahmenUnderTest.einsetzen(Spalte.VIER, Farbe.ROT)
        vierGewinntRahmenUnderTest.einsetzen(Spalte.VIER, Farbe.GELB)

        vierGewinntRahmenUnderTest.einsetzen(Spalte.DREI, Farbe.ROT)
        vierGewinntRahmenUnderTest.einsetzen(Spalte.DREI, Farbe.ROT)
        vierGewinntRahmenUnderTest.einsetzen(Spalte.DREI, Farbe.GELB)

        vierGewinntRahmenUnderTest.einsetzen(Spalte.ZWEI, Farbe.ROT)
        vierGewinntRahmenUnderTest.einsetzen(Spalte.ZWEI, Farbe.GELB)

        // Act
        vierGewinntRahmenUnderTest.einsetzen(Spalte.EINS, Farbe.GELB)

        //Assert
        assertTrue(vierGewinntRahmenUnderTest.isVierDiagonal())
    }

    @Test
    fun isVierDiagonal_nachUntenLinks_returnTrue() {
        // Arrange
        var vierGewinntRahmenUnderTest: VierGewinntRahmen = VierGewinntRahmen()

        vierGewinntRahmenUnderTest.einsetzen(Spalte.EINS, Farbe.GELB)

        vierGewinntRahmenUnderTest.einsetzen(Spalte.ZWEI, Farbe.ROT)
        vierGewinntRahmenUnderTest.einsetzen(Spalte.ZWEI, Farbe.GELB)

        vierGewinntRahmenUnderTest.einsetzen(Spalte.DREI, Farbe.ROT)
        vierGewinntRahmenUnderTest.einsetzen(Spalte.DREI, Farbe.ROT)
        vierGewinntRahmenUnderTest.einsetzen(Spalte.DREI, Farbe.GELB)

        vierGewinntRahmenUnderTest.einsetzen(Spalte.VIER, Farbe.ROT)
        vierGewinntRahmenUnderTest.einsetzen(Spalte.VIER, Farbe.ROT)
        vierGewinntRahmenUnderTest.einsetzen(Spalte.VIER, Farbe.ROT)

        // Act
        vierGewinntRahmenUnderTest.einsetzen(Spalte.VIER, Farbe.GELB)

        //Assert
        assertTrue(vierGewinntRahmenUnderTest.isVierDiagonal())
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
        assertTrue(vierGewinntRahmenUnderTest.isVierDiagonal())
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

    @Test
    fun isVierSteineDerSelbenFarbeNebeneinander_whenVierSteineDerSelbenFarbeNebeneinander_thenReturnTrue(){
        // Arrange
        var vierGewinntRahmenUnderTest: VierGewinntRahmen = VierGewinntRahmen()
        // füllt Spalte voll
        vierGewinntRahmenUnderTest.einsetzen(Spalte.EINS, Farbe.GELB)
        vierGewinntRahmenUnderTest.einsetzen(Spalte.ZWEI, Farbe.GELB)
        vierGewinntRahmenUnderTest.einsetzen(Spalte.DREI, Farbe.GELB)
        vierGewinntRahmenUnderTest.einsetzen(Spalte.VIER, Farbe.GELB)
        vierGewinntRahmenUnderTest.einsetzen(Spalte.FUENF, Farbe.ROT)
        vierGewinntRahmenUnderTest.einsetzen(Spalte.SECHS, Farbe.GELB)
        vierGewinntRahmenUnderTest.einsetzen(Spalte.SIEBEN, Farbe.GELB)

        // Act
        val gefuellt = vierGewinntRahmenUnderTest.isVierSteineDerSelbenFarbeNebeneinander(Spalte.ZWEI, 0, Farbe.GELB)

        // Assert
        assertTrue(gefuellt);
    }
}

import viergewinnt.Spalte
import viergewinnt.Farbe
import viergewinnt.VierGewinntRahmen
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class VierGewinntRahmenTest {
    @Test
    fun givenLeererRahmen_whenDreiGelbeSteineUebereinander_thenSpielUnentschieden() {

        var vierGewinntRahmenUnderTest: VierGewinntRahmen = VierGewinntRahmen()

        vierGewinntRahmenUnderTest.einsetzen(Spalte.EINS, Farbe.GELB)
        vierGewinntRahmenUnderTest.einsetzen(Spalte.EINS, Farbe.GELB)
        vierGewinntRahmenUnderTest.einsetzen(Spalte.EINS, Farbe.GELB)

        assertFalse(vierGewinntRahmenUnderTest.isVierSteineUebereinander())
    }

    @Test
    fun givenLeererRahmen_whenVierGelbeSteineUebereinander() {

        var vierGewinntRahmenUnderTest: VierGewinntRahmen = VierGewinntRahmen()

        vierGewinntRahmenUnderTest.einsetzen(Spalte.EINS, Farbe.GELB)
        vierGewinntRahmenUnderTest.einsetzen(Spalte.EINS, Farbe.GELB)
        vierGewinntRahmenUnderTest.einsetzen(Spalte.EINS, Farbe.GELB)
        vierGewinntRahmenUnderTest.einsetzen(Spalte.EINS, Farbe.GELB)

        assertTrue(vierGewinntRahmenUnderTest.isVierSteineUebereinander())
    }
}

package viergewinnt

const val MAX_SPALTEN_ANZAHL: Int = 7
const val MAX_ZEILEN_ANZAHL: Int = 6

class VierGewinntRahmen {

    /**
     * Zustände
     */
    var rahmen: Array<Array<Farbe?>> = Array(MAX_SPALTEN_ANZAHL) { Array(MAX_ZEILEN_ANZAHL) { null } }
    // Pair<out spalte: Int, out zeile: Int>
    var zuletztEingefuegtePosition: Pair<Int, Int>? = null

    fun einsetzen(spalte: Spalte, farbe: Farbe) {

        require(spalte.ordinal <= MAX_SPALTEN_ANZAHL)
        require(!isSpalteGefuellt(spalte))

        for (zeile in 0 until MAX_ZEILEN_ANZAHL) {
            if (rahmen[spalte.ordinal][zeile] == null) {
                rahmen[spalte.ordinal][zeile] = farbe
                zuletztEingefuegtePosition = Pair(spalte.ordinal, zeile)
                return
            }
        }
    }

    fun isVierSteineUebereinander(letzteFarbe: Farbe): Boolean {
        if (zuletztEingefuegtePosition != null) {
            var letzteSpalte = zuletztEingefuegtePosition?.first!!
            var letzteZeile = zuletztEingefuegtePosition?.second!!
            var farbenInEinerSpalte = 0
            var checkZeile: Int = letzteZeile
            while (checkZeile >= 0) {
                if (farbenInEinerSpalte == 4) {
                    return true
                }
                if (rahmen[letzteSpalte][checkZeile] == null) {
                    return false
                } else if (rahmen[letzteSpalte][checkZeile]!!.equals(letzteFarbe)) {
                    // increment counter
                    ++farbenInEinerSpalte
                } else if (!rahmen[letzteSpalte][checkZeile]!!.equals(letzteFarbe)) {
                    // wenn unter der eingeworfenen Farbe eine andere Farbe liegt, kann es kein VierGewinnt sein
                    return false
                }
                --checkZeile
            }
            return farbenInEinerSpalte == 4
        }
        return false
    }

    fun isSpalteGefuellt(spalte: Spalte): Boolean {
        return rahmen[spalte.ordinal][MAX_ZEILEN_ANZAHL - 1] != null
    }

    fun isVierDiagonal(): Boolean {
        if (zuletztEingefuegtePosition != null) {
            var zuletztEingefuegteFarbe: Farbe =
                rahmen[zuletztEingefuegtePosition!!.first][zuletztEingefuegtePosition!!.second]!!


        }
        return false
    }
}

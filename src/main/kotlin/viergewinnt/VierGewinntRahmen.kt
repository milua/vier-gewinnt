package viergewinnt

const val MAX_SPALTEN_ANZAHL: Int = 7
const val MAX_ZEILEN_ANZAHL: Int = 6

class VierGewinntRahmen {
    
    /**
     * Zustände
     */
    var rahmen: Array<Array<Farbe?>> = Array(MAX_SPALTEN_ANZAHL) { Array(MAX_ZEILEN_ANZAHL) { null } }

    fun einsetzen(spalte: Spalte, farbe: Farbe) {
        
        require(spalte.ordinal <= MAX_SPALTEN_ANZAHL)
        require(!isSpalteGefuellt(spalte))

        for (zeile in 0 until MAX_ZEILEN_ANZAHL) {
            if (rahmen[spalte.ordinal][zeile] == null) {
                rahmen[spalte.ordinal][zeile] = farbe
                return
            }
        }
    }

    fun isVierSteineUebereinander(): Boolean {
        return false
    }

    fun isSpalteGefuellt(spalte: Spalte): Boolean {
        return rahmen[spalte.ordinal][MAX_ZEILEN_ANZAHL-1] != null
    }
}

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
            var gleicheFarbenInEinerSpalte = 0
            var checkZeile: Int = letzteZeile
            while (checkZeile >= 0) {
                if (gleicheFarbenInEinerSpalte == 4) {
                    return true
                }
                if (rahmen[letzteSpalte][checkZeile] == null) {
                    return false
                } else if (rahmen[letzteSpalte][checkZeile]!!.equals(letzteFarbe)) {
                    // increment counter
                    ++gleicheFarbenInEinerSpalte
                } else if (!rahmen[letzteSpalte][checkZeile]!!.equals(letzteFarbe)) {
                    // wenn unter der eingeworfenen Farbe eine andere Farbe liegt, kann es kein VierGewinnt sein
                    return false
                }
                --checkZeile
            }
            return gleicheFarbenInEinerSpalte == 4
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
            var gleicheFarbenInEinerSpalte = 0

            // schaue unten links
            var checkSpalte = zuletztEingefuegtePosition?.first!! - 1
            var checkZeile = zuletztEingefuegtePosition?.second!! - 1
            while (checkSpalte >= 0 && checkZeile >= 0) {
                if (gleicheFarbenInEinerSpalte == 4) {
                    return true
                }
                if (rahmen[checkSpalte][checkZeile] == null) {
                    break
                } else if (rahmen[checkSpalte][checkZeile]!!.equals(zuletztEingefuegteFarbe)) {
                    // increment counter
                    ++gleicheFarbenInEinerSpalte
                    // go to next position
                    --checkSpalte
                    --checkZeile
                } else if (!rahmen[checkSpalte][checkZeile]!!.equals(zuletztEingefuegteFarbe)) {
                    break;
                }
            }

            // schaue unten rechts
            //reset gleicheFarbenInEinerSpalte
            gleicheFarbenInEinerSpalte = 0
            while (checkSpalte <= MAX_SPALTEN_ANZAHL && checkZeile >= 0) {
                if (gleicheFarbenInEinerSpalte == 4) {
                    return true
                }
                if (rahmen[checkSpalte][checkZeile] == null) {
                    break
                } else if (rahmen[checkSpalte][checkZeile]!!.equals(zuletztEingefuegteFarbe)) {
                    // increment counter
                    ++gleicheFarbenInEinerSpalte
                    // go to next position
                    ++checkSpalte
                    --checkZeile
                } else if (!rahmen[checkSpalte][checkZeile]!!.equals(zuletztEingefuegteFarbe)) {
                    break;
                }
            }
            // schaue oben links
            //reset gleicheFarbenInEinerSpalte
            gleicheFarbenInEinerSpalte = 0
            while (checkSpalte <= MAX_SPALTEN_ANZAHL && checkZeile >= 0) {
                if (gleicheFarbenInEinerSpalte == 4) {
                    return true
                }
                if (rahmen[checkSpalte][checkZeile] == null) {
                    break
                } else if (rahmen[checkSpalte][checkZeile]!!.equals(zuletztEingefuegteFarbe)) {
                    // increment counter
                    ++gleicheFarbenInEinerSpalte
                    // go to next position
                    ++checkSpalte
                    --checkZeile
                } else if (!rahmen[checkSpalte][checkZeile]!!.equals(zuletztEingefuegteFarbe)) {
                    break;
                }
            }
            // schaue oben rechts
            //reset gleicheFarbenInEinerSpalte
            gleicheFarbenInEinerSpalte = 0
            while (checkSpalte <= MAX_SPALTEN_ANZAHL && checkZeile <= MAX_ZEILEN_ANZAHL) {
                if (gleicheFarbenInEinerSpalte == 4) {
                    return true
                }
                if (rahmen[checkSpalte][checkZeile] == null) {
                    break
                } else if (rahmen[checkSpalte][checkZeile]!!.equals(zuletztEingefuegteFarbe)) {
                    // increment counter
                    ++gleicheFarbenInEinerSpalte
                    // go to next position
                    ++checkSpalte
                    ++checkZeile
                } else if (!rahmen[checkSpalte][checkZeile]!!.equals(zuletztEingefuegteFarbe)) {
                    break;
                }
            }
        }
        return false
    }

    /**
     * Diese Methode prüft von der letzten Einwurfposition nach rechts und nach links,
     * ob in Summe 4 gleichfarbige Coins in einer Reihe eingesetzt wurden.
     */
    fun isVierSteineDerSelbenFarbeNebeneinander(spalte: Spalte, zeile: Int, farbe: Farbe): Boolean {
        val eingangsFarbe: Farbe? = rahmen[spalte.ordinal][zeile]
        var vorherigeFarbe: Farbe? = rahmen[spalte.ordinal][zeile]
        var aktuelleFarbe: Farbe? = rahmen[spalte.ordinal][zeile]
        var vierGewinntCounter = 1 // 1 = Der Coin den man gerade einsetzt

        // check nach rechts
        for (naechsteSpalte in spalte.ordinal + 1 until MAX_SPALTEN_ANZAHL) {
            aktuelleFarbe = rahmen[naechsteSpalte][zeile]

            if (aktuelleFarbe == vorherigeFarbe) {
                vierGewinntCounter++
                if (vierGewinntCounter == 4) {
                    return true
                }
            } else {
                break
            }
            vorherigeFarbe = aktuelleFarbe
        }
        vorherigeFarbe = eingangsFarbe
        // check nach links
        for (vorherigeSpalte in spalte.ordinal - 1 downTo 0) {
            aktuelleFarbe = rahmen[vorherigeSpalte][zeile]
            if (aktuelleFarbe == vorherigeFarbe) {
                vierGewinntCounter++
                println(vierGewinntCounter)
                if (vierGewinntCounter == 4) {
                    return true
                }
            } else {
                break
            }
            vorherigeFarbe = aktuelleFarbe
        }
        return false
    }
}

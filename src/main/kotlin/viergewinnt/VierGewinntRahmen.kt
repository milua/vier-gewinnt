package viergewinnt

class VierGewinntRahmen {

    var rahmen: Array<Array<Farbe?>> = Array(7) {Array(6) { null } }

    fun einsetzen(spalte: Spalte, farbe: Farbe) {
        // rahmen[spalte][reihe].add(farbe)
    }

    fun isVierSteineUebereinander(): Boolean {
        return false
    }

}

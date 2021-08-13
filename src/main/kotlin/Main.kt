// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.Window
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp
import viergewinnt.Farbe
import viergewinnt.Spalte
import viergewinnt.VierGewinntRahmen

val boxSize = 100.dp;

fun main() = Window {
    var text by remember { mutableStateOf("Hello, World!") }
    val rahmen = VierGewinntRahmen()
    val emptyArray: Array<Farbe?> = arrayOf(null, null, null, null, null, null)
    val notEmptyArray: Array<Farbe?> = arrayOf(Farbe.GELB, null, null, null, null, null)

    var aktiveFarbe by remember { mutableStateOf(Farbe.GELB) }

    var spalte1 by remember { mutableStateOf(emptyArray)}
    var spalte2 by remember { mutableStateOf(emptyArray)}
    var spalte3 by remember { mutableStateOf(emptyArray)}
    var spalte4 by remember { mutableStateOf(emptyArray)}
    var spalte5 by remember { mutableStateOf(emptyArray)}
    var spalte6 by remember { mutableStateOf(emptyArray)}
    var spalte7 by remember { mutableStateOf(emptyArray)}
    

    fun einsetzen (spalte: Spalte) {
        rahmen.einsetzen(spalte, aktiveFarbe)
        aktiveFarbe = if (aktiveFarbe == Farbe.GELB)  Farbe.ROT else Farbe.GELB
    }

    MaterialTheme {
        Row (modifier = Modifier.border(
            width = 2.dp, brush = SolidColor(Color.DarkGray), shape = RectangleShape
        )) {
            spaltenView(spalte1, {einsetzen(Spalte.EINS); spalte1 = rahmen.rahmen[0].clone()})
            spaltenView(spalte2, {einsetzen(Spalte.ZWEI); spalte2 = rahmen.rahmen[1].clone()})
            spaltenView(spalte3, {einsetzen(Spalte.DREI); spalte3 = rahmen.rahmen[2].clone()})
            spaltenView(spalte4, {einsetzen(Spalte.VIER); spalte4 = rahmen.rahmen[3].clone()})
            spaltenView(spalte5, {einsetzen(Spalte.FUENF); spalte5 = rahmen.rahmen[4].clone()})
            spaltenView(spalte6, {einsetzen(Spalte.SECHS); spalte6 = rahmen.rahmen[5].clone()})
            spaltenView(spalte7, {einsetzen(Spalte.SIEBEN); spalte7 = rahmen.rahmen[6].clone()})
        }
    }
}

@Composable
fun spaltenView (spalte: Array<Farbe?>, clickHandler: () -> Unit) {
    Column (modifier = Modifier.clickable {run{clickHandler()}}.border(
        width = 2.dp, brush = SolidColor(Color.DarkGray), shape = RectangleShape
    )) {
        Box(modifier = Modifier.size(boxSize).background(convertFarbeToColor(spalte[5])))
        Box(modifier = Modifier.size(boxSize).background(convertFarbeToColor(spalte[4])))
        Box(modifier = Modifier.size(boxSize).background(convertFarbeToColor(spalte[3])))
        Box(modifier = Modifier.size(boxSize).background(convertFarbeToColor(spalte[2])))
        Box(modifier = Modifier.size(boxSize).background(convertFarbeToColor(spalte[1])))
        Box(modifier = Modifier.size(boxSize).background(convertFarbeToColor(spalte[0])))
    }
}

fun convertFarbeToColor (farbe: Farbe?): Color = when (farbe) {
    null    -> Color.Transparent
    Farbe.GELB -> Color.Yellow
    Farbe.ROT -> Color.Red
    else -> Color.Transparent
}

class MainViewModel {
    val rahmen = VierGewinntRahmen()
    private var spalteIntern: Array<Farbe?> = arrayOf(null, null, null, null, null, null)

}
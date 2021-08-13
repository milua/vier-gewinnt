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
import viergewinnt.VierGewinntRahmen

val boxSize = 100.dp;

fun main() = Window {
    var text by remember { mutableStateOf("Hello, World!") }
    val rahmen = VierGewinntRahmen()
    val emptyArray: Array<Farbe?> = arrayOf(null, null, null, null, null, null)
    val notEmptyArray: Array<Farbe?> = arrayOf(Farbe.GELB, null, null, null, null, null)

    var spalte1 by remember { mutableStateOf(emptyArray)}
    var spalte2 by remember { mutableStateOf(emptyArray)}
    var spalte3 by remember { mutableStateOf(emptyArray)}
    var spalte4 by remember { mutableStateOf(emptyArray)}
    var spalte5 by remember { mutableStateOf(emptyArray)}
    var spalte6 by remember { mutableStateOf(emptyArray)}
    var spalte7 by remember { mutableStateOf(emptyArray)}


    MaterialTheme {
        Row (modifier = Modifier.border(
            width = 2.dp, brush = SolidColor(Color.DarkGray), shape = RectangleShape
        )) {
            spaltenView(spalte1, {spalte1 = notEmptyArray})
            spaltenView(spalte2, {spalte2 = notEmptyArray})
            spaltenView(spalte3, {spalte3 = notEmptyArray})
            spaltenView(spalte4, {spalte4 = notEmptyArray})
            spaltenView(spalte5, {spalte5 = notEmptyArray})
            spaltenView(spalte6, {spalte6 = notEmptyArray})
            spaltenView(spalte7, {spalte7 = notEmptyArray})
        }
    }
}

@Composable
fun spaltenView (spalte: Array<Farbe?>, clickHandler: () -> Unit) {
    Column (modifier = Modifier.clickable {clickHandler}.border(
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
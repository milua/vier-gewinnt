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

    MaterialTheme {
        Row (modifier = Modifier.border(
            width = 2.dp, brush = SolidColor(Color.DarkGray), shape = RectangleShape
        )) {
            spaltenView()
            spaltenView()
            spaltenView()
            spaltenView()
            spaltenView()
            spaltenView()
            spaltenView()
        }
    }
}

@Composable
fun spaltenView () {
    val emptyArray: Array<Farbe?> = arrayOf(null, null, null, null, null, null)
    val notEmptyArray: Array<Farbe?> = arrayOf(Farbe.GELB, null, null, null, null, null)
    var color by remember { mutableStateOf(Color.Transparent) }
    var spalte by remember { mutableStateOf(emptyArray)}
    //var count by model.spalte.observeAsState()
    Column (modifier = Modifier.clickable { run{
        color = Color.Yellow
        spalte = notEmptyArray
    } }.border(
        width = 2.dp, brush = SolidColor(Color.DarkGray), shape = RectangleShape
    )) {
        Box(modifier = Modifier.size(boxSize).background(Color.Transparent))
        Box(modifier = Modifier.size(boxSize).background(Color.Transparent))
        Box(modifier = Modifier.size(boxSize).background(Color.Transparent))
        Box(modifier = Modifier.size(boxSize).background(Color.Transparent))
        Box(modifier = Modifier.size(boxSize).background(Color.Transparent))
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
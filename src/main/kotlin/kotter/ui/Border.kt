package kotter.ui

import com.varabyte.kotterx.decorations.BorderCharacters

class Border(
    val borderCharacters: BorderCharacters = BorderCharacters.ASCII,
    val paddingLeftRight: Int,
    val paddingTopBottom: Int,
)
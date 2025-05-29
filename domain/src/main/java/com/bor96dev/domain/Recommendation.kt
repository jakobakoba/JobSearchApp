package com.bor96dev.domain

import java.awt.Image

data class Recommendation (
    val icon: Image,
    val title: String,
    val buttonText: String?
)

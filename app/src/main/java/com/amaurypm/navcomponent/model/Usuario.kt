package com.amaurypm.navcomponent.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Creado por Amaury Perea Matsumura el 21/10/22
 */
@Parcelize
data class Usuario(
    var name: String,
    var mobile: Long
): Parcelable

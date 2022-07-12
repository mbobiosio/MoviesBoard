package com.cerminnovations.domain.model.people

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
@Parcelize
data class Person(
    val id: Long,
    val profilePath: String?,
    val name: String?,
    val popularity: Double?,
    val knownForDepartment: String?
) : Parcelable

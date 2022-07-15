package com.cerminnovations.core.util // ktlint-disable filename

import androidx.databinding.ViewDataBinding

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
inline fun <T : ViewDataBinding> T.executeAfter(block: T.() -> Unit) {
    block()
    executePendingBindings()
}

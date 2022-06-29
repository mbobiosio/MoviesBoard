package com.cerminnovations.core.util

import androidx.databinding.ViewDataBinding

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
inline fun <T : ViewDataBinding> T.executeAfter(block: T.() -> Unit) {
    block()
    executePendingBindings()
}

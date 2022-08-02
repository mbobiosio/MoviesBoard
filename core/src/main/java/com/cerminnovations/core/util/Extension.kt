package com.cerminnovations.core.util

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.SystemClock
import android.text.format.DateUtils
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.paging.PagingConfig
import androidx.viewpager2.widget.ViewPager2
import com.cerminnovations.core.constant.Constants
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.* // ktlint-disable no-wildcard-imports
import kotlin.math.floor
import kotlin.math.log10
import kotlin.math.pow

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
/**
 * [Moshi] extension to transform a [List] to Json
 * */
inline fun <reified T> Moshi.listToJson(data: List<T>): String =
    adapter<List<T>>(
        Types.newParameterizedType(
            List::class.java,
            T::class.java
        )
    ).toJson(data)

/**
 * [Moshi] extension to transform a json object to a [List]
 * */
inline fun <reified T> Moshi.jsonToList(json: String): List<T>? =
    adapter<List<T>>(
        Types.newParameterizedType(
            List::class.java,
            T::class.java
        )
    ).fromJson(json)

fun <T> LiveData<T>.observeOnce(lifecycleOwner: LifecycleOwner, observer: Observer<T>) {
    observe(
        lifecycleOwner,
        object : Observer<T> {
            override fun onChanged(t: T) {
                observer.onChanged(t)
                removeObserver(this)
            }
        }
    )
}

infix fun <T> UIState<T>.onLoading(onLoading: UIState.Loading.() -> Unit): UIState<T> =
    when (this) {
        is UIState.Loading -> {
            onLoading(this)
            this
        }
        else -> {
            this
        }
    }

infix fun <T> UIState<T>.onSuccess(onSuccess: UIState.Success<T>.() -> Unit): UIState<T> =
    when (this) {
        is UIState.Success -> {
            onSuccess(this)
            this
        }
        else -> {
            this
        }
    }

infix fun <T> UIState<T>.onError(onError: UIState.Error.() -> Unit): UIState<T> =
    when (this) {
        is UIState.Error -> {
            onError(this)
            this
        }
        else -> {
            this
        }
    }

fun Fragment.handleBackPress(viewPager: ViewPager2) {
    activity?.onBackPressedDispatcher?.addCallback(
        viewLifecycleOwner,
        object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (viewPager.currentItem == 0) {
                    activity?.finish()
                } else {
                    viewPager.currentItem = viewPager.currentItem - 1
                }
            }
        }
    )
}

fun Uri?.openInBrowser(context: Context) {
    this ?: return

    val intent = Intent(Intent.ACTION_VIEW, this)
    ContextCompat.startActivity(context, intent, null)
}

fun String?.asUri(): Uri? {
    try {
        return Uri.parse(this)
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return null
}

fun roundUpNumber(number: Double): String =
    "%.1f".format(number)

fun formatVotesCount(count: Number): String {
    val suffix = charArrayOf(' ', 'k', 'M', 'B', 'T', 'P', 'E')
    val value = floor(log10(count.toDouble())).toInt()
    val base = value / 3

    val voteCount = when {
        value >= 3 && base < suffix.size -> {
            val calValue = count.toLong() / 10.0.pow(base * 3)
            DecimalFormat("#0.0").format(calValue) + suffix[base]
        }
        else -> {
            DecimalFormat("#0").format(count.toLong())
        }
    }
    return voteCount
}

fun formatReadableDate(time: String): String {
    val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val formatSdf = sdf.parse(time)
    return DateUtils.getRelativeTimeSpanString(formatSdf?.time ?: 0).toString()
}

fun getTimeAgo(time: String): String {
    val sdf = SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.getDefault())
    val formatSdf = sdf.parse(time)
    return DateUtils.getRelativeTimeSpanString(formatSdf?.time ?: 0).toString()
}

fun defaultPageConfig(): PagingConfig =
    PagingConfig(
        pageSize = Constants.DEFAULT_PAGE_SIZE,
        enablePlaceholders = true,
        prefetchDistance = 5,
        initialLoadSize = 40
    )

fun View.setSafeClickListener(onSafeClick: (View) -> Unit) {
    val safeClickListener = SafeClickLister { onSafeClick(it) }
    setOnClickListener(safeClickListener)
}

class SafeClickLister(
    private var defaultInterval: Int = 1000,
    private val onSafeClick: (View) -> Unit
) : View.OnClickListener {
    private var lastItemClicked: Long = 0
    override fun onClick(v: View) {
        when {
            SystemClock.elapsedRealtime() - lastItemClicked < defaultInterval -> return
            else -> {
                lastItemClicked = SystemClock.elapsedRealtime()
                onSafeClick(v)
            }
        }
    }
}

package ru.modelov.testapp65apps.listemployees.presentation.databinding

import android.net.Uri
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import ru.modelov.testapp65apps.R
import ru.modelov.testapp65apps.main.utils.converter.ConverterDate.getAge

@BindingAdapter("setAge")
fun TextView.setAge(birthday: String?) {
    text = getAge(birthday)
}

@BindingAdapter("setPhoto")
fun ImageView.setPhoto(res: String?) {
    if (!res.isNullOrBlank()) {
        Glide.with(context)
            .load(Uri.parse(res))
            .apply(
                RequestOptions.bitmapTransform(CircleCrop())
                    .error(R.drawable.ic_baseline_account_circle_24)
            )
            .transition(DrawableTransitionOptions().crossFade())
            .into(this)
    } else {
        setImageDrawable(resources.getDrawable(R.drawable.ic_baseline_account_circle_24))
    }

}
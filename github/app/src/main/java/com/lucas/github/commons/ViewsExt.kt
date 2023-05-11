package com.lucas.github.commons

import android.widget.ImageView
import com.lucas.github.R
import com.squareup.picasso.Picasso

object ViewsExt {

    fun ImageView.loadUrl(url: String?) {
        Picasso.get()
            .load(url)
            .placeholder(R.drawable.icon_user)
            .error(R.drawable.icon_user)
            .into(this);
    }
}
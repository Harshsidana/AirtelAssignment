package com.appstreet.airtelassignment.ui.home

import android.os.Bundle
import com.appstreet.airtelassignment.R
import com.bumptech.glide.Glide
import com.view.AbstractUserDetailActivity
import kotlinx.android.synthetic.main.activity_user_details.*

class UserDetails : AbstractUserDetailActivity() {
    override fun getLayoutRes(): Int {
        return R.layout.activity_user_details
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = intent.getBundleExtra("Bundle")


        userNamevalue.text = bundle.getString("Username")
        nameTextvalue.text = bundle.getString("Name")
        urlTextValue.text = bundle.getString("Url")
        Glide.with(avatarImage)
            .load(bundle.getString("Avatar"))
            .into(avatarImage)

        repo_detail_text_value.text = bundle.getString("Repo Description")
        repo_name_value.text = bundle.getString("Repo Name")
        repo_url_text_value.text = bundle.getString("Repo Url")
    }
}

package com.ssafy.phonesin.ui.module.camera

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class CameraPageAdapter(
    fragmentManager: FragmentManager
) : FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    private var photoPaths: MutableList<String> = mutableListOf()
    override fun getCount(): Int = photoPaths.size

    override fun getItem(position: Int): Fragment = PhotoFragment.newInstance(photoPaths[position])

    fun setPhotoPath(paths: List<String>) {
        photoPaths.clear()
        photoPaths.addAll(paths)
        notifyDataSetChanged()
    }
}
package com.cerminnovations.moviesboard.presentation.reviews

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cerminnovations.moviesboard.databinding.FragmentReviewsBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
class ReviewsFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentReviewsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentReviewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
    }

    private fun initViews() = with(binding) {
        reviews.apply {
        }
    }
}

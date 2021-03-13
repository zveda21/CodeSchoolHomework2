package com.example.appguardian.fragments.details

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.appguardian.MainActivity
import com.example.appguardian.base.BaseSportFragment
import com.example.appguardian.databinding.FragmentDetailsDescriptionBinding
import com.example.appguardian.models.pojo.Content
import com.example.appguardian.models.pojo.Description
import java.io.Serializable

class DetailsDescriptionFragment : BaseSportFragment() {
    private lateinit var detailsBinding: FragmentDetailsDescriptionBinding

    var resultsItem: Content.Response.Result? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        detailsBinding = FragmentDetailsDescriptionBinding.inflate(inflater, container, false)
        return detailsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onBackedPressed()
        setViews()
    }

    private fun setViews() {
        detailsBinding.headerText.text = resultsItem?.fields?.headline
        resultsItem?.fields?.thumbnail?.let {
            Glide.with(requireContext())
                .load(it)
                .into(detailsBinding.sectionImage)
        }
        detailsBinding.trailText.text = resultsItem?.fields?.trailText
        detailsBinding.bodyText.text = resultsItem?.fields?.bodyText
        detailsBinding.publisherName.text = resultsItem?.fields?.byline
        detailsBinding.pubDate.text = resultsItem?.webPublicationDate
    }

    private fun onBackedPressed() {
        detailsBinding.arrowBack.setOnClickListener {
            val requireActivity = requireActivity() as MainActivity
            requireActivity.supportFragmentManager.popBackStack()
        }
    }

    override fun startLoader() {
        TODO("Not yet implemented")
    }

    override fun stopLoader() {
        TODO("Not yet implemented")
    }

    companion object {
        fun newInstance(response: Description?) = DetailsDescriptionFragment().apply {
            arguments?.putSerializable("response", response as Serializable)
            resultsItem = response
        }
    }
}
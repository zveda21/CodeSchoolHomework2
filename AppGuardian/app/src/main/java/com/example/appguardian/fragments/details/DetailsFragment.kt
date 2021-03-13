package com.example.appguardian.fragments.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.appguardian.MainActivity
import com.example.appguardian.base.BaseSportFragment
import com.example.appguardian.callservice.ApiClient
import com.example.appguardian.callservice.SearchRepositoryImpl
import com.example.appguardian.databinding.FragmentDetailsBinding
import com.example.appguardian.fragments.sections.OnClickRecyclerItem

class DetailsFragment : BaseSportFragment(), OnClickRecyclerItem {
    private lateinit var detailsBinding: FragmentDetailsBinding
    private var detailsRecyclerAdapter = DetailsRecyclerAdapter(this)
    private var searchRepositoryImpl = SearchRepositoryImpl(ApiClient.instance)
    private val detailsViewModel: DetailsViewModel by viewModels {
        DetailsFactory(
            searchRepositoryImpl
        )
    }
    private var secId: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startLoader()
        detailsViewModel.getSectionWithPath(secId)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        detailsBinding = FragmentDetailsBinding.inflate(inflater, container, false)
        return detailsBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapters()
        onBackPressed()
        observeDetailsLiveData()
    }

    private fun initAdapters() {
        detailsBinding.detailsRecycler.apply {
            adapter = detailsRecyclerAdapter
        }
    }

    private fun observeDetailsLiveData() {
        detailsViewModel.detailsLiveData.observe(viewLifecycleOwner, {
            detailsRecyclerAdapter.updateDate(it)
            stopLoader()
        })
    }

    private fun onBackPressed() {
        detailsBinding.arrowBack.setOnClickListener {
            reqActivity().supportFragmentManager.popBackStack()
        }
    }


    private fun reqActivity(): MainActivity {
        return requireActivity() as MainActivity
    }

    override fun startLoader() {
        reqActivity().startLoader()
    }

    override fun stopLoader() {
        reqActivity().stopLoader()
    }

//    override fun onItemClick(id: Any?) {
//        reqActivity().replaceFragmentBackStack(
//            DetailsDescriptionFragment.newInstance(id as Content.Response.Result?),
//            tag = "description"
//        )
//    }

    companion object {
        fun newInstance(sectionItem: String?) = DetailsFragment().apply {
            arguments?.putString("Id", sectionItem)
            secId = sectionItem
        }
    }

    override fun onItemClick(id: Any?) {
        TODO("Not yet implemented")
    }


}
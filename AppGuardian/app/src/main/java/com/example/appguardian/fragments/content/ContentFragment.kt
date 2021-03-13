package com.example.appguardian.fragments.content

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.example.appguardian.MainActivity
import com.example.appguardian.R
import com.example.appguardian.base.BaseSportFragment
import com.example.appguardian.callservice.ApiClient
import com.example.appguardian.callservice.SearchRepositoryImpl
import com.example.appguardian.databinding.FragmentContentBinding
import com.example.appguardian.extentions.replaceFragmentBackStack
import com.example.appguardian.fragments.details.DetailsDescriptionFragment
import com.example.appguardian.fragments.details.DetailsRecyclerAdapter
import com.example.appguardian.fragments.sections.OnClickRecyclerItem
import com.example.appguardian.models.pojo.Content


class ContentFragment : BaseSportFragment(), PassDataFromDialog, OnClickRecyclerItem {
    private lateinit var contentBinding: FragmentContentBinding
    private var searchRepositoryImpl = SearchRepositoryImpl(ApiClient.instance)
    private var contentAdapter = ContentFragmentAdapter(this)
    private  var currentContentItem: String? = null
    private var orderBy: String? = null
    private var useDate: String? = null
    private var filterFragment = FilterFragment.newInstance()
    private var secId: String? = null

    private val contentViewModel: ContentViewModel by viewModels {
        ContentFactory(
            searchRepositoryImpl
        )
    }

    override fun startLoader() {
        TODO("Not yet implemented")
    }

    override fun stopLoader() {
        TODO("Not yet implemented")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        contentViewModel.getContent(orderBy,useDate,currentContentItem)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        contentBinding = FragmentContentBinding.inflate(inflater, container, false)
        return contentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        filterFragment.setPassDateInt(this)
        initToolBar()
        initAdapters()
        observeLiveData()
    }

    private fun observeLiveData() {
        contentViewModel.contentLiveData.observe(viewLifecycleOwner, {
            contentAdapter.updateDate(it)
        })
    }

    private fun initAdapters() {
        contentBinding.contentRecycler.apply {
            adapter = contentAdapter
        }
    }

    private fun getReqActivity(): MainActivity {
        return requireActivity() as MainActivity
    }

    private fun initToolBar() {
        getReqActivity().setSupportActionBar(contentBinding.toolBar)
        getReqActivity().title = "Content"
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        getReqActivity().menuInflater.inflate(R.menu.toolbar_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        contentBinding.toolBar.menu.findItem(R.id.searchBtn).isVisible = true
        when (item.itemId) {
            R.id.searchBtn -> {
                filterFragment.setStyle(DialogFragment.STYLE_NO_TITLE, R.style.DialogFragmentTheme)
                filterFragment.show(getReqActivity().supportFragmentManager, "FR")
            }
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        fun newInstance(sectionItem: String?) = ContentFragment().apply {
            arguments?.putString("Id", sectionItem)
            secId = sectionItem
        }
    }

    override fun passData(data: PassedDate) {
        Log.e("Value1", data.contentItem)
        Log.e("Value1", data.orderBy)
        Log.e("Value1", data.useDate)
        currentContentItem = data.contentItem
        orderBy = data.orderBy
        useDate = data.useDate
        contentViewModel.getContent(orderBy,useDate,currentContentItem)
    }
    override fun onItemClick(id: Any?) {
     val act =    requireActivity() as MainActivity
        act.replaceFragmentBackStack(
            DetailsDescriptionFragment.newInstance(id as Content.Response.Result?),
            tag = "description"
        )
    }
}
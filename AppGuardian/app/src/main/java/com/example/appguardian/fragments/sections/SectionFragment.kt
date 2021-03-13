package com.example.appguardian.fragments.sections
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.appguardian.GuardianApplication
import com.example.appguardian.MainActivity
import com.example.appguardian.base.BaseSportFragment
import com.example.appguardian.callservice.ApiClient
import com.example.appguardian.callservice.SearchRepositoryImpl
import com.example.appguardian.databinding.FragmentSectionBinding
import com.example.appguardian.extentions.replaceFragmentBackStack
import com.example.appguardian.fragments.content.ContentFragment
import com.example.appguardian.fragments.details.DetailsFragment
import com.example.appguardian.fragments.favorite.OnDeleteItemFromFavListener
import com.example.appguardian.models.pojo.Section
import com.example.appguardian.models.sections.ResultsItem

class SectionFragment : BaseSportFragment(), OnClickRecyclerItem , OnDeleteItemFromFavListener, OnSectionFavoriteListener{
    private var searchRepositoryImpl = SearchRepositoryImpl(ApiClient.instance)
    private lateinit var sectionBinding: FragmentSectionBinding
    private lateinit var sectionRecyclerAdapter: SectionRecyclerAdapter
    private val sectionFactory by lazy { SectionFactory(searchRepositoryImpl,(requireActivity().application as GuardianApplication).sectionRepository) }
    private val sectionViewModel: SectionViewModel  by viewModels { sectionFactory }
    //by lazy { ViewModelProvider(this,sectionFactory).get(SectionViewModel::class.java) }
    //by viewModels { sectionFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sectionViewModel.getSection()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        startLoader()
        sectionBinding = FragmentSectionBinding.inflate(inflater, container, false)
        sectionRecyclerAdapter = SectionRecyclerAdapter(this,this)
        return sectionBinding.root
    }




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        observeLiveData()
        sectionViewModel.roomListOfSection.observe(viewLifecycleOwner, Observer {
            sectionRecyclerAdapter.favChanged(it)
        })
    }

    private fun setupViews() {
        sectionBinding.sectionRecycler.apply {
            adapter = sectionRecyclerAdapter
        }
    }

    private fun observeLiveData() {
        sectionViewModel.sectionsLiveData.observe(viewLifecycleOwner, {
            sectionRecyclerAdapter.updateDate(it)
            stopLoader()
        })
    }


    override fun startLoader() {
        val mainActivity = requireActivity() as MainActivity
        mainActivity.startLoader()
    }

    override fun stopLoader() {
        val mainActivity = requireActivity() as MainActivity
        mainActivity.stopLoader()
    }

    override fun onItemClick(id: Any?) {
        val mainActivity = requireActivity() as MainActivity
        mainActivity.replaceFragmentBackStack(
            ContentFragment.newInstance(id as String?),
            tag = "content"
        )
    }


    companion object {
        fun newInstance() = SectionFragment()
    }

    override fun onClickDeleteBtn(item: Any) {
        TODO("Not yet implemented")
    }

    override fun onclickFavSec(item: Section.Response.Result, position: Int, isChecked: Boolean) {
        sectionViewModel.updateRoomData(item,position,isChecked)
    }


}
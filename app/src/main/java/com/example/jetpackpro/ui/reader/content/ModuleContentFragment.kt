package com.example.jetpackpro.ui.reader.content

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.jetpackpro.R
import com.example.jetpackpro.data.ContentEntity
import com.example.jetpackpro.data.CourseEntity
import com.example.jetpackpro.data.ModuleEntity
import com.example.jetpackpro.databinding.FragmentModuleContentBinding
import com.example.jetpackpro.ui.reader.CourseReaderViewModel
import com.example.jetpackpro.viewmode.ViewModelFactory

class ModuleContentFragment : Fragment() {

    private lateinit var fragmentModuleContentBinding: FragmentModuleContentBinding

    companion object {
        val TAG: String = ModuleContentFragment::class.java.simpleName.toString()
        fun newInstance() : ModuleContentFragment = ModuleContentFragment()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentModuleContentBinding = FragmentModuleContentBinding.inflate(inflater, container, false)
        return fragmentModuleContentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(activity != null){
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(requireActivity(), factory)[CourseReaderViewModel::class.java]

            fragmentModuleContentBinding.progressBar.visibility = View.VISIBLE

            viewModel.getSelectedModule().observe(this, Observer {
                fragmentModuleContentBinding.progressBar.visibility = View.INVISIBLE

                if(it != null){
                    populateWebView(it)
                }
            })
        }
    }

    private fun populateWebView(module : ModuleEntity) {
        fragmentModuleContentBinding.webView.loadData(module.contentEntity?.content ?: "", "text/html", "UTF-8")
    }
}
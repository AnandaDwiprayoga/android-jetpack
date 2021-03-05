package com.example.jetpackpro.ui.bookmark

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jetpackpro.R
import com.example.jetpackpro.data.CourseEntity
import com.example.jetpackpro.databinding.FragmentBookmarkBinding
import com.example.jetpackpro.utils.DataDummy
import com.example.jetpackpro.viewmode.ViewModelFactory

class BookmarkFragment : Fragment(), BookmarkAdapter.BookmarkFragmentCallback {

    lateinit var fragmentBookmarkBinding: FragmentBookmarkBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentBookmarkBinding = FragmentBookmarkBinding.inflate(inflater,container, false)
        return fragmentBookmarkBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(activity != null){
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[BookmarkViewModel::class.java]
            val adapter = BookmarkAdapter(this)



            fragmentBookmarkBinding.progressBar.visibility = View.VISIBLE
            viewModel.getBookmars().observe(this, Observer {courses->
                fragmentBookmarkBinding.progressBar.visibility = View.GONE
                adapter.setCourses(courses)
                adapter.notifyDataSetChanged()
            })

            with(fragmentBookmarkBinding.rvBookmark){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                this.adapter = adapter
            }

        }
    }

    override fun onShareClick(course: CourseEntity) {
        if(activity != null){
            val mimeType = "text/plain"
            ShareCompat
                .IntentBuilder
                .from(requireActivity())
                .setText(mimeType)
                .setChooserTitle("Bagikan aplikasi ini sekarang")
                .setText(resources.getString(R.string.share_text,course.title))
                .startChooser()
        }
    }
}
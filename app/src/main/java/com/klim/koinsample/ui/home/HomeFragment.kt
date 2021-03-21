package com.klim.koinsample.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.klim.koinsample.R
import com.klim.koinsample.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    val viewModel: HomeViewModel by viewModel()

    val adapter: PostAdapter = PostAdapter()
    lateinit var layoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        layoutManager = LinearLayoutManager(context)

        binding.rvPosts.adapter = adapter
        binding.rvPosts.layoutManager = layoutManager

        viewModel.posts.observe(viewLifecycleOwner, { list ->
            adapter.data.clear()
            adapter.data.addAll(list)
            adapter.notifyDataSetChanged()
        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.updatePosts()
    }
}
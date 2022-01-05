package com.ranzan.toastimpl.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ranzan.toastimpl.R
import com.ranzan.toastimpl.databinding.FragmentBlankBinding
import com.ranzan.toastimpl.model.DataItem
import com.ranzan.toastimpl.viewmodel.TheViewModel

class BlankFragment : Fragment() {

    lateinit var viewModel: TheViewModel
    lateinit var fragmentBlankBinding: FragmentBlankBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentBlankBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_blank, container, false)
        return fragmentBlankBinding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TheViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getData().observe(viewLifecycleOwner, Observer { dataList ->
            fragmentBlankBinding.recyclerView.apply {
                adapter = RecyclerViewAdapter(dataList as ArrayList<DataItem>)
                layoutManager = LinearLayoutManager(context)
            }
        })
    }

}
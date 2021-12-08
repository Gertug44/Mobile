package com.example.hudway.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hudway.R
import com.example.hudway.databinding.FragmentMainHeaderBinding
import com.example.hudway.interfaces.NavigationPasser

class MainHeaderFragment : Fragment() {

    private var binding : FragmentMainHeaderBinding? = null
    private var navigationPasser : NavigationPasser? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is NavigationPasser) {
            navigationPasser = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        navigationPasser = activity as NavigationPasser
        val view = inflater.inflate(R.layout.fragment_main_header,container,false)
        binding = FragmentMainHeaderBinding.bind(view)
            .apply {
                navBtn.setOnClickListener {

                }

                locateBtn.setOnClickListener {
                }
            }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
        navigationPasser = null
    }
}

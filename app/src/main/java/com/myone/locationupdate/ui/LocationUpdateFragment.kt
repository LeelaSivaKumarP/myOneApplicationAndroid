package com.myone.locationupdate.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.myone.locationupdate.viewModels.LocationUpdateViewModel
import com.myone.databinding.LocationUpdateFragmentBinding

class LocationUpdateFragment : Fragment() {

    companion object {
        fun newInstance() = LocationUpdateFragment()
    }

    private lateinit var binding: LocationUpdateFragmentBinding
    private lateinit var viewModel: LocationUpdateViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LocationUpdateViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = LocationUpdateFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

}
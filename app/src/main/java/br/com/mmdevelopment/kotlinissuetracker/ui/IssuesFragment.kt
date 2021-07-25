package br.com.mmdevelopment.kotlinissuetracker.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import br.com.mmdevelopment.kotlinissuetracker.R
import br.com.mmdevelopment.kotlinissuetracker.databinding.FragmentIssuesBinding

class IssuesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentIssuesBinding>(
            inflater,
            R.layout.fragment_issues,
            container,
            false
        )


        return binding.root
    }
}
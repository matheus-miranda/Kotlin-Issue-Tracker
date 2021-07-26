package br.com.mmdevelopment.kotlinissuetracker.ui

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import br.com.mmdevelopment.kotlinissuetracker.R
import br.com.mmdevelopment.kotlinissuetracker.databinding.FragmentIssuesBinding
import br.com.mmdevelopment.kotlinissuetracker.presentation.IssuesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class IssuesFragment : Fragment() {

    private lateinit var binding: FragmentIssuesBinding
    private val viewModel by viewModel<IssuesViewModel>()
    private val adapter by lazy { IssueListAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_issues, container, false)

        setHasOptionsMenu(true)
        binding.rvIssues.adapter = adapter

        viewModel.getIssues("JetBrains", "kotlin")
        viewModel.issues.observe(viewLifecycleOwner) {
            when (it) {
                IssuesViewModel.State.Loading -> {}
                is IssuesViewModel.State.Error -> {}
                is IssuesViewModel.State.Success -> {
                    adapter.submitList(it.list)
                }
            }
        }
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        menu.clear()
        inflater.inflate(R.menu.fragment_issues_menu, menu)
        val searchView = (menu.findItem(R.id.action_search)).actionView as SearchView
        getSearchInput(searchView)
    }

    /**
     * Capture keyboard input
     */
    private fun getSearchInput(searchView: SearchView) {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {

                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                return false
            }
        })
    }
}
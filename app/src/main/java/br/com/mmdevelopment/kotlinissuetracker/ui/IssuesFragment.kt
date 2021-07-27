package br.com.mmdevelopment.kotlinissuetracker.ui

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.mmdevelopment.kotlinissuetracker.R
import br.com.mmdevelopment.kotlinissuetracker.core.createDialog
import br.com.mmdevelopment.kotlinissuetracker.core.createProgressDialog
import br.com.mmdevelopment.kotlinissuetracker.core.hideSoftKeyboard
import br.com.mmdevelopment.kotlinissuetracker.data.model.Issue
import br.com.mmdevelopment.kotlinissuetracker.databinding.FragmentIssuesBinding
import br.com.mmdevelopment.kotlinissuetracker.presentation.IssuesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class IssuesFragment : Fragment() {

    private lateinit var binding: FragmentIssuesBinding
    private val viewModel by viewModel<IssuesViewModel>()
    private val adapter by lazy { IssueListAdapter { clickedListItem(it) } }
    private val dialog by lazy { context?.createProgressDialog() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_issues, container, false)

        setHasOptionsMenu(true)
        binding.rvIssues.adapter = adapter

        viewModel.issues.observe(viewLifecycleOwner) {
            when (it) {
                IssuesViewModel.State.Loading -> {
                    dialog?.show()
                }
                is IssuesViewModel.State.Error -> {
                    context?.createDialog {
                        setMessage(it.error.message)
                    }?.show()
                    dialog?.dismiss()
                }
                is IssuesViewModel.State.Success -> {
                    dialog?.dismiss()
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
                query?.let { viewModel.getIssues("JetBrains", it) }
                binding.root.hideSoftKeyboard()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
    }

    /**
     * Called whenever user clicks an item
     */
    private fun clickedListItem(item: Issue) {
        findNavController().navigate(
            IssuesFragmentDirections.actionIssuesFragmentToDetailsFragment(
                item
            )
        )
    }
}
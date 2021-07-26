package br.com.mmdevelopment.kotlinissuetracker.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.mmdevelopment.kotlinissuetracker.data.model.Issue
import br.com.mmdevelopment.kotlinissuetracker.databinding.ItemIssueBinding

class IssueListAdapter : ListAdapter<Issue, IssueListAdapter.ViewHolder>(DiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemIssueBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemIssueBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Issue) {
            binding.tvRepoState.text = item.state
            binding.tvRepoTitle.text = item.title
        }
    }
}

class DiffCallBack : DiffUtil.ItemCallback<Issue>() {
    override fun areItemsTheSame(oldItem: Issue, newItem: Issue) = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: Issue, newItem: Issue) = oldItem == newItem
}

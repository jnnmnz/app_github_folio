package com.gitportfolio.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gitportfolio.data.model.Repo
import com.gitportfolio.databinding.ItemRepBinding

class RepoListAdapter : ListAdapter<Repo, RepoListAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRepBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemRepBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Repo) {
            binding.tvRName.text = item.name
            binding.tvRDescription.text = item.description
            binding.tvRLanguage.text = item.language
            binding.chipStar.text = item.stargazersCount.toString()

            Glide.with(binding.root.context)
                .load(item.owner.avatarURL).into(binding.ivOwner)
        }
    }
}

class DiffCallback : DiffUtil.ItemCallback<Repo>() {
    override fun areItemsTheSame(oldItem: Repo, newItem: Repo) = oldItem == newItem
    override fun areContentsTheSame(oldItem: Repo, newItem: Repo) = oldItem.id == newItem.id
}
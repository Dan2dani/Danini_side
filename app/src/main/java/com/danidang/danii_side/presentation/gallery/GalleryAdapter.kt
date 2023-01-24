package com.danidang.danii_side.presentation.gallery

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.danidang.danii_side.databinding.ItemFavoriteBinding
import com.danidang.danii_side.type.FavoriteViewType

class GalleryAdapter(context: Context) : RecyclerView.Adapter<GalleryAdapter.FavoriteViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private var favoriteList = FavoriteViewType.values()

    init {
        notifyDataSetChanged()
    }

    class FavoriteViewHolder(private val binding: ItemFavoriteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(type: FavoriteViewType) {
            binding.type = type
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        return FavoriteViewHolder(ItemFavoriteBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.onBind(favoriteList[position])
    }

    override fun getItemCount(): Int = favoriteList.size
}
package com.ocwvar.darkpurple.Adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.ocwvar.darkpurple.AppConfigs
import com.ocwvar.darkpurple.Network.Beans.RemoteMusic
import com.ocwvar.darkpurple.R
import com.squareup.picasso.Picasso

/**
 * Project DarkPurple
 * Created by OCWVAR
 * On 2017/03/23 4:16 PM
 * File Location com.ocwvar.darkpurple.Adapters
 * This file use to :   云音乐列表适配器
 */
class CloudMusicAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val sourceList: ArrayList<RemoteMusic> = ArrayList()

    fun updateSource(source: ArrayList<RemoteMusic>) {
        sourceList.clear()
        sourceList.addAll(source)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder? {
        parent?.let {
            return CloudMusicViewHolder(LayoutInflater.from(it.context).inflate(R.layout.item_cloud_music, it, false))
        }
        return null
    }

    override fun getItemCount(): Int {
        return sourceList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        holder?.let {
            val item: RemoteMusic = sourceList[position]
            val viewHolder: CloudMusicViewHolder = it as CloudMusicViewHolder

            viewHolder.owner.text = String.format("%s%s", AppConfigs.ApplicationContext.getString(R.string.text_cloud_header_owner), item.ownerName)
            viewHolder.title.text = item.name
            Picasso.with(it.itemView.context).load(item.coverURL).into(viewHolder.cover)
        }
    }

    inner private class CloudMusicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        val title: TextView = itemView.findViewById(R.id.cloudMusic_title) as TextView
        val owner: TextView = itemView.findViewById(R.id.cloudMusic_owner) as TextView
        val cover: ImageView = itemView.findViewById(R.id.cloudMusic_cover) as ImageView

        init {
            itemView.findViewById(R.id.cloudMusic_download).setOnClickListener(this@CloudMusicViewHolder)
        }

        override fun onClick(v: View) {

        }
    }
}
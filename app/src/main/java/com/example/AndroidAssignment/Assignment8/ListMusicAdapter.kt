package com.example.AndroidAssignment.Assignment8

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinassignment.R

class ListMusicAdapter (
    private val mlistMusic: ArrayList<Music>
    ): RecyclerView.Adapter<ListMusicAdapter.MusicViewHolder>()
    {
        var onItemClick: ((Music) -> Unit)? = null

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
            val context: Context = parent.context
            val inflater = LayoutInflater.from(context)
            val musicView: View = inflater.inflate(R.layout.music, parent, false)
            return MusicViewHolder(musicView)
        }

        override fun onBindViewHolder(viewHolder: MusicViewHolder, position: Int) {
            val music: Music = mlistMusic[position]
            viewHolder.imgmusic!!.setImageResource(music.imgId)
            viewHolder.namemusic!!.text = String.format(music.nameMusic)
            viewHolder.timemusic!!.text = String.format( music.time)
            viewHolder.singermusic!!.text = String.format(music.singer)
            viewHolder.itemView.setOnClickListener {
                onItemClick?.invoke(music)
            }
        }

        override fun getItemCount(): Int {
            return mlistMusic.size
        }

        inner class MusicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var imgmusic: ImageView? = null
            var namemusic: TextView? = null
            var timemusic: TextView? = null
            var singermusic: TextView? = null

            init {
                imgmusic = itemView.findViewById(R.id.imgThreePoints) as ImageView
                namemusic = itemView.findViewById(R.id.txtNameMusic) as TextView
                timemusic = itemView.findViewById(R.id.txtTime) as TextView
                singermusic = itemView.findViewById(R.id.txtSinger) as TextView


            }
        }
    }
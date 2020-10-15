package com.example.madlevel4task2.ui

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getDrawable
import androidx.recyclerview.widget.RecyclerView
import com.example.madlevel4task2.R
import com.example.madlevel4task2.databinding.ItemGameBinding
import com.example.madlevel4task2.model.Game
import java.util.*

class GameItemAdapter (private val gameItems: List<Game>) :
    RecyclerView.Adapter<GameItemAdapter.ViewHolder>(){
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val binding =  ItemGameBinding.bind(itemView)

        fun dataBind(gameItem: Game){
            binding.tvDate.text = gameItem.data
            binding.tvResults.text = gameItem.result_of_game.replace(':', ' ')

            var actionDrawable: Drawable? = getActionDrawable(gameItem.cpu_movement)

            if(actionDrawable != null)
                binding.ivComputer.setImageDrawable(actionDrawable)

            actionDrawable = getActionDrawable(gameItem.player_movement)
            if(actionDrawable != null)
                binding.ivPlayer.setImageDrawable(actionDrawable)
        }

        private fun getActionDrawable(action: String) : Drawable? {
            return when (action.toLowerCase(Locale.ROOT)){
                itemView.context.getString(R.string.rock) -> getDrawable(itemView.context, R.drawable.rock)
                itemView.context.getString(R.string.paper) -> getDrawable(itemView.context, R.drawable.paper)
                itemView.context.getString(R.string.scissors) -> getDrawable(itemView.context, R.drawable.scissors)
                else -> null
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_game, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return gameItems.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.dataBind(gameItems[position])
    }
}
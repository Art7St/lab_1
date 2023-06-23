package com.example.lab_1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AnimalAdapter(
    private val animals: List<Animal>,
    private val onAnimalClickListener: OnAnimalClickListener
) : RecyclerView.Adapter<AnimalAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        val shortDescriptionTextView: TextView = itemView.findViewById(R.id.sloganTextView)
        val detailsButton: Button = itemView.findViewById(R.id.detailsButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.animal_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val animal = animals[position]

        holder.imageView.setImageResource(animal.imageRes)
        holder.nameTextView.text = animal.name
        holder.shortDescriptionTextView.text = animal.slogan

        holder.detailsButton.setOnClickListener {
            onAnimalClickListener.onClick(animal)
        }
    }

    override fun getItemCount(): Int {
        return animals.size
    }
}

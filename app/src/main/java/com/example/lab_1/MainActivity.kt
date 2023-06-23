package com.example.lab_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnAnimalClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onClick(animal: Animal) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra(DetailsActivity.ANIMAL_KEY, animal)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val animalList = listOf(
            Animal(
                name = "Peacock",
                slogan = "Colorful and flamboyant bird",
                longDescription = "The peacock is a beautiful and striking bird known for its extravagant plumage. Male peacocks, known as peafowls, have large and colorful tail feathers that they display during courtship rituals. The female peafowls, known as peahens, have more subdued feather patterns.",
                imageRes = R.drawable.peacock
            ),
            Animal(
                name = "Orangutan",
                slogan = "Intelligent and arboreal great ape",
                longDescription = "The orangutan is a highly intelligent and arboreal great ape native to the rainforests of Borneo and Sumatra. They have reddish-brown hair, long arms, and impressive strength. Orangutans are primarily solitary animals and spend most of their time in trees.",
                imageRes = R.drawable.orangutan
            ),
            Animal(
                name = "Koala",
                slogan = "Cute Australian marsupial",
                longDescription = "The koala is a cute and iconic marsupial native to Australia. They are known for their fluffy appearance, round faces, and large, fuzzy ears. Koalas primarily feed on eucalyptus leaves and spend most of their time in trees. They have a slow metabolism and sleep for up to 20 hours a day. Koalas are gentle and docile creatures, often seen clinging to tree branches.",
                imageRes = R.drawable.coala
            )
        )

        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        val dividerItemDecoration = DividerItemDecoration(this, layoutManager.orientation)
        binding.recyclerView.addItemDecoration(dividerItemDecoration)
        binding.recyclerView.adapter = AnimalAdapter(animalList, this)
    }
}

interface OnAnimalClickListener {
    fun onClick(animal: Animal)
}
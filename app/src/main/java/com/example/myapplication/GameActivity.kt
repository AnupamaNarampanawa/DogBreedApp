package com.example.myapplication

import android.content.Intent
import android.graphics.ColorFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random

class GameActivity : AppCompatActivity() {

    var dogBreeds = mutableListOf<String>()
    var dogDrawables = mutableListOf<Int>()
    var count=0
    var total=0

    var displayedBreeds= mutableListOf<String>()
    var randomNumberList= mutableListOf<Int>()
    var dogList = mutableMapOf(
        "beagle" to R.drawable.beagle,
        "boxer" to R.drawable.boxer,
        "cairn" to R.drawable.cairn,
        "basset" to R.drawable.basset,
        "chow" to R.drawable.chow
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        extractKeys(dogList)
        game()
    }

    fun extractKeys(map:Map<String,Int>){
        for((key,value)in map){
            dogBreeds.add(key)
        }
    }

    fun game(){

        if(count<5){
            var breedDisplayTextView=findViewById<TextView>(R.id.breedDisplay)
            var randomNumber=(0..dogBreeds.size-1).random()

            var displayBreedName=dogBreeds[randomNumber]

            while (displayBreedName in displayedBreeds){
                randomNumber=(0..dogBreeds.size-1).random()
                displayBreedName=dogBreeds[randomNumber]
            }
            breedDisplayTextView.setText(displayBreedName)

            displayedBreeds.add(displayBreedName)
            dogDrawables.add(dogList.get(displayBreedName)as Int)

            var imageView1random=(0..dogBreeds.size-1).random()
            var drawableInt=dogList.get(dogBreeds[imageView1random])
            while (drawableInt in dogDrawables){
                imageView1random=(0..dogBreeds.size-1).random()
                drawableInt=dogList.get(dogBreeds[imageView1random])
            }
            dogDrawables.add(dogList.get(dogBreeds[imageView1random])as Int)

            var imageView2random=(0..dogBreeds.size-1).random()
            var drawableInt2=dogList.get(dogBreeds[imageView2random])
            while(drawableInt2  in dogDrawables){
                imageView2random=(0..dogBreeds.size-1).random()
                drawableInt2=dogList.get(dogBreeds[imageView2random])
            }
            dogDrawables.add(dogList.get(dogBreeds[imageView2random])as Int)

            var imageButton1=findViewById<ImageView>(R.id.imageButton1)
            var imageButton2=findViewById<ImageView>(R.id.imageButton2)
            var imageButton3=findViewById<ImageView>(R.id.imageButton3)


            var randomForDrawable1=(0..dogDrawables.size-1).random()
            randomNumberList.add(randomForDrawable1)
            imageButton1.setImageResource(dogDrawables[randomForDrawable1])

            var randomForDrawable2=(0..dogDrawables.size-1).random()
            while (randomForDrawable2 in randomNumberList){
                randomForDrawable2=(0..dogDrawables.size-1).random()
            }
            randomNumberList.add(randomForDrawable2)
            imageButton2.setImageResource(dogDrawables[randomForDrawable2])

            var randomForDrawable3=(0..dogDrawables.size-1).random()
            while (randomForDrawable3 in randomNumberList){
                randomForDrawable3=(0..dogDrawables.size-1).random()
            }
            randomNumberList.add(randomForDrawable3)
            imageButton3.setImageResource(dogDrawables[randomForDrawable3])

            var checkAnswer = findViewById<TextView>(R.id.checkAnswer)
            var nextButton=findViewById<Button>(R.id.nextButton)

            imageButton1.setOnClickListener {
                if(dogList.get(displayBreedName)as Int == dogDrawables[randomForDrawable1]){
                    checkAnswer.setText("Correct")
                    nextButton.setOnClickListener {
                        total+=10
                        count+=1
                        dogDrawables.clear()
                        randomNumberList.clear()
                        checkAnswer.setText("")
                        game()
                    }
                }
            }
            imageButton2.setOnClickListener {
                if(dogList.get(displayBreedName)as Int == dogDrawables[randomForDrawable2]){
                    checkAnswer.setText("Correct")
                    nextButton.setOnClickListener {
                        total+=10
                        count+=1
                        dogDrawables.clear()
                        randomNumberList.clear()
                        checkAnswer.setText("")
                        game()
                    }
                }
            }
            imageButton3.setOnClickListener {
                if(dogList.get(displayBreedName)as Int == dogDrawables[randomForDrawable3]){
                    checkAnswer.setText("Correct")
                    nextButton.setOnClickListener {
                        total+=10
                        count+=1
                        dogDrawables.clear()
                        randomNumberList.clear()
                        checkAnswer.setText("")
                        game()
                    }
                }
            }
        }else{
            val GameOverIntent = Intent(this,DisplayScore::class.java).apply {
                putExtra("Score",total)
            }
            startActivity(GameOverIntent)
        }

    }

}
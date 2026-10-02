package com.example.templado_rapidrecall

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay
import kotlin.random.Random
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.milliseconds

class SequenceViewModel : ViewModel() {

    var generatedSequence by mutableStateOf("")
        private set

    var currentDigit by mutableStateOf("")
        private set

    fun startSequence(length: Int, onComplete: () -> Unit){

        //generate sequence
        generatedSequence = (1..length) //same as range() in py
            //run random.nextint for every int (note: 10 is not included)
            .map{Random.nextInt(0,10)}
            .joinToString("")

        //iterate through sequence and update currentDigit
        viewModelScope.launch {
            for (digit in generatedSequence) {
                currentDigit = digit.toString()
                delay(500L.milliseconds) //wait 0.5 second
            }
            currentDigit = "" //reset currentDigit

            onComplete() // trigger next screen event
        }




    }

}



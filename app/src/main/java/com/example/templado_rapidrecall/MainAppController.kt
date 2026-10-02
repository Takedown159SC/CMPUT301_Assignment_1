package com.example.templado_rapidrecall

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.templado_rapidrecall.ui.theme.ScreenDisplayCorrection
import com.example.templado_rapidrecall.ui.theme.ScreenDisplaySequence
import com.example.templado_rapidrecall.ui.theme.ScreenHome
import com.example.templado_rapidrecall.ui.theme.ScreenInputSequence
import com.example.templado_rapidrecall.ui.theme.ScreenRepeatOrSummary
import com.example.templado_rapidrecall.ui.theme.ScreenSelectSequence
import com.example.templado_rapidrecall.ui.theme.ScreenSummary
import kotlin.String


//Screen destinations
enum class Screen {
    Home,
    SelectSequence,
    DisplaySequence,
    InputSequence,
    DisplayCorrection,
    RepeatOrSummary,
    Summary
}

@Composable

fun MainAppController(
    //pass view models
    summaryViewModel: SummaryViewModel = remember {SummaryViewModel()},
    sequenceViewModel: SequenceViewModel = remember {SequenceViewModel()}
){

    var currentScreen by remember { mutableStateOf(Screen.Home) }

    // Game state variables
    var sequenceLength by remember { mutableIntStateOf(10) }
    var userInput by remember { mutableStateOf("") }

    when (currentScreen){
        Screen.Home ->{
            ScreenHome(
                onStartClick = {currentScreen = Screen.SelectSequence}
            )
        }

        Screen.SelectSequence -> {
            ScreenSelectSequence(
                sequenceLength = sequenceLength,
                onSequenceLengthChange = {sequenceLength = it},
                onPlayClick = {
                    currentScreen = Screen.DisplaySequence
                    sequenceViewModel.startSequence(
                        length = sequenceLength,
                        onComplete = { currentScreen = Screen.InputSequence}
                    )
                }
            )
        }

        Screen.DisplaySequence -> {
            ScreenDisplaySequence(
                currentDigit = sequenceViewModel.currentDigit
            )
        }

        Screen.InputSequence -> {
            ScreenInputSequence(
                onSubmitSequence = { input ->
                    userInput = input
                    currentScreen = Screen.DisplayCorrection
                    val summary = SummaryInfo(
                        sequence = sequenceViewModel.generatedSequence,
                        input = input,
                        timestamp = System.currentTimeMillis())
                    summaryViewModel.addSummary(summary)

                }
            )
        }

        Screen.DisplayCorrection -> {
            ScreenDisplayCorrection(
                isSequenceCorrect = (sequenceViewModel.generatedSequence == userInput),
                generatedSequence = sequenceViewModel.generatedSequence,
                inputSequence = userInput,
                onContinueClick = { currentScreen = Screen.RepeatOrSummary }

            )
        }

        Screen.RepeatOrSummary -> {
            ScreenRepeatOrSummary(
                onPlayAgainClick = {currentScreen = Screen.SelectSequence},
                onSummaryClick = {currentScreen = Screen.Summary}
            )
        }

        Screen.Summary -> {
            ScreenSummary(
                attempts = summaryViewModel.attempts,
                correctAttempts = summaryViewModel.correctAttempts,
                accuracy = summaryViewModel.accuracy,
                history = summaryViewModel.history,
                onBClick = {currentScreen = Screen.RepeatOrSummary}
            )

        }



    }




}
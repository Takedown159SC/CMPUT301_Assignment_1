package com.example.templado_rapidrecall.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Slider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.keepScreenOn
import com.example.templado_rapidrecall.SummaryInfo

@Composable
fun ScreenHome(
    onStartClick: () -> Unit = {}
){

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(
            top = 60.dp,
            bottom = 180.dp,
            start = 40.dp,
            end = 40.dp
        )
        //.background(Color.LightGray) //<- for testing
    ){
        Text(
            text = "Rapid Recall",
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = (-60).dp)
                .padding(start = 70.dp)

        )

        Text(
            text = "ID: 1743560",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = (20).dp)

        )
        Text(
            text = "CCID: templado",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = (50).dp)
        )
        Button(
            onClick = onStartClick,
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = (250).dp)
                .width(200.dp)
                .height(100.dp)

        ) {
            Text("Start",fontSize = 50.sp)
        }
    }
}







@Composable
fun ScreenSelectSequence(
    sequenceLength: Int = 0,
    onSequenceLengthChange: (Int) -> Unit = {},
    onPlayClick: () -> Unit = {}

){
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(
            top = 60.dp,
            bottom = 180.dp,
            start = 40.dp,
            end = 40.dp
        )
        //.background(Color.LightGray) //<- for testing
    ) {
        Text(
            text = "Sequence Length",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = (-60).dp)
                .padding(start = 0.dp)

        )

        Text(
            text = sequenceLength.toString(),
            fontSize = 70.sp,
            fontWeight = FontWeight.Bold,
            color = Color.DarkGray,
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = (20).dp) // Positioned directly under the title
        )

        Slider(
            value = sequenceLength.toFloat(),
            onValueChange = { newValue ->
                onSequenceLengthChange(newValue.toInt())
            },
            valueRange = 1f..10f,
            steps = 8,
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = (120).dp)
                .width(200.dp)
                .height(100.dp)
        )

        Button(
            onClick = onPlayClick,//<=============TODO================
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = (250).dp)
                .width(200.dp)
                .height(100.dp)

        ) {
            Text("Play",fontSize = 50.sp)
        }


    }

}




@Composable
fun ScreenDisplaySequence(
    currentDigit: String = ""
){
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(
            top = 60.dp,
            bottom = 180.dp,
            start = 40.dp,
            end = 40.dp
        )){

        Text(
            text = currentDigit,
            fontSize = 200.sp,
            fontWeight = FontWeight.Bold,
            color = Color.DarkGray,
            modifier = Modifier
                .align(Alignment.Center)

        )

        }
}

@Composable
fun ScreenInputSequence(
    onSubmitSequence: (String) -> Unit = {}
){
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(
            top = 60.dp,
            bottom = 180.dp,
            start = 40.dp,
            end = 40.dp
        )
        //.background(Color.LightGray) //<- for testing
    ){

        Text(
            text = "Input Sequence Below",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = (-60).dp)
                .padding(start = 0.dp)

        )

        var currentInput by remember { mutableStateOf("") }
        OutlinedTextField(
            value = currentInput,
            onValueChange = {currentInput = it},
            label = {Text("Enter Sequence")},
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = (40).dp)
                .padding(start = 0.dp)

        )

        Button(
            onClick = {
                onSubmitSequence(currentInput)
            },
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = (250).dp)
                .width(200.dp)
                .height(100.dp)
        ){
            Text("Submit",fontSize = 30.sp)
        }


    }


}

@Composable
fun ScreenDisplayCorrection(
    isSequenceCorrect: Boolean= true,
    generatedSequence: String = "12345678",
    inputSequence: String = "123456789",
    onContinueClick: () -> Unit = {}
){
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(
            top = 60.dp,
            bottom = 180.dp,
            start = 40.dp,
            end = 40.dp
        )
        //.background(Color.LightGray) //<- for testing
    ) {
        Text(
            text = if (isSequenceCorrect) "Correct!" else "Incorrect!",
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold,
            color = if (isSequenceCorrect) Color(0xFF006400) else Color.Red,
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = (-90).dp)
                .padding(start = 0.dp)

        )
        Text(
            text = "Correct Sequence: $generatedSequence",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = (10).dp)
                .padding(start = 10.dp)

        )

        Text(
            text = "Input Sequence: $inputSequence",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = (80).dp)
                .padding(start = 10.dp)

        )

        Button(
            onClick = onContinueClick,
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = (250).dp)
                .width(250.dp)
                .height(100.dp)
        ){
            Text("Continue",fontSize = 30.sp)
        }




    }

}

@Composable
fun ScreenRepeatOrSummary(
    onPlayAgainClick: () -> Unit = {},
    onSummaryClick: () -> Unit = {}
){
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(
            top = 60.dp,
            bottom = 180.dp,
            start = 40.dp,
            end = 40.dp
        )
        //.background(Color.LightGray) //<- for testing
    ) {
        Button(
            onClick = onPlayAgainClick,
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = (-100).dp)
                .width(300.dp)
                .height(200.dp)
        ){
            Text("Play Again",fontSize = 40.sp)
        }
        Button(
            onClick = onSummaryClick,
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = (150).dp)
                .width(300.dp)
                .height(200.dp)
        ){
            Text("Summary",fontSize = 40.sp)
        }
    }


}

@Composable
fun ScreenSummary(
    attempts: Int,
    correctAttempts: Int,
    accuracy: Double,
    history: List<SummaryInfo>,
    onBClick: () -> Unit = {}
){
    //Summary Header
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(
            top = 40.dp,
            bottom = 450.dp,
            start = 40.dp,
            end = 40.dp
        )
        //.background(Color.White) //<- for testing
    ) {
        Button(
            onClick = onBClick,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = (-20).dp)
                .width(85.dp)
                .height(45.dp)
        ){
            Text("BACK",fontSize = 12.sp)
        }
        Text(
            text = "Summary",
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = (0).dp)
                .padding(start = 10.dp)

        )
        Text(
            text = "Attempts: $attempts",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .offset(y = (-10).dp)
                .padding(start = 10.dp)

        )
        Text(
            text = "Correct: $correctAttempts",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .offset(y = (20).dp)
                .padding(start = 10.dp)

        )
        Text(
            text = "Accuracy: ${String.format("%.1f", accuracy)}%",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .offset(y = (50).dp)
                .padding(start = 10.dp)

        )
    }

    //Scrollable Past Attempt Views
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(
            top = 200.dp,
            bottom = 20.dp,
            start = 40.dp,
            end = 40.dp
        )
        //.background(Color.LightGray) //<- for testing
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ){
            items(history) { item ->

                Card(
                    Modifier
                        .fillMaxWidth()
                        .height(100.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)


                ) {
                    Text(
                        text = "Time: ${item.formattedTime}",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Sequence: ${item.sequence}",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Input: ${item.input}",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier
                    )
                }

            }
        }


    }

}
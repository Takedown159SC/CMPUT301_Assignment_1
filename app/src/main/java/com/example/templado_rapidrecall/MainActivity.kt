package com.example.templado_rapidrecall

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.templado_rapidrecall.SummaryInfo
import com.example.templado_rapidrecall.ui.theme.ScreenDisplayCorrection
import com.example.templado_rapidrecall.ui.theme.ScreenDisplaySequence
import com.example.templado_rapidrecall.ui.theme.ScreenHome
import com.example.templado_rapidrecall.ui.theme.ScreenInputSequence
import com.example.templado_rapidrecall.ui.theme.ScreenRepeatOrSummary
import com.example.templado_rapidrecall.ui.theme.ScreenSelectSequence
import com.example.templado_rapidrecall.ui.theme.ScreenSummary



val sampleHistory = listOf(
    SummaryInfo(sequence = "1234", input = "1234", timestamp = System.currentTimeMillis()),
    SummaryInfo(sequence = "5678", input = "5679", timestamp = System.currentTimeMillis() - 30000),
    SummaryInfo(sequence = "98765", input = "98765", timestamp = System.currentTimeMillis() - 60000),
    SummaryInfo(sequence = "112233", input = "112233", timestamp = System.currentTimeMillis() - 90000),
    SummaryInfo(sequence = "445566", input = "445577", timestamp = System.currentTimeMillis() - 120000),
    SummaryInfo(sequence = "778899", input = "778899", timestamp = System.currentTimeMillis() - 150000),
    SummaryInfo(sequence = "1234567", input = "1234560", timestamp = System.currentTimeMillis() - 180000),
    SummaryInfo(sequence = "890123", input = "890123", timestamp = System.currentTimeMillis() - 210000),
    SummaryInfo(sequence = "321654", input = "321654", timestamp = System.currentTimeMillis() - 240000),
    SummaryInfo(sequence = "999888", input = "999887", timestamp = System.currentTimeMillis() - 270000)
)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color(0xFF87CEEB)

            ){
                MainAppController()
//                ScreenSummary(
//                    attempts = 0,
//                    correctAttempts = 0,
//                    accuracy = 1.0,
//                    history = sampleHistory
//                )
            }

            }
        }
    }



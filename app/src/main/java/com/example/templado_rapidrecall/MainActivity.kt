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
import com.example.templado_rapidrecall.ui.theme.ScreenDisplayCorrection
import com.example.templado_rapidrecall.ui.theme.ScreenDisplaySequence
import com.example.templado_rapidrecall.ui.theme.ScreenHome
import com.example.templado_rapidrecall.ui.theme.ScreenInputSequence
import com.example.templado_rapidrecall.ui.theme.ScreenRepeatOrSummary
import com.example.templado_rapidrecall.ui.theme.ScreenSelectSequence

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color(0xFF87CEEB)

            ){
                ScreenRepeatOrSummary()
            }

            }
        }
    }



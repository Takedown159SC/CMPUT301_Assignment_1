package com.example.templado_rapidrecall

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

// Data class representing a single sequence attempt
data class SummaryInfo(
    val sequence: String,
    val input: String,
    val timestamp: Long
) {
    val isCorrect: Boolean
        get() = sequence == input

    //formats millisecond time into standard hour:minute:second AM/PM
    val formattedTime: String
        get() {
            val formatter = SimpleDateFormat("h:mm:ss a", Locale.getDefault())
            return formatter.format(Date(timestamp))
        }
}

// ViewModel managing UI state and attempt history
class SummaryViewModel : ViewModel() {


    // Compose state list for recorded attempts
    private val _history = mutableStateListOf<SummaryInfo>()
    val history: List<SummaryInfo> get() = _history

    var attempts by mutableIntStateOf(0)
        private set

    var correctAttempts by mutableIntStateOf(0)
        private set

    val accuracy: Double
        get() = if (attempts > 0) (correctAttempts.toDouble() / attempts) * 100.0 else 0.0


    //updates attempt info, and attempt information into list
    fun addSummary(summary: SummaryInfo) {
        _history.add(summary)
        attempts++
        if (summary.isCorrect) {
            correctAttempts++
        }
    }


}

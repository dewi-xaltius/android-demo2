package com.example.studentapp // IMPORTANT: Change this to your desired package name for StudentApp

import android.os.Bundle
// No Toast import needed anymore
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll // For scrolling if content overflows
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
// No LocalContext import needed anymore
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studentapp.ui.theme.StudentAppTheme // Ensure your theme name matches

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StudentAppTheme { // Use your app's theme
                StudentAppScreen()
            }
        }
    }
}

@Composable
fun StudentAppScreen() {
    // State variables for each input field
    var studentName by remember { mutableStateOf("") }
    var studentEmail by remember { mutableStateOf("") }
    var studentStatus by remember { mutableStateOf("") }
    // New state variable to hold the displayed info
    var displayedStudentInfo by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState()) // Make the column scrollable
            .padding(24.dp), // Overall padding for the entire screen content
        horizontalAlignment = Alignment.CenterHorizontally // Center content horizontally
    ) {
        // App Title
        Text(
            text = "StudentApp",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        // Student Name Field
        OutlinedTextField(
            value = studentName,
            onValueChange = { studentName = it },
            label = { Text("Student Name") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Student Email Field
        OutlinedTextField(
            value = studentEmail,
            onValueChange = { studentEmail = it },
            label = { Text("Student Email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Student Status Field (read-only, set by buttons)
        OutlinedTextField(
            value = studentStatus,
            onValueChange = { /* This field is set by buttons, so onValueChange is empty for manual input */ },
            label = { Text("Student Status") },
            readOnly = true, // Makes the text field not editable by keyboard
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Full Time / Part Time Buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = { studentStatus = "Full Time" },
                modifier = Modifier.weight(1f)
            ) {
                Text("Full Time")
            }

            Spacer(modifier = Modifier.width(16.dp))

            Button(
                onClick = { studentStatus = "Part Time" },
                modifier = Modifier.weight(1f)
            ) {
                Text("Part Time")
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Display Student Info Button
        Button(
            onClick = {
                // Update the state variable that holds the info to be displayed
                displayedStudentInfo = "Name: $studentName\nEmail: $studentEmail\nStatus: $studentStatus"
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Display Student Info")
        }

        Spacer(modifier = Modifier.height(24.dp)) // Space before the displayed info

        // Text composable to display the student information
        Text(
            text = displayedStudentInfo,
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun StudentAppPreview() {
    StudentAppTheme {
        StudentAppScreen()
    }
}

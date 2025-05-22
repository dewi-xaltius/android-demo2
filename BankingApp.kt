package com.example.bankingapp // IMPORTANT: Make sure this matches your actual package name

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions // For input types
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType // For input types
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bankingapp.ui.theme.BankingAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BankingAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BankingAppScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BankingAppScreen() {
    // State variables for each input field
    var accountNo by remember { mutableStateOf("") }
    var accountName by remember { mutableStateOf("") }
    var accountType by remember { mutableStateOf("") }
    var accountBalance by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("BankingApp") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp), // Overall padding for the content
            horizontalAlignment = Alignment.CenterHorizontally // Center content horizontally
        ) {
            // Account No. Field
            OutlinedTextField(
                value = accountNo,
                onValueChange = { accountNo = it },
                label = { Text("Account No") }, // Label now acts as hint/description
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number), // Assuming account no is numbers
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp)) // Space below the field

            // Account Name Field
            OutlinedTextField(
                value = accountName,
                onValueChange = { accountName = it },
                label = { Text("Account Name") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text), // Text input
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Account Type Field
            OutlinedTextField(
                value = accountType,
                onValueChange = { accountType = it },
                label = { Text("Account Type") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text), // Text input
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Account Balance Field
            OutlinedTextField(
                value = accountBalance,
                onValueChange = { accountBalance = it },
                label = { Text("Account Balance") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number), // Number input
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(32.dp)) // More space before the button

            // SET AN ACCOUNT TYPE Button
            Button(
                onClick = {
                    // When the user clicks the button, fill the account type field
                    accountType = "Savings Account"
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("SET AN ACCOUNT TYPE")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BankingAppPreview() {
    BankingAppTheme {
        BankingAppScreen()
    }
}

package com.example.loginscreen2

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.loginscreen2.ui.theme.Black
import com.example.loginscreen2.ui.theme.focusedTextFieldText
import com.example.loginscreen2.ui.theme.textFileConteainer
import com.example.loginscreen2.ui.theme.unfocusedTextFieldText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginTextField(
    modifier: Modifier = Modifier,
    label:String,
    trailing :String
) {
    val uiColor = if (isSystemInDarkTheme()) Color.White else Black
   TextField(
       modifier =modifier,
       value = "",
       onValueChange ={},
       label = {
           Text(text = label, style = MaterialTheme.typography.labelMedium, color = uiColor)
       },
       colors = TextFieldDefaults.textFieldColors(
           unfocusedLabelColor = MaterialTheme.colorScheme.unfocusedTextFieldText,
           focusedLabelColor = MaterialTheme.colorScheme.focusedTextFieldText,
           containerColor = MaterialTheme.colorScheme.textFileConteainer ,
      //     containerColor = MaterialTheme.colorScheme.textFileConteainer
       ),
       trailingIcon = {
           TextButton(onClick = { /*TODO*/ }) {
               Text(text = trailing,
                   style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Medium),
                   color = uiColor
                   )
           }
       }
   )
}

@Preview
@Composable
fun PreviewTextField() {
    LoginTextField(label = "ffff", trailing = "Ffffff" )
}
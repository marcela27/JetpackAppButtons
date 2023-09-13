package com.example.botoes_debug_warning_info_compose

//Vek Histories

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ElevatedButton
import androidx.compose.ui.unit.dp
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.botoes_debug_warning_info_compose.ui.theme.BotoesDebugWarningInfoComposeTheme
import com.example.botoes_debug_warning_info_compose.ui.theme.DebugButtonCollors
import com.example.botoes_debug_warning_info_compose.ui.theme.ErrorButtonCollors
import com.example.botoes_debug_warning_info_compose.ui.theme.InfoButtonCollors
import com.example.botoes_debug_warning_info_compose.ui.theme.WarningButtonCollors
import com.example.botoes_debug_warning_info_compose.ui.theme.darkBlue
import com.example.botoes_debug_warning_info_compose.ui.theme.darkTheme
import com.example.botoes_debug_warning_info_compose.ui.theme.glittergold

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BotoesDebugWarningInfoComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize().background(darkTheme),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
private fun App() {
    val context = LocalContext.current

    Surface(
        modifier = Modifier.fillMaxSize().background(darkTheme)
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Greeting("Marcela","22386")

            ActionButton(text = "Debug",
                icon = Icons.Filled.Build,
                buttonColors = DebugButtonCollors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                Toast.makeText(context, "Clicou em DEBUG!", Toast.LENGTH_SHORT).show()
                Log.d(TAG, "App: Clicou em DEBUG...")
            }

            ActionButton(text = "Info",
                icon = Icons.Filled.Info,
                buttonColors = InfoButtonCollors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                Toast.makeText(context, "Clicou em INFO!", Toast.LENGTH_SHORT).show()
                Log.i(TAG, "App: Clicou em INFO...")
            }

            ActionButton(text = "Warning",
                icon = Icons.Filled.Warning,
                buttonColors = WarningButtonCollors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                Toast.makeText(context, "Clicou em WARNING!", Toast.LENGTH_SHORT).show()
                Log.w(TAG, "App: Clicou em WARNING...")
            }

            ActionButton(text = "Error!",
                icon = Icons.Filled.Close,
                buttonColors = ErrorButtonCollors(),
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                try {
                    Toast.makeText(context, "Clicou em ERROR!", Toast.LENGTH_SHORT).show()
                    throw RuntimeException("Clicou em ERROR...")
                } catch (ex: Exception) {
                    Log.e(TAG, "${ex.message}")
                }
            }
        }
    }
}

@Composable
fun ActionButton(
    text: String,
    icon: ImageVector,
    modifier: Modifier = Modifier,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(),
    block: () -> Unit,
){
    ElevatedButton(onClick = block,
        shape = RoundedCornerShape(5.dp),
        colors = buttonColors,
        modifier = modifier
    ) {
        Icon(
            imageVector = icon,
            tint = Color.White,
            contentDescription = "Executar",
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text(text = text, color = Color.White)
    }
}

@Composable
fun Greeting(str1: String, str2: String, modifier: Modifier = Modifier) {
    Surface{
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.rj),
                contentDescription = stringResource(id = R.string.image_content_description),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(200.dp)
                    .clip(CircleShape)
            )

            Text(
                text = str1,
                modifier = modifier,
                fontSize = 25.sp,
                color = darkBlue,
                textAlign = TextAlign.Center
            )

            Text(
                text = str2,
                modifier = modifier,
                fontSize = 25.sp,
                color = darkBlue,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BotoesDebugWarningInfoComposeTheme {
        App()
    }
}
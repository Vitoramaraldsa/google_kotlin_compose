package com.example.google_compose_course
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.google_compose_course.ui.theme.Google_compose_courseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Google_compose_courseTheme {
                MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}
@Composable
fun MyApp(
    modifier: Modifier = Modifier,
    names: List<String> = listOf("World", "Compose")
) {
    Column(modifier = modifier.padding(vertical = 4.dp)) {
        for (name in names) {
            Greeting(name = name)
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var expanded = remember { mutableStateOf(false)}
    var extraPadding = if(expanded.value) 48.dp else 0.dp
    Surface(modifier = modifier.padding(vertical = 4.dp, horizontal = 8.dp), color = MaterialTheme.colorScheme.primary) {
        Row(modifier = Modifier.padding(24.dp)){
            Column(modifier = Modifier.weight(1f).padding(bottom = extraPadding)){
                Text(text = "hello")
                Text(text = name)
            }
            ElevatedButton(
                onClick = {
                   expanded.value = !expanded.value
                }
            ) {
                Text(if(expanded.value) "Show less" else "Show more")
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Google_compose_courseTheme {
        MyApp()
    }
}
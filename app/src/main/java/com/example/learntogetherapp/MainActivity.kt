package com.example.learntogetherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learntogetherapp.ui.theme.LearnTogetherAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearnTogetherAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   Surface (
                       modifier = Modifier.fillMaxSize(),
                       color = MaterialTheme.colorScheme.background)
                    {
                       ComposeArticleImage(
                           firstText = stringResource(R.string.title_text) ,
                           seconText = stringResource(R.string.paragraph_one_text) ,
                           thirdText = stringResource(R.string.tutorial_description_text)
                       )
                    }
                }
            }
        }
    }
}



@Composable
fun ComposeArticle(firstText: String, seconText: String, thirdText: String, modifier: Modifier = Modifier){
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(top = 120.dp)) {
        Text(
            text = firstText,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 16.dp,
                    top = 16.dp
                )
                .align(alignment = Alignment.Start)
        )
        Text(
            text = seconText,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    end = 16.dp
                )
                .align(alignment = Alignment.CenterHorizontally)

        )
        Text(
            text = thirdText,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 16.dp,
                    top = 16.dp
                )
                .align(alignment = Alignment.CenterHorizontally)

        )


    }
}

@Composable
fun ComposeArticleImage(firstText: String, seconText: String, thirdText: String, modifier: Modifier = Modifier){

    val image = painterResource(id = R.drawable.bg_compose_background);

    Box(modifier = Modifier){
        Image(
            painter = image,
            contentDescription =null,
            contentScale = ContentScale.Fit)
        ComposeArticle(
            firstText =firstText ,
            seconText =seconText ,
            thirdText =thirdText,
            modifier = Modifier.fillMaxSize()
                .padding(8.dp))
    }

}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LearnTogetherAppTheme {
        ComposeArticleImage(
            firstText = stringResource(R.string.title_text) ,
            seconText = stringResource(R.string.paragraph_one_text) ,
            thirdText = stringResource(R.string.tutorial_description_text)
        )
    }
}
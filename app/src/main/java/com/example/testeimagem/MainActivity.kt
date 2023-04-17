package com.example.testeimagem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testeimagem.ui.theme.TesteImagemTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TesteImagemTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ImagemFundo()
                }
            }
        }
    }
}

@Composable
fun ImagemFundo() {

    Image(
        painter = painterResource(id = R.drawable.fundo3),
        contentDescription = null,
        contentScale = ContentScale.Crop
    )

    Box{
        Column (
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally

        ){
            Cabecalho()
            Rodape()
        }

    }

}

@Composable
fun Cabecalho() {

    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(

            painter = painterResource(id = R.drawable.senailogo),
            contentDescription = null,
            modifier = Modifier
                .size(200.dp)

        )

        Text(
            modifier = Modifier
                .padding(top = 1.dp),
            text = "Rafael Costa",
            color = Color.White,
            fontSize = 45.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier = Modifier
                .padding(top = 5.dp),
            text = "Professor",
            fontSize = 35.sp,
            color = Color.Gray,
            fontWeight = FontWeight.Bold
        )
    }

}

@Composable
fun Rodape() {

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(16.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.Start
    ) {

        Contatos(
            painter = painterResource(id = R.drawable.iconetelefone),text = "(11) 91234-5678"
        )
        Contatos(
            painter = painterResource(id = R.drawable.iconeemail), text = "rafael.costa@sp.senai.br"
        )
        Contatos(
            painter = painterResource(id = R.drawable.iconeemail), text = "rafaelcost@gmail.com"
        )
    }

}

@Composable
fun Contatos(painter: Painter, text:String){

    Spacer(
        modifier = Modifier
            .drawWithCache {
                val path = Path()
                path.moveTo(0f, 0f)
                path.lineTo(size.width, 0f)
                path.close()
                onDrawBehind {
                    drawPath(path, Color.Gray, style = Stroke(width = 3f))
                }
            }
            .fillMaxWidth()
    )
    Row (
        modifier = Modifier
            .padding(top = 10.dp)
    ){

        Image(
            painter = painter,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(35.dp)
                .clip(CircleShape)
        )
        Text(
            text = text,
            fontSize = 25.sp,
            color = Color.Gray,
            textAlign = TextAlign.Left,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, bottom = 15.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

    TesteImagemTheme {
        ImagemFundo()
    }
}

package com.example.testeimagem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
            Teste()
        }
    }
}


fun Teste() {

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
            text = stringResource(R.string.nomeCompleto),
            color = Color.White,
            fontSize = 45.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier = Modifier
                .padding(top = 5.dp),
            text = stringResource(R.string.cargo),
            fontSize = 35.sp,
            color = Color.Red,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun Rodape() {

    Column (
        modifier = Modifier
            .fillMaxHeight()
            .padding(10.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.Start
    ) {

        Contatos(
            painter = painterResource(id = R.drawable.iconetelefone),
            text = stringResource(R.string.telefone)
        )
        Contatos(
            painter = painterResource(id = R.drawable.iconeemail),
            text = stringResource(R.string.email1)
        )
        Contatos(
            painter = painterResource(id = R.drawable.iconeemail),
            text = stringResource(R.string.email2)
        )
    }

}

@Composable
fun Contatos(painter: Painter, text:String){

    Divider(
        color = Color.LightGray,
        modifier = Modifier
            .fillMaxWidth()
            .height(0.5.dp)
    )

    Row (
        modifier = Modifier
            .padding(top = 10.dp, start = 30.dp)
    ){

        Image(
            painter = painter,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(30.dp)
                .clip(CircleShape)
        )
        Text(
            text = text,
            fontSize = 25.sp,
            color = Color.LightGray,
            textAlign = TextAlign.Left,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, bottom = 15.dp)
        )
    }
}

@Preview(  )
@Composable
fun DefaultPreview() {

    TesteImagemTheme {
        ImagemFundo()
    }
}

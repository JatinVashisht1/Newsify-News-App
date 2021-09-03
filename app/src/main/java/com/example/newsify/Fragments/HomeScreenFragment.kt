package com.example.newsify.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.animation.FastOutSlowInEasing
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import coil.compose.rememberImagePainter
import com.example.newsify.domain.model.Article
import com.example.newsify.ui.theme.NewsifyTheme
import com.example.newsify.viewmodels.NewsViewModel

class HomeScreenFragment : Fragment() {
    val viewModel by viewModels<NewsViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext())
            .apply {
                setContent {
                    NewsifyTheme {
                        val newsList by viewModel.responses
                        Log.d("HomeScreen", "$newsList from HomeScreenFragment")
                        ShowList(newsList)
                    }
                }
            }
    }

}

/**
 * This function is used to define a custom list of news items
 */
@Composable
fun ShowList(newsList: List<Article>) {

    LazyColumn {
        newsList?.let {
            items(items = it.toList()) { news ->
                CustomNews(item = news)
            }
        }
    }

}


/**
 * This function defines the properties of single news item
 */
@Composable
fun CustomNews(item: Article) {
    var cardExp by rememberSaveable { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .padding(8.dp)
            .shadow(elevation = 16.dp, clip = true)

    ) {
        Column(
            modifier = Modifier
                .background(color = MaterialTheme.colors.background)
                .fillMaxSize()
                .animateContentSize(
                    tween(
                        durationMillis = 400,
                        easing = FastOutSlowInEasing
                    )
                )
                .clickable {
                    cardExp = !cardExp
                },
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,

            ) {

            Card(modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .padding(8.dp)
                .shadow(8.dp)
            ){
                Image(painter = rememberImagePainter(
                    data = item.urlToImage,

                ), contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    )
            }

            Box(
                modifier = Modifier
                    .padding(4.dp)
                    .wrapContentSize()
            ) {
                Column() {
                    Text(text = item.title, fontWeight = FontWeight.Bold ,color = MaterialTheme.colors.onBackground)
                    Spacer(modifier = Modifier.padding(8.dp))
                    if (cardExp) {
                        if (item.description != null) {
                            Text(
                                text = item?.description,
                                color = MaterialTheme.colors.onBackground
                            )
                        }
                    }
                }

            }

        }
    }
}



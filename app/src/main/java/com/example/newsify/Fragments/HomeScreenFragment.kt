package com.example.newsify.Fragments

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.animation.FastOutSlowInEasing
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import com.example.newsify.domain.model.Article
import com.example.newsify.ui.theme.NewsifyTheme
import com.example.newsify.viewmodels.NewsViewModel


//var nnList: MutableLiveData<List<Article>> = MutableLiveData()

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
                        ShowList(viewModel)
                    }
                }
            }
    }

}

@Composable
fun ShowList(viewModel: NewsViewModel) {

    val a by viewModel.response.observeAsState()
    val b = rememberSaveable { mutableStateOf(a) }
    val c by viewModel.response.observeAsState()
    Log.d("HomeScreen", c.toString())
//    Text(c?.get(1)?.title.toString(), color = Color.White)
    LazyColumn {
        c?.let {
            items(items = it.toList()) { news ->
                CustomNews(item = news)
            }
        }
    }

//    LazyColumn{
//        c?.let {
//            items(items = it.toList()){item ->
//                CustomNews(item = item)
//            }
//        }
//    }
}

@Composable
fun CustomNews(item: Article) {


//    Text(item.title)

    var cardExp by rememberSaveable { mutableStateOf(false) }
//var item2 by rememberSaveable{ mutableStateOf(item) }
    Card(
        modifier = Modifier
            .padding(8.dp)
            .shadow(elevation = 16.dp, clip = true)

    ) {
        Column(
            modifier = Modifier
//                .padding(8.dp)
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
            Box(
                modifier = Modifier
                    .padding(4.dp)
                    .wrapContentSize()
            ) {
                Column() {
                    Text(text = item.title, color = MaterialTheme.colors.onBackground)
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



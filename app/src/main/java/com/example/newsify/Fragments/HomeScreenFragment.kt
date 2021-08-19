package com.example.newsify.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MenuDefaults
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import com.example.newsify.ui.theme.NewsifyTheme

class HomeScreenFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
            return ComposeView(requireContext())
                .apply {
                   setContent {
                       NewsifyTheme {
                           FirstScreen()
                       }
                   }
                }
    }
}

@Composable
fun FirstScreen() {
    Column(

    ) {
        TopAppBar(modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()

        ) {
            Text("Newsify", fontSize = 20.sp, color = Color.White)
        }

        Card(
            modifier = Modifier
                .padding(8.dp)
        ){
            Text("Newsify", color = Color.White)
        }
    }
}
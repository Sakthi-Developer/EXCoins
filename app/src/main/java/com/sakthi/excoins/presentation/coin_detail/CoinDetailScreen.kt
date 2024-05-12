package com.sakthi.excoins.presentation.coin_detail

import CoinTag
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.sakthi.excoins.presentation.coin_detail.component.TeamListItems

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CoinDetailScreen(
    viewModel: CoinDetailViewModel = hiltViewModel()
) {
    
    val state = viewModel.state.value

    Box(modifier = Modifier.fillMaxSize()) {

        state.coin?.let {coin ->

            LazyColumn (modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(20.dp)){
                item {
                    Row(
                        Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "${coin.rank}. ${coin.name} (${coin.symbol})",
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.weight(8f)
                        )

                        //AsyncImage(model = , contentDescription = , imageLoader = )
                        Text(
                            text = if (coin.isActive) "active" else "inactive",
                            color = if (coin.isActive) Color.Green else Color.Red,
                            textAlign = TextAlign.End,
                            fontStyle = FontStyle.Italic,
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .weight(2f),
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = coin.description,
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = "Tags",
                        style = MaterialTheme.typography.bodySmall
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    FlowRow(
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        coin.tag.forEach { tag ->
                            CoinTag(tag = tag)
                        }
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = "Team Members",
                        style = MaterialTheme.typography.bodySmall
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                }
                items(coin.team.size){ teamMember ->

                    TeamListItems(
                        teamMember = coin.team[teamMember],
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                    )
                }
            }

        }

        if (state.error.isNotBlank()) {
            Text(text = state.error,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp))
        }

        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }


}

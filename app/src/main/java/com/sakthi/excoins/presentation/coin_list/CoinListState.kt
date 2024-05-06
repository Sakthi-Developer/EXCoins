package com.sakthi.excoins.presentation.coin_list

import com.sakthi.excoins.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> =  emptyList(),
    val error:String = ""
)

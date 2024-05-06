package com.sakthi.excoins.presentation.coin_detail

import com.sakthi.excoins.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading:Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)

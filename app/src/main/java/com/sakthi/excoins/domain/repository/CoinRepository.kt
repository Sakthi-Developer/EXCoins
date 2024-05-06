package com.sakthi.excoins.domain.repository

import com.sakthi.excoins.data.remote.dto.CoinDetailDto
import com.sakthi.excoins.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String) : CoinDetailDto
}

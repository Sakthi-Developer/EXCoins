package com.sakthi.excoins.data.repository

import com.sakthi.excoins.data.remote.CoinPaprikaApi
import com.sakthi.excoins.data.remote.dto.CoinDetailDto
import com.sakthi.excoins.data.remote.dto.CoinDto
import com.sakthi.excoins.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
): CoinRepository{

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }

}
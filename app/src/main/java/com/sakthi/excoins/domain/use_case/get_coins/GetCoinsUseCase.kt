package com.sakthi.excoins.domain.use_case.get_coins

import retrofit2.HttpException
import com.sakthi.excoins.common.Resource
import com.sakthi.excoins.data.remote.dto.toCoin
import com.sakthi.excoins.domain.model.Coin
import com.sakthi.excoins.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {

        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage?:"An Unexpected Error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach the server Check your internet connection "))
        }

    }

}
package com.sakthi.excoins.domain.use_case.get_coin

import com.sakthi.excoins.common.Resource
import com.sakthi.excoins.data.remote.dto.toCoinDetail
import com.sakthi.excoins.domain.model.CoinDetail
import com.sakthi.excoins.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {

            try {
                emit(Resource.Loading())
                val coin = repository.getCoinById(coinId).toCoinDetail()
                emit(Resource.Success(coin))
            } catch (e: HttpException) {
                emit(Resource.Error(e.localizedMessage?:"An Unexpected Error occurred"))
            } catch (e: IOException) {
                emit(Resource.Error("Couldn't reach server check your internet connection"))
            }

    }
}
package com.sakthi.excoins.domain.model

import com.sakthi.excoins.data.remote.dto.TeamMember

data class CoinDetail(
    val coinId: String,
    val name: String,
    val description: String,
    val rank: Int,
    val symbol: String,
    val isActive: Boolean,
    val tag: List<String>,
    val team: List<TeamMember>
)

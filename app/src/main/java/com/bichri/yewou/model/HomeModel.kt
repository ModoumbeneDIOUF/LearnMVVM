package com.bichri.yewou.model

data class HomeModel(
    var content: Content,
    var errors: List<Any>,
    var warnings: List<Any>
)
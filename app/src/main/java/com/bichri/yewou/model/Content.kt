package com.bichri.yewou.model

data class Content(
    var content: List<ContentX>,
    var empty: Boolean,
    var first: Boolean,
    var last: Boolean,
    var number: Int,
    var numberOfElements: Int,
    var pageable: Pageable,
    var size: Int,
    var sort: SortX,
    var totalElements: Int,
    var totalPages: Int
)
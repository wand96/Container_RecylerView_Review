package com.example.container_recyclerview_review

//item_recycler.xml에 3개의 데이터(번호, 타이틀, 날짜)를 출력할 것이기 때문에 data class를 생성
//파라미터를 3개 가진 데이터 클래스
data class Memo(var no:Int, var title: String, var timestamp: Long)

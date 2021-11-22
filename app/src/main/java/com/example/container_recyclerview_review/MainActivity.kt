package com.example.container_recyclerview_review

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.container_recyclerview_review.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //100개의 가상 데이터를 만드는 코드
        //반환값: MutableList<Memo>
        //MutableList<Memo>를 반환하는 메서드
        fun loadData(): MutableList<Memo> {
            val data: MutableList<Memo> = mutableListOf()
            //리턴할 MutableList 컬렉션 선언

            //for문으로 100개의 가상 데이터를 생성
            for(no in 1..100) {
                val title = "이것이 안드로이드다 ${no}"  //title 변수에는 "이것이 안드로이드다 no"가 100개 저장
                val date = System.currentTimeMillis()   //안드로이드 스마트폰의 현재 시간이 숫자 값으로 저장
                var memo = Memo(no, title, date)    //memo변수 안에는 no, title, date를 저장

                data.add(memo)  //한개의 for문이 끝날때마다 memo가 data 변수에 추가
            }
            return data //loadData를 호출하면 for문으로 인하여 생성된 데이터 100개가 data에 쌓이고 data를 반환함
        }



    }
}
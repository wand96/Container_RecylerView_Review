package com.example.container_recyclerview_review

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.container_recyclerview_review.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}
    //viewbinding 설정

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val data:MutableList<Memo> = loadData()
        //MutableList<Memo> 형식인 data변수를 생성하고 loadData 함수를 이용하여 100개의 데이터 저장
        var adapter = CustomAdapter()
        //adapter라는 변수를 생성하고 CustomAdapter()로 생성함
        adapter.listData = data
        //adapter
        binding.recyclerView.adapter = adapter

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

    }

    fun loadData(): MutableList<Memo> {
        //MutableList<Memo>를 반환함
        val data: MutableList<Memo> = mutableListOf()
        //리턴할 mutableList 컬렉션을 생성
        for(no in 1..100) {
            //for문으로 100개의 데이터를 생성
            val title = "이것이 안드로이드다 ${no}"
            val date = System.currentTimeMillis()

            var memo = Memo(no, title, date)
            //생성된 데이터들을 Memo라는 데이터 클래스 형식으로 저장

            data.add(memo)
            //mutableList에 memo를 한번의 for문이 실행될 때마다 더해줌
        }
        return data
    }
}
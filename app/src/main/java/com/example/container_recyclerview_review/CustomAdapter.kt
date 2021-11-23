package com.example.container_recyclerview_review

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.container_recyclerview_review.databinding.ItemRecyclerBinding
import java.text.SimpleDateFormat

//리사이클러뷰어댑터는 뷰홀더 클래스를 제네릭으로 지정해야 하기 때문에 뷰홀더를 먼저 만드는 것이 편하다.
//어댑터가 정상작동하기 위해서는 아래 3개의 인터페이스를 반드시 구현해야 한다.
class CustomAdapter: RecyclerView.Adapter<Holder>() {

    var listData = mutableListOf<Memo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        //한 화면에 그려지는 아이템 개수만큼 레이아웃 생성
        val binding = ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        //생성된 뷰홀더를 화면에 보여주는 메서드
        val memo = listData.get(position)
        holder.setMemo(memo)
    }

    override fun getItemCount(): Int {
        //목록에 보여줄 아이템의 개수
        return listData.size
    }
}

class Holder(val binding: ItemRecyclerBinding): RecyclerView.ViewHolder(binding.root) {

    fun setMemo(memo: Memo) {
    //화면에 데이터를 세팅하는 메서드
        binding.textNo.text = "${memo.no}"
        binding.textTitle.text = memo.title

        var sdf = SimpleDateFormat("yyyy/MM/dd")
        var formattedDate = sdf.format(memo.timestamp)
        binding.textDate.text = formattedDate
    }
}
package com.example.umc_week5_2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.umc_week5_2.databinding.ItemMemoBinding

// RecyclerView Adapter 클래스 - View와 Data를 연결해주는 클래스
class MemoRVAdapter(private val memoList: ArrayList<MemoData>): RecyclerView.Adapter<MemoRVAdapter.MemoViewHolder>() {


    // ViewHolder 객체 초기화 클래스
    inner class MemoViewHolder(private val viewBinding: ItemMemoBinding): RecyclerView.ViewHolder(viewBinding.root){

        // Memo ViewHolder 객체 초기화
        fun bind(data: MemoData){

            // 메모 목록 클릭 시 삭제 구현
//            viewBinding.root.setOnClickListener {
//                memoList.removeAt(adapterPosition)
//            }
            viewBinding.tvTitle.text = data.title
            viewBinding.tvDesc.text = data.desc
        }
    }


    // ViewHolder 객체 생성 메소드
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoViewHolder {

        // ViewHolder 객체 생성
        val viewBinding = ItemMemoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MemoViewHolder(viewBinding)
    }

    // ViewHolder 객체 초기화 메소드 & 데이터 연결
    override fun onBindViewHolder(holder: MemoViewHolder, position: Int) {
        holder.bind(memoList[position])

    }

    // ViewHolder의 Item 갯수 출력 메소드
    override fun getItemCount(): Int {
        return memoList.size
    }
}
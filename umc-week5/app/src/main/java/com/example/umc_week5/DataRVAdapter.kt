package com.example.umc_week5

import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.umc_week5.databinding.ItemDataBinding

// RecyclerView의 Adpter를 상속받아서 구현
/*
    RecyclerView Adapter 클래스는
    고정된 View 객체를 자유자재로 나타내기 위해 사용하는 클래스이다.

    그래서, 사용자의 입력에 따른 View 구성을 이 Adapter 클래스를 통해 실현시킨다.
    현재는 RecycleView를 표현하기 위해 Adapter 클래스를 이용하는 방법이고, 나중에 PagerView2 를 표현하고자 Adapter 클래스를 구성하니 참고하자.
 */
class DataRVAdapter(private val dataList: ArrayList<Data>): RecyclerView.Adapter<DataRVAdapter.DataViewHolder>() {


    // Switch Item의 상태의 Boolean 값을 담는 필드변수 리스트 생성
    private val checkboxStatus = SparseBooleanArray()

    // ViewHolder 객체를 받아서 ViewHolder 객체를 (Item 배열을 통해) 완성하는 내부 클래스 구현
    inner class DataViewHolder(private val viewBinding: ItemDataBinding): RecyclerView.ViewHolder(viewBinding.root){

        // View에 Item을 표시할 때 호출한다. | 실제로 View를 설정할 때 호출한다.
        fun bind(data: Data){

            // View의 Switch 요소의 check boolean 값을 기록해두는 리스트로 선언
            /*
                index : postion
                value : boolean
             */
            viewBinding.btnSwitch.isChecked = checkboxStatus[adapterPosition]

            // 클릭 인벤트가 들어왔을 때, View의 Switch 요소 Check 여부를 확인하고,
            // boolean 값으로 리스트에 저장
            viewBinding.btnSwitch.setOnClickListener {
                if(!viewBinding.btnSwitch.isChecked){
                    checkboxStatus.put(adapterPosition, false)
                }
                else{
                    checkboxStatus.put(adapterPosition, true)
                }
            }

            // Switch가 체크되었는지 확인하고
            // 체크가 안되어있다면, 체크제거 || 체크가 되어있다면, 체크
            viewBinding.btnSwitch.isChecked = checkboxStatus.get(adapterPosition)

            // 모든 View의 Item에 대한 초기화를 거침.
            viewBinding.tvTitle.text = data.title
            viewBinding.tvDesc.text = data.desc

        }
    }

    /*
            아래의 메소드들은 Recycler View.adapter 클래스를 상속받아서 사용할 시
            필요한 메소드들이다. | Recycler View Adapter 클래스를 사용할 때 함께 작동하는 메소드들이라고 생각하면 된다.
     */


    // ViewHolder 만들어질 때 호출되는 함수 || ViewHolder 객체 생성
    /*
        DataViewHolder 클래스를 상속받아서 viewHolder 객체를 넘겨줌.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {

        // ViewHolder 객체 생성
        /*
            ViewHolder 객체는 getItemCount() 메소드에서 받아진 Item 갯수를 토대로
            ViewHolder 객체를 생성하는데,
            화면에 보이는 전체 리스트 목록이 10개라면, 위아래 버퍼까지 감안해 13~15개 정도의 객체를 생성한다.

            그렇기에, ViewHolder 객체는 Item 배열의 갯수만큼 생성된다.
         */
        val viewBinding = ItemDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(viewBinding)
    }

    // ViewHolder 가 실제로 데이터를 표시할 때 호출되는 함수 - 앱 사용자의 해당 액티비티에서 스크롤할 때마다 액티비티가 변형되면 호출되는 메소드
    // 액티비티에서 사라지는 요소를 토대로 View를 새롭게 Bind 시켜준다.
    /*
        onBindViewHolder 메소드는
        데이터가 스크롤 되어서 맨 위에있던 뷰 홀더(레이아웃) 객체가 맨 아래로 이동한다면,
        그 레이아웃(View)은 재사용 하되 데이터는 새롭게 바뀔 것이다. (bind 메소드를 통해서 바뀐다.)
        아래에서 새롭게 보여질 데이터의 인덱스 값이 position이라는 이름으로 자동으로 받아서 사용가능하다.
     */
    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    // 앱에 나타낼 목록의 총 갯수를 Adapter 클래스에게 알려준다.
    // 그래서, Adapter 클래스를 처음 생성했을 때, 실행되는 메소드로 초기화하지 않는 이상 해당 메소드는 한번실행된 채 앱이 구현된다.
    override fun getItemCount(): Int {
        return dataList.size
    }


}
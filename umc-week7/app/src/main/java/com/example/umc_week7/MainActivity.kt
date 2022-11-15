package com.example.umc_week7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import com.example.umc_week7.databinding.ActivityMainBinding
import javax.net.ssl.HandshakeCompletedEvent
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    private val viewBinding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }


    // 타이머에서 사용 될 필드변수 선언 및 초기화
    private var total = 30
    private var started = false

    // 쓰레드에서 처리한 내역을 토대로 UI 작업을 처리해주는 Hadler
    /*
        커스텀 Handller 구현하는 방법은
        아직 구글링을 제대로 해보지 않음.
        일단, 스탠다드 미션을 완수하는 정도만 구현해봄.
        이 부분은 추가적인 개발 기술이니, 선택사항이다 그래서, 시간이 남을 때 구현해보도록 하겠다.
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        // 쓰레드를 이용한 타이머 구현
        /*
            Ver.1 시작버튼 클릭 시 0초부터 타이머 시작
            종료버튼 클릭 시 타이머 종료 후 0초로 초기화
         */

//        // 핸들러 객체 생성
//        val handler = Handler(mainLooper)
//
//
//        // 시작버튼 클릭 - 타이머 시작
//        viewBinding.btnStart.setOnClickListener {
//            started = true
//
//
//            // 쓰레드 실행 - 타이머를 위한 쓰레드
//            thread(start = true) {
//                while(started){
//
//                    // 1초 지연
//                    Thread.sleep(1000)
//
//                    total += 1
//
//                    val minute = String.format("%02d", total / 60) // 분
//                    val second = String.format("%02d", total % 60) // 초
//                    handler.post{
//                        viewBinding.tvTimer.text = "$minute:$second"
//                    }
//                }
//
//                // 종료버튼 클릭 시 00:00으로 타이머 초기화
//                handler.post{
//                    viewBinding.tvTimer.text = "00:00"
//                }
//            }
//        }
//
//        // 종료 버튼 클릭 - 타이머 종료 및 00:00 초가화
//        viewBinding.btnEnd.setOnClickListener {
//            started = false
//            total = 0
//        }


        /*
            Ver.2 시작버튼 클릭 시 30초 타임어택 시작
            0초 or 종료버튼 클릭 시 0초로 초기화
         */
        viewBinding.tvTimer.text = "00:30"

        // 핸들러 객체 생성
        val handler = Handler(mainLooper)


        // 시작버튼 클릭 - 타이머 시작
        viewBinding.btnStart.setOnClickListener {
            started = true
            total = 30

            // 쓰레드 실행 - 타이머를 위한 쓰레드
            thread(start = true) {
                while(started && total != 0){

                    // 1초 지연
                    Thread.sleep(1000)

                    total -= 1
                    val minute = String.format("%02d", total / 60) // 분
                    val second = String.format("%02d", total % 60) // 초
                    handler.post{
                        viewBinding.tvTimer.text = "$minute:$second"
                    }
                }

                // 종료버튼 클릭 시 00:00으로 타이머 초기화
                total = 30
                handler.post{
                    viewBinding.tvTimer.text = "00:30"
                }
            }
        }

        // 종료 버튼 클릭 - 타이머 종료 및 00:00 초가화
        viewBinding.btnEnd.setOnClickListener {
            started = false
            total = 30
        }


    }
}
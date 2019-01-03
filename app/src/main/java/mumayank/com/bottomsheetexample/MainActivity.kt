package mumayank.com.bottomsheetexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.design.widget.BottomSheetDialogFragment
import android.view.MotionEvent
import android.view.View
import android.view.Window
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.bottom_sheet.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val sheetBehavior = BottomSheetBehavior.from(bottom_sheet)
        sheetBehavior.isFitToContents = true

        sheetBehavior.setBottomSheetCallback(object: BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(p0: View, p1: Float) {
                // do nothing
            }

            override fun onStateChanged(p0: View, p1: Int) {
                when (p1) {
                    BottomSheetBehavior.STATE_HIDDEN -> {
                       // imageView.setImageResource(R.drawable.ic_keyboard_arrow_up_black_24dp)
                    }
                    BottomSheetBehavior.STATE_COLLAPSED -> {
                       // imageView.setImageResource(R.drawable.ic_keyboard_arrow_up_black_24dp)
                    }
                    BottomSheetBehavior.STATE_HALF_EXPANDED -> {
                      //  imageView.setImageResource(R.drawable.ic_keyboard_arrow_up_black_24dp)
                    }
                    BottomSheetBehavior.STATE_EXPANDED -> {
                       // imageView.setImageResource(R.drawable.ic_keyboard_arrow_down_black_24dp)
                    }
                }
            }

        })

        /*parentLayout.setOnTouchListener { _, _ ->
            sheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            return@setOnTouchListener false
        }*/

        sheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
        parentLayout.post {
            bottom_sheet.layoutParams.height = (parentLayout.height / 2)
            bottom_sheet.postDelayed(fun() {
                sheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            }, 500)
        }

    }
}

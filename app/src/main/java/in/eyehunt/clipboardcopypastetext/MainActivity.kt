package `in`.eyehunt.clipboardcopypastetext

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.content.ClipData
import android.content.ClipboardManager
import android.view.View
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    private var myClipboard: ClipboardManager? = null
    private var myClip: ClipData? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myClipboard = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager?;

    }

    // on click copy button
    fun copyText(view: View) {
        myClip = ClipData.newPlainText("text", et_copy_text.text);
        myClipboard?.setPrimaryClip(myClip);

        Toast.makeText(this, "Text Copied", Toast.LENGTH_SHORT).show();
    }

    // on click paste button
    fun pasteText(view: View) {
        val abc = myClipboard?.getPrimaryClip()
        val item = abc?.getItemAt(0)

        tv_text_paste.text = item?.text.toString()

        Toast.makeText(applicationContext, "Text Pasted", Toast.LENGTH_SHORT).show()
    }
}

import android.content.Context
import android.os.Message
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.widget.ProgressBar
import com.jainamj.myapplication.base.mvp.WebViewInterface
import com.jainamj.myapplication.data.api.MyWebViewClient

private const val CONST_MIME_TYPE = "text/html"
private const val CONST_UTF = "UTF-8"

fun WebSettings.setDefaults() {
    javaScriptEnabled = true
    javaScriptCanOpenWindowsAutomatically = true
    domStorageEnabled = true
    setSupportMultipleWindows(true)
    setSupportZoom(true)
    builtInZoomControls = true
    displayZoomControls = true
}

fun WebView.loadDataUrl(newsLetterDataUrl: String?) =
        loadDataWithBaseURL(null, newsLetterDataUrl,
                CONST_MIME_TYPE, CONST_UTF, null)

fun WebView.setDefaults(progressBar: ProgressBar, webViewInterface: WebViewInterface, context: Context) {
    webChromeClient = getChromeClient(progressBar)
    webViewClient = MyWebViewClient(webViewInterface, context)
    settings.setDefaults()
}

private fun getChromeClient(progressBar: ProgressBar): WebChromeClient =
        object : WebChromeClient() {
            override fun onCreateWindow(view: WebView?, isDialog: Boolean, isUserGesture: Boolean, resultMsg: Message?):
                    Boolean {
                val data = view?.hitTestResult?.extra
                view?.loadUrl(data)
                return false
            }

            override fun onProgressChanged(view: WebView?, progress: Int) {
                progressBar.progress = progress
            }
        }

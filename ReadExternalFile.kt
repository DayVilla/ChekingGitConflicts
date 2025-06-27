import android.content.Context
import java.io.File

fun readFromExternalDirectory(context: Context, fileName: String): String? {
    val dir = context.getExternalFilesDir(null) ?: return null
    val file = File(dir, fileName)
    return if (file.exists()) {
        file.readText()
    } else {
        null
    }
}

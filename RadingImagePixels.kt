import android.graphics.Bitmap
import android.graphics.Color

class RadingImagePixels {
    fun readPixels(bitmap: Bitmap): IntArray {
        val width = bitmap.width
        val height = bitmap.height
        val pixels = IntArray(width * height)
        bitmap.getPixels(pixels, 0, width, 0, 0, width, height)
        return pixels
    }

    /**
     * Calculate the average color of the provided [bitmap].
     *
     * This method iterates over all pixels and computes the average value
     * for the red, green and blue channels. The resulting color can be
     * used to quickly determine a general tone for the image.
     */
    fun getAverageColor(bitmap: Bitmap): Int {
        val pixels = readPixels(bitmap)
        var sumR = 0
        var sumG = 0
        var sumB = 0

        for (pixel in pixels) {
            sumR += Color.red(pixel)
            sumG += Color.green(pixel)
            sumB += Color.blue(pixel)
        }

        val count = pixels.size.coerceAtLeast(1)
        return Color.rgb(sumR / count, sumG / count, sumB / count)
    }
}

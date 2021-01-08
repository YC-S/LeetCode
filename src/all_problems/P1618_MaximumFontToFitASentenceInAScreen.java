package all_problems;

public class P1618_MaximumFontToFitASentenceInAScreen {
    public int maxFont(String text, int w, int h, int[] fonts, FontInfo fontInfo) {
        int left = 0;
        int right = fonts.length - 1;
        while (left <= right) {
            int mid = right - (right - left) / 2;
            int textWidth = 0;
            int textHeight = fontInfo.getHeight(fonts[mid]);
            for (char ch : text.toCharArray()) {
                textWidth += fontInfo.getWidth(fonts[mid], ch);
            }
            if (left == right) {
                if (textWidth > w || textHeight > h) {
                    break;
                } else {
                    return fonts[left];
                }
            }
            if (textWidth <= w && textHeight <= h) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    interface FontInfo {
        int getWidth(int fontSize, char ch);

        int getHeight(int fontSize);
    }
}

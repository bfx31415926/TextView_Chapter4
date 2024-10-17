package notes_for_professionals.textview_chapter4;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Spannable color
        TextView spannableTextColorTV = findViewById(R.id.spannableTextColorTV);
        String firstSubString = "Первая строка\n";
        String lastSubString = "Вторая строка";
        int firstColor = 0xFFFF0000; //формат ARGB
        int lastColor = 0xFF0000FF;
        Spannable spannable = new SpannableString(firstSubString + lastSubString);
        spannable.setSpan(new ForegroundColorSpan(firstColor), 0, firstSubString.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannable.setSpan(new ForegroundColorSpan(lastColor), firstSubString.length(),
                firstSubString.length() + lastSubString.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableTextColorTV.setText(spannable);

        //Spannable font
        TextView spannableFontTV = findViewById(R.id.spannableFontTV);
        firstSubString = "15";
        lastSubString = "  Jun";
        spannable = new SpannableString(firstSubString + lastSubString);
        spannable.setSpan(new RelativeSizeSpan(1.1f), 0, firstSubString.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE); // set size
        spannable.setSpan(new RelativeSizeSpan(0.8f), firstSubString.length(), firstSubString.length() +
                lastSubString.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE); // set size
        spannableFontTV.setText(spannable);

        //Spannable typeface
        TextView spannableTypeFaceTV = findViewById(R.id.spannableTypeFaceTV);
        firstSubString = "Первая строка\n";
        lastSubString = "Вторая строка";
        spannable = new SpannableString(firstSubString + lastSubString);
        Typeface typeface1 = Typeface.createFromAsset(getAssets(), "fonts/LugaextralightadcItalic.otf");
        Typeface typeface2 = Typeface.createFromAsset(getAssets(), "fonts/Oldscriptc.otf");
        spannable.setSpan(new CustomTypefaceSpan("LugaextralightadcItalic.otf", typeface1), 0,
                firstSubString.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannable.setSpan(new CustomTypefaceSpan("Oldscriptc.otf", typeface2),
                firstSubString.length(), firstSubString.length() + lastSubString.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableTypeFaceTV.setText(spannable);

        //Strikethrough the entire text
        String sampleText = "This is a test strike";
        TextView strikethroughEntireTextTV = findViewById(R.id.strikethroughEntireTextTV);
        strikethroughEntireTextTV.setPaintFlags(strikethroughEntireTextTV.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        strikethroughEntireTextTV.setText(sampleText);

        //Strikethrough only parts of the text
        sampleText = "This is a test strike";
        TextView strikeThroughOnlyPartsOfTextTV = findViewById(R.id.strikeThroughOnlyPartsOfTextTV);
        SpannableStringBuilder spanBuilder = new SpannableStringBuilder(sampleText);
        StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
        spanBuilder.setSpan(
                strikethroughSpan, // Span to add
                0, // Start
                4, // End of the span (exclusive)
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE // Text changes will not reflect in the strike changing
        );
        strikeThroughOnlyPartsOfTextTV.setText(spanBuilder);

        //TextView with Image
    }
}
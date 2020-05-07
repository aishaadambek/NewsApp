package com.example.newsapp;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import org.ocpsoft.prettytime.PrettyTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Random;
import java.util.Set;

class Utils {

    /* Countries supported by the News API. */
    private static final String[] COUNTRIES = new String[] {
            "ae", "ar", "at", "au", "be", "bg", "br", "ca", "ch", "cn", "co", "cu", "cz", "de",
            "eg", "fr", "gb", "gr", "hk", "hu", "id", "ie", "il", "in", "it", "jp", "kr", "lt",
            "lv", "ma", "mx", "my", "ng", "nl", "no", "nz", "ph", "pl", "pt", "ro", "rs", "ru",
            "sa", "se", "sg", "si", "sk", "th", "tr", "tw", "ua", "us", "ve", "za"
    };
    private static final Set<String> COUNTRIES_SET = new HashSet<>(Arrays.asList(COUNTRIES));
    private static final String DEFAULT_COUNTRY = "us";
    /* Random ColorDrawables to be used as placeholders for the Glide's RequestOptions object. */
    private static final ColorDrawable[] colorsList =
            {
                    new ColorDrawable(Color.parseColor("#80d6ff")),
                    new ColorDrawable(Color.parseColor("#42a5f5")),
                    new ColorDrawable(Color.parseColor("#0077c2")),
                    new ColorDrawable(Color.parseColor("#81d4fa")),
                    new ColorDrawable(Color.parseColor("#b6ffff")),
                    new ColorDrawable(Color.parseColor("#4ba3c7")),
            };

    static ColorDrawable getRandomDrawableColor() {
        int idx = new Random().nextInt(colorsList.length);
        return colorsList[idx];
    }

    static String getCountry(){
        String country = String.valueOf(Locale.getDefault().getCountry()).toLowerCase();
        return COUNTRIES_SET.contains(country) ? country : DEFAULT_COUNTRY;
    }

    static String DateToTimeFormat(String date){
        PrettyTime prettyTime = new PrettyTime(new Locale(getCountry()));
        String publicationTime = null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
                    "yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
            Date newDate = simpleDateFormat.parse(date);
            publicationTime = prettyTime.format(newDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return publicationTime;
    }
}
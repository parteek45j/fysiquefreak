package com.android.parteek.fysquefreak;

import android.net.Uri;

/**
 * Created by Suraj on 7/12/2017.
 */

public class Util {
    public static final int DbVersion=1;
    public static final String DbName="Register1.db";

    public static final String TabName="fysque";
    public static final String Id="ID";
    public static final String Name="NAME";
    public static final String Monday="Monday";
    public static final String Tuesday="Tuesday";
    public static final String Wednesday="Wednesday";
    public static final String Thrusday="Thrusday";
    public static final String Friday="Friday";
    public static final String Saturday="Saturday";

    public static final String CreateTab="create table fysque("+
            "ID integer primary key autoincrement," +
            "NAME varchar(256)," +
            "Monday varchar(1000)," +
            "Tuesday varchar(1000)," +
            "Wednesday varchar(1000)," +
            "Thrusday varchar(1000)," +
            "Friday varchar(1000)," +
            "Saturday varchar(1000)" +
            ")";

    public static final Uri FreakUri= Uri.parse("content://com.android.parteek.fysquefreak.cp.provider/"+TabName);

    public static String fysque="freak";
    public static String chestSchedule="chestSchedule";

    public static String bench="Bench press";
    public static String incline="Incline Press";
    public static String inclineDumb="Inclined Dumbbell";
    public static String dips="Dips";
    public static String cable="Cable Cross";
    public static String dumbbellFly="Dumbbell Fly";
    public static String pull="Pullover";
    public static String push="Push-Ups";
    public static String dumbPress="Dumbbell Press";
    public static String pecD="Pec Deck";
    public static String editText="editText";

    public static String scheduleList="scheduleList";
}

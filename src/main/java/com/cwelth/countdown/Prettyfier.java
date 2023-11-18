package com.cwelth.countdown;

import org.joml.Vector2i;

public class Prettyfier {
    public static String SecondsToTime(int seconds)
    {
        // 3815 seconds
        // hours = 1
        // minutes = 3
        // seconds = 35

        String str = "";
        int hours = seconds / 60 / 60;
        int minutes = (seconds - hours * 60 * 60) / 60;
        int secs = (seconds - (hours * 60 * 60 + minutes * 60));
        //return String.format("% 2d:%02d:%02d", hours, minutes, secs);
        return String.format("%02d:%02d:%02d", hours, minutes, secs);
    }

    public static Vector2i GetTopLeft(char character)
    {
        Vector2i toRet = new Vector2i();
        switch (character)
        {
            case '1':
                toRet.x = 0;
                toRet.y = 0;
                break;
            case '2':
                toRet.x = 64;
                toRet.y = 0;
                break;
            case '3':
                toRet.x = 128;
                toRet.y = 0;
                break;
            case '4':
                toRet.x = 192;
                toRet.y = 0;
                break;
            case '5':
                toRet.x = 0;
                toRet.y = 80;
                break;
            case '6':
                toRet.x = 64;
                toRet.y = 80;
                break;
            case '7':
                toRet.x = 128;
                toRet.y = 80;
                break;
            case '8':
                toRet.x = 192;
                toRet.y = 80;
                break;
            case '9':
                toRet.x = 0;
                toRet.y = 160;
                break;
            case '0':
                toRet.x = 64;
                toRet.y = 160;
                break;
            case ':':
                toRet.x = 128;
                toRet.y = 160;
                break;
            default:
                toRet.x = 192;
                toRet.y = 160;
                break;
        }
        return toRet;
    }

    public static char GetNextDigit(char src)
    {
        return (char)(src - 1);
    }
}

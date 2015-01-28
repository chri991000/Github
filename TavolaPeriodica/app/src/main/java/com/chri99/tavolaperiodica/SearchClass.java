package com.chri99.tavolaperiodica;

import android.content.res.Resources;

/**
 * Created by mac on 24/12/14.
 */
public class SearchClass {
    int i = 0;

    public int getNAt(String s) {
        s = s.toLowerCase().trim();
        elements S = elements.valueOf(s);
        switch (S) {
            case idrogeno:
                i = 1;
                break;
            case h:
                i = 1;
                break;
            case elio:
                i = 2;
                break;
            case he:
                i = 2;
                break;
            case litio:
                i = 3;
                break;
            case li:
                i = 3;
                break;
            case berilio:
                i = 4;
                break;
            case be:
                i = 4;
                break;
            case boro:
                i = 5;
                break;
            case b:
                i = 5;
                break;
            case carbonio:
                i = 6;
                break;
            case c:
                i = 6;
                break;
            case azoto:
                i = 7;
                break;
            case n:
                i = 7;
                break;
            case ossigeno:
                i = 8;
                break;
            case o:
                i = 8;
                break;
            case fluoro:
                i = 9;
                break;
            case f:
                i = 9;
                break;
            case neon:
                i = 10;
                break;
            case ne:
                i = 10;
                break;
            case sodio:
                i = 11;
                break;
            case na:
                i = 11;
                break;
            case magnesio:
                i = 12;
                break;
            case mg:
                i = 12;
                break;
            case alluminio:
                i = 13;
                break;
            case al:
                i = 13;
                break;
            case silicio:
                i = 14;
                break;
            case si:
                i = 14;
                break;
            case fosforo:
                i = 15;
                break;
            case p:
                i = 15;
                break;
            case zolfo:
                i = 16;
                break;
            case s:
                i = 16;
                break;
            case cloro:
                i = 17;
                break;
            case cl:
                i = 17;
                break;
            case argo:
                i = 18;
                break;
            case ar:
                i = 18;
                break;
            case potassio:
                i = 19;
                break;
            case k:
                i = 19;
                break;
            case calcio:
                i = 20;
                break;
            case ca:
                i = 20;
                break;
            case scandio:
                i = 21;
                break;
            case sc:
                i = 21;
                break;
            case titanio:
                i = 22;
                break;
            case ti:
                i = 22;
                break;
            case vanadio:
                i = 23;
                break;
            case va:
                i = 23;
                break;
            case cromo:
                i = 24;
                break;
            case cr:
                i = 24;
                break;
            case manganese:
                i = 25;
                break;
            case mn:
                i = 25;
                break;
            case ferro:
                i = 26;
                break;
            case fe:
                i = 26;
                break;
            case cobalto:
                i = 27;
                break;
            case co:
                i = 27;
                break;
            case nichel:
                i = 28;
                break;
            case ni:
                i = 28;
                break;
            case rame:
                i = 29;
                break;
            case cu:
                i = 29;
                break;
            case zinco:
                i = 30;
                break;
            case zn:
                i = 30;
                break;
            case gallio:
                i = 31;
                break;
            case ga:
                i = 32;
                break;
            case germanio:
                i = 32;
                break;
            case ge:
                i = 32;
                break;
            case arsenico:
                i = 33;
                break;
            case as:
                i = 33;
                break;
            case selenio:
                i = 34;
                break;
            case se:
                i = 34;
                break;
            case bromo:
                i = 35;
                break;
            case br:
                i = 35;
                break;
            case kripto:
                i = 36;
                break;
            case kr:
                i = 36;
                break;
            default:
                i = 0;
                break;
        }

        return i;

    }

    public int getId(int i) {
        i --;
        switch (i) {
            case 0:
                i = R.drawable.e0;
                break;
            case 1:
                i = R.drawable.e1;
                break;
            case 2:
                i = R.drawable.e2;
                break;
            case 3:
                i = R.drawable.e3;
                break;
            case 4:
                i = R.drawable.e4;
                break;
            case 5:
                i = R.drawable.e5;
                break;
            case 6:
                i = R.drawable.e6;
                break;
            case 7:
                i = R.drawable.e7;
                break;
            case 8:
                i = R.drawable.e8;
                break;
            case 9:
                i = R.drawable.e9;
                break;
            case 10:
                i = R.drawable.e10;
                break;
            case 11:
                i = R.drawable.e11;
                break;
            case 12:
                i = R.drawable.e12;
                break;
            case 13:
                i = R.drawable.e13;
                break;
            case 14:
                i = R.drawable.e14;
                break;
            case 15:
                i = R.drawable.e15;
                break;
            case 16:
                i = R.drawable.e16;
                break;
            case 17:
                i = R.drawable.e17;
                break;
            case 18:
                i = R.drawable.e18;
                break;
            case 19:
                i = R.drawable.e19;
                break;
            case 20:
                i = R.drawable.e21;
                break;
            case 21:
                i = R.drawable.e22;
                break;
            case 22:
                i = R.drawable.e23;
                break;
            case 23:
                i = R.drawable.e24;
                break;
            case 24:
                i = R.drawable.e25;
                break;
            case 25:
                i = R.drawable.e26;
                break;
            case 26:
                i = R.drawable.e27;
                break;
            case 27:
                i = R.drawable.e28;
                break;
            case 28:
                i = R.drawable.e29;
                break;
            case 29:
                i = R.drawable.e30;
                break;
            case 30:
                i = R.drawable.e31;
                break;
            case 31:
                i = R.drawable.e32;
                break;
            case 32:
                i = R.drawable.e33;
                break;
            case 33:
                i = R.drawable.e34;
                break;
            case 34:
                i = R.drawable.e35;
                break;
            case 35:
                i = R.drawable.e36;
                break;

        }
        return i;

    }

    public enum elements {
        idrogeno, h, elio, he, litio, li, berilio, be, boro, b, carbonio, c, azoto, n, ossigeno, o, fluoro, f, neon, ne, sodio, na, magnesio, mg,
        alluminio, al, silicio, si, fosforo, p, zolfo, s, cloro, cl, argo, ar, potassio, k, calcio, ca, scandio, sc, titanio, ti, vanadio, va,
        cromo, cr, manganese, mn, ferro, fe, cobalto, co, nichel, ni, rame, cu, zinco, zn, gallio, ga, germanio, ge, arsenico, as, selenio, se, bromo, br, kripto, kr
    }
}

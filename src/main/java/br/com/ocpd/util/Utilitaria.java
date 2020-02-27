package br.com.ocpd.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilitaria {

    public static final String DD = "dd";
    public static final String MM = "MM";
    public static final String YYYY = "yyyy";
    public static final String DD_MM_YYYY = "dd/MM/yyyy";
    public static final String DD_MM_YYYY_HH_MM = "dd/MM/yyyy HH:mm";
    public static final String DD_MM_YYYY_HH_MM_SS = "dd/MM/yyyy HH:mm:ss";
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";


    public static String hoje() {
        return new SimpleDateFormat(DD_MM_YYYY).format(new Date());
    }

    public static String diaAtual() {
        return new SimpleDateFormat(DD).format(new Date());
    }

    public static String mesAtual() {
        return new SimpleDateFormat(MM).format(new Date());
    }

    public static String anoAtual() {
        return new SimpleDateFormat(YYYY).format(new Date());
    }

    public static String dataDD_MM_YYYY(Date data) {
        return new SimpleDateFormat(DD_MM_YYYY).format(data);
    }

    public static String dataDD_MM_YYYY_HH_MM(Date data) {
        return new SimpleDateFormat(DD_MM_YYYY_HH_MM).format(data);
    }

    public static String dataDD_MM_YYYY_HH_MM_SS(Date data) {
        return new SimpleDateFormat(DD_MM_YYYY_HH_MM_SS).format(data);
    }

    public static String dataYYYY_MM_DD(Date data) {
        return new SimpleDateFormat(YYYY_MM_DD).format(data);
    }

    public static String dataYYYY_MM_DD_HH_MM(Date data) {
        return new SimpleDateFormat(YYYY_MM_DD_HH_MM).format(data);
    }

    public static String dataYYYY_MM_DD_HH_MM_SS(Date data) {
        return new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS).format(data);
    }

    public static String formataData(String mascara, Date data) {
        return new SimpleDateFormat(mascara).format(data);
    }
}

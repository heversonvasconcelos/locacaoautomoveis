/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.facom.ufms.locacaoautomoveis.ui.util;

import java.util.Date;

/**
 *
 * @author heverson
 */
public class DateCalculator {

    public static int calcularQtdDiasEntreDuasDatas(Date date0, Date date1) {
        long ONE_HOUR = 60 * 60 * 1000L;
        long time0 = date0.getTime();
        long time1 = date1.getTime();

        int deltaDates = (int) ((time1 - time0 + ONE_HOUR) / (ONE_HOUR * 24));

        return deltaDates;

    }
}

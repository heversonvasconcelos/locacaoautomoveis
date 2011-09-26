/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.facom.ufms.locacaoautomoveis.model.test.utils;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author heverson
 */
public abstract class PrintList {

    protected void printList(List list, String msg) {
        System.out.println("-------------------" + msg + "---------------------------");
        for (Iterator it = list.iterator(); it.hasNext();) {
            System.out.println(it.next());
        }
    }
}

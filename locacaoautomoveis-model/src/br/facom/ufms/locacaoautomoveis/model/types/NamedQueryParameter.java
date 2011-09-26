/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.facom.ufms.locacaoautomoveis.model.types;

/**
 *
 * @author heverson
 */
public class NamedQueryParameter {

    private String name;
    private Object value;

    public NamedQueryParameter(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}

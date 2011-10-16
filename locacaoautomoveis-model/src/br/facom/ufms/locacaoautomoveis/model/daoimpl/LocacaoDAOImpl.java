/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.facom.ufms.locacaoautomoveis.model.daoimpl;

import br.facom.ufms.locacaoautomoveis.model.dao.LocacaoDAO;
import br.facom.ufms.locacaoautomoveis.model.entities.Locacao;
import br.facom.ufms.locacaoautomoveis.model.types.QueryParameter;
import br.facom.ufms.locacaoautomoveis.model.types.Status;
import br.facom.ufms.locacaoautomoveis.model.util.DateCalculator;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author heverson
 */
public class LocacaoDAOImpl extends GenericDAOImpl<Locacao, Long> implements LocacaoDAO {

    @Override
    public Class<Locacao> getDomainClass() {
        return Locacao.class;
    }

    @Override
    public List<Locacao> buscarLocacoesPeloStatus(Status status) {
        String namedQuery = "Locacao.buscarLocacoesPeloStatus";
        QueryParameter parameter = new QueryParameter("status", status);
        List<Locacao> resultList = executeNamedQuery(namedQuery, parameter);

        return resultList;
    }

    /**
     * Método que realiza a locação propriamente dita, ou seja, cria um objeto
     * locação com o automovel e cliente.
     * 
     * @param locacao Locação a ser criada
     */
    @Override
    public void create(Locacao locacao) {

        locacao.setDataHoraLocacao(Calendar.getInstance().getTime());
        locacao.getAutomovel().setDisponivel(false);

        super.create(locacao);
    }

    /**
     * Método que finaliza ou fecha uma locação. Este evento ocorre quando o 
     * cliente devolve o automóvel.
     * 
     * @param locacao Locação a ser finalizada ou fechada.
     * @return true caso a locação seja finalizada com sucesso.
     */
    @Override
    public boolean finalizarLocacao(Locacao locacao) {
        if (locacao != null) {
            locacao.getAutomovel().setDisponivel(true);
            locacao.setDataHoraLocacaoFinalizada(Calendar.getInstance().getTime());
            locacao.setStatus(Status.FECHADO);
            locacao.setValor(calcularValorLocacao(
                    locacao.getDataHoraLocacao(),
                    locacao.getDataHoraLocacaoFinalizada(),
                    locacao.getAutomovel().getCategoria().getValorDiario()));

            Locacao locacaoFinalizada = update(locacao);
            if (locacaoFinalizada != null && locacaoFinalizada.getStatus() == Status.FECHADO) {
                return true;
            }
        }

        return false;
    }

    @Override
    public double calcularValorLocacao(Date dataLocacao, Date dataLocacaoFinalizada, double valorDiario) {

        int qtdDiasLocacaoEmAndamento = DateCalculator.calcularQtdDiasEntreDuasDatas(dataLocacao, dataLocacaoFinalizada);
        double valorLocacao = (qtdDiasLocacaoEmAndamento * valorDiario);

        if (qtdDiasLocacaoEmAndamento > 0) {
            valorLocacao = (qtdDiasLocacaoEmAndamento * valorDiario);
        } else {
            valorLocacao = valorDiario;
        }

        return valorLocacao;
    }
}

package frazao.felipe.mymoney.delegate

import frazao.felipe.mymoney.model.Transacao

/**
 * Created by felipefrazao on 19/12/2017.
 */
interface TransacaoDelegate {
    fun delegate(transacao: Transacao)
}
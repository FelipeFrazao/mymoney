package frazao.felipe.mymoney.mpv

import frazao.felipe.mymoney.model.Tipo
import frazao.felipe.mymoney.model.Transacao
import java.math.BigDecimal

/**
 * Created by felipefrazao on 21/12/2017.
 */
class TransacaoDAO {

    // Inserindo itens na lista
    var transacoesList: MutableList<Transacao> = mutableListOf(
            Transacao(titulo = "Fone Xiaomi",
                    valor =  BigDecimal(73.5),
                    categoria = "Compra",
                    tipo = Tipo.DESPESA
            ),
            Transacao("CMS do Danilo",
                    BigDecimal(800.00),
                    Tipo.RECEITA,
                    "Pagamento"
            ),
            Transacao("Holly Chuck Burger",
                    BigDecimal(130.00),
                    Tipo.DESPESA,
                    "Comida"
            ),
            Transacao(titulo = "Celular",
                    valor = BigDecimal(550.00),
                    tipo = Tipo.DESPESA
            )
    ).toMutableList()

    fun addTransacao (transacao: Transacao) {

        transacoesList.add(transacao)
    }

    fun updateTransacao (transacao: Transacao, indexOf: Int) {

        transacoesList.set(indexOf, transacao)
    }

    fun removeTransacao (indexOf: Int) {

        transacoesList.removeAt(indexOf)
    }
}
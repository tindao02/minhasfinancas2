package com.tindao.minhasfinancas2.service;

import java.util.List;

import com.tindao.minhasfinancas2.model.entity.Lancamento;
import com.tindao.minhasfinancas2.model.enuns.StatusLancamento;

public interface LancamentoService 
{
	Lancamento salvar(Lancamento lancamento);
	
	Lancamento atualizar(Lancamento lancamento);
	
	void deletar(Lancamento lancamento);
	
	List<Lancamento> buscar(Lancamento lancamentoFiltro);
	
	void atualizarStatus(Lancamento lancamento, StatusLancamento status);
}

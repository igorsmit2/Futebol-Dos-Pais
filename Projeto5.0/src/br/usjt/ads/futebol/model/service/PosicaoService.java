package br.usjt.ads.futebol.model.service;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.ads.futebol.model.dao.PosicaoDAO;
import br.usjt.ads.futebol.model.entity.Posicao;
@Service
public class PosicaoService {
	@Autowired
	private PosicaoDAO dao;
	
	public ArrayList<Posicao> listarPosicao() throws IOException{
		return dao.listarPosicao();
	}
}

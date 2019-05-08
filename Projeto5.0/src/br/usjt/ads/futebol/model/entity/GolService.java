package br.usjt.ads.futebol.model.entity;

import java.io.IOException;
import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.ads.futebol.model.dao.GolDAO;

@Service
public class GolService {
	@Autowired
	GolDAO dao;
	
	@Transactional
	public void inserirGol(Gol gol) throws IOException{
		dao.inserirGol(gol);
	}
	
	public ArrayList<Gol> listarGols(Gol gol) throws IOException {
		return dao.listargols(gol);
	}
}

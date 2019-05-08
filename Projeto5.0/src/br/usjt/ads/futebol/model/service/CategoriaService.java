package br.usjt.ads.futebol.model.service;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.ads.futebol.model.dao.CategoriaDAO;
import br.usjt.ads.futebol.model.entity.Categoria;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaDAO dao;
	
	public ArrayList<Categoria> listarCategoria() throws IOException{
		return dao.listarCategoria();
	}
}

package br.usjt.ads.futebol.model.service;

import java.io.IOException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.ads.futebol.model.dao.AdministradorDAO;
import br.usjt.ads.futebol.model.entity.Administrador;

@Service
public class AdministradorService {
	@Autowired
	private AdministradorDAO dao;

	public boolean autenticarAdministrador(Administrador administrador) throws IOException{
		return dao.autenticarAdministrador(administrador);
	}
}

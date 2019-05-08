package br.usjt.ads.futebol.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.usjt.ads.futebol.model.entity.Administrador;
import br.usjt.ads.futebol.model.entity.Campeonato;
import br.usjt.ads.futebol.model.entity.Categoria;
import br.usjt.ads.futebol.model.entity.Gol;
import br.usjt.ads.futebol.model.entity.GolService;
import br.usjt.ads.futebol.model.entity.Jogador;
import br.usjt.ads.futebol.model.entity.Partida;
import br.usjt.ads.futebol.model.entity.Posicao;
import br.usjt.ads.futebol.model.entity.Time;
import br.usjt.ads.futebol.model.service.AdministradorService;
import br.usjt.ads.futebol.model.service.CampeonatoService;
import br.usjt.ads.futebol.model.service.CategoriaService;
import br.usjt.ads.futebol.model.service.JogadorService;
import br.usjt.ads.futebol.model.service.PosicaoService;
import br.usjt.ads.futebol.model.service.TimeService;

@Controller
public class ManterFutebolController {
	@Autowired
	private AdministradorService admService;
	@Autowired
	private TimeService timeService;
	@Autowired
	private CategoriaService categoriaService;
	@Autowired 
	private PosicaoService posicaoService;
	@Autowired 
	JogadorService jogadorService;
	@Autowired
	CampeonatoService campeonatoService;
	@Autowired
	GolService golService;
	
	@RequestMapping("/")
	public String inicio() {
		return "index";
	}
	
	@RequestMapping("index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("tela_administrador")
	public String telaAdministrador() {
		return "TelaAdministrador";
	}
	
	@RequestMapping("fazer_login")
	public String inserirAdministrador(Administrador administrador) {
		try {
			if(admService.autenticarAdministrador(administrador)) {
				return "TelaAdministrador";
			} else {
				return "index";
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return "index";
	}
	
	@RequestMapping("tela_time")
	public String telaTime() {
		return "TelaTime";
	}
	
	@RequestMapping("voltar_tela_time")
	public String voltarTelaTime(HttpSession session, ArrayList<Time> listaTimes) {
		try {
			listaTimes = timeService.listarTimes();
			session.setAttribute("listaTimes", listaTimes);
			
			return "TelaTime";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Erro";
	}
	
	@RequestMapping("novo_time")
	public String novoTime() {
		return "NovoTime";
	}
	
	@RequestMapping("inserir_time")
	public String inserirTime(Time time, Model model) {
		try {
			time = timeService.inserirTime(time);
			model.addAttribute("time", time);
			return "TelaVisualizarTime";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Erro";
	}
	
	@RequestMapping("buscar_times")
	public String buscarTimes(HttpSession session, @RequestParam String chave, ArrayList<Time> listaTimes) {
		try {
			listaTimes = null;
			listaTimes = timeService.listarTimes(chave);
			session.setAttribute("listaTimes", listaTimes);
			return "TelaTime";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Erro";
	}
	
	@RequestMapping("visualizar_time")
	public String visualizarTime(Model model, @RequestParam int id, Time time) {
		try {
			time = timeService.buscarTime(id);
			model.addAttribute("time", time);
			return "TelaVisualizarTime";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Erro";
	}
	
	@RequestMapping("tela_alterar_time")
	public String telaAlterarTime(Model model, Time time, @RequestParam int id) {
		try {
			time = timeService.buscarTime(id);
			model.addAttribute("time", time);
			return "TelaAlterarTime";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Erro";
	}
	
	@RequestMapping("alterar_time")
	public String alterarTime(Model model, Time time) {
		try {
			time = timeService.alterarTime(time);
			model.addAttribute("time", time);
			return "TelaVisualizarTime";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Erro";
	}
	@RequestMapping("tela_excluir_time")
	public String telaExcluirTime(@RequestParam int id, Time time, Model model) {
		try {
			time = timeService.buscarTime(id);
			model.addAttribute("time", time);
			return "TelaExcluirTime";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Erro";
	}
	@RequestMapping("excluir_time")
	public String excluirTime(@RequestParam int id, Time time, HttpSession session, ArrayList<Time> listaTimes) {
		try {
			timeService.excluirTime(id);
			listaTimes = timeService.listarTimes();
			session.setAttribute("listaTimes", listaTimes);
			return "TelaTime";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Erro";
	}
	
	@RequestMapping("tela_jogador")
	public String telaJogador() {
		return "TelaJogador";
	}
	
	@RequestMapping("novo_jogador")
	public String novoJogador(ArrayList<Time> listaTimes, ArrayList<Posicao> listaPosicao, ArrayList<Categoria> listaCategoria, Model model) {
		try {
			listaTimes = timeService.listarTimes();
			listaPosicao = posicaoService.listarPosicao();
			listaCategoria = categoriaService.listarCategoria();
			model.addAttribute("listaTimes", listaTimes);
			model.addAttribute("listaPosicao", listaPosicao);
			model.addAttribute("listaCategoria", listaCategoria);
			return "NovoJogador";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Erro";
	}
	
	@RequestMapping("inserir_jogador")
	public String inserirJogador(Jogador jogador, Model model) {
		Time time = new Time();
		try {
			time = timeService.buscarTime(jogador.getTime().getId());
			jogador = jogadorService.inserirJogador(jogador);
			jogador = jogadorService.buscarJogador(jogador.getId());
			jogador.setTime(time);
			model.addAttribute("jogador", jogador);
			return "TelaVisualizarJogador";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Erro";
	}
	
	@RequestMapping("buscar_jogadores")
	public String buscarJogadores(HttpSession session, ArrayList<Jogador> listaJogadores, @RequestParam String chave) {
		try {
			listaJogadores = jogadorService.listarJogador(chave);
			session.setAttribute("listaJogadores", listaJogadores);
			return "TelaJogador";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Erro";
	}
	
	@RequestMapping("visualizar_jogador")
	public String visualizarJogador(Model model, @RequestParam int id, Jogador jogador) {
		try {
			jogador = jogadorService.buscarJogador(id);
			model.addAttribute("jogador", jogador);
			return "TelaVisualizarJogador";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Erro";
	}
	
	@RequestMapping("tela_excluir_jogador")
	public String telaExcluirJogador(Model model, @RequestParam int id, Jogador jogador) {
		try {
			jogador = jogadorService.buscarJogador(id);
			model.addAttribute("jogador", jogador);
			return "TelaExcluirJogador";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Erro";
	}
	
	@RequestMapping("excluir_jogador")
	public String excluirJogador(@RequestParam int id, Jogador jogador, ArrayList<Jogador> listaJogadores, HttpSession session) {
		try {
			jogadorService.excluirJogador(id);
			listaJogadores = null;
			listaJogadores = jogadorService.listarJogador();
			session.setAttribute("listaJogadores", listaJogadores);
			return "TelaJogador";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Erro";
	}
	
	@RequestMapping("tela_alterar_jogador")
	public String telaAlterarJogador(@RequestParam int id, Jogador jogador, Model model, HttpSession session, ArrayList<Time> listaTimes, ArrayList<Posicao> listaPosicao,
			ArrayList<Categoria> listaCategoria) {
		try {
			jogador = jogadorService.buscarJogador(id);
			listaTimes = timeService.listarTimes();
			listaPosicao = posicaoService.listarPosicao();
			listaCategoria = categoriaService.listarCategoria();
			for(Categoria cat: listaCategoria) {
				System.out.println(cat.getNome());
			}
			model.addAttribute("jogador", jogador);
			session.setAttribute("listaTimes", listaTimes);
			session.setAttribute("listaPosicao", listaPosicao);
			session.setAttribute("listaCategoria", listaCategoria);
			return "TelaAlterarJogador";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Erro";
	}
	
	@RequestMapping("voltar_tela_jogador")
	public String voltarTelaJogador(HttpSession session, ArrayList<Jogador> listaJogadores) {
		try {
			listaJogadores = null;
			listaJogadores = jogadorService.listarJogador();
			session.setAttribute("listaJogadores", listaJogadores);
			return "TelaJogador";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Erro";
	}
	
	@RequestMapping("alterar_jogador")
	public String alterarJogador(Model model, Jogador jogador) {
		try {
			jogador = jogadorService.alterarJogador(jogador);
			jogador = jogadorService.buscarJogador(jogador.getId());
			model.addAttribute("jogador", jogador);
			return "TelaVisualizarJogador";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Erro";
	}
	
	@RequestMapping("tela_campeonatos")
	public String telaCampeonato() {
		return"TelaCampeonato";
	}
	
	@RequestMapping("novo_campeonato")
	public String novoCampeonato() {
		return "NovoCampeonato";
	}
	
	@RequestMapping("inserir_campeonato")
	public String inserirCampeonato(HttpSession session, Model model, Campeonato campeonato) {
		try {
			campeonato = campeonatoService.inserirCampeonato(campeonato);
			int quantidade = campeonatoService.timesCampeonato(campeonato.getId());
			System.out.println(quantidade);
			session.setAttribute("quantidade", quantidade);
			model.addAttribute("campeonato", campeonato);
			return "TelaVisualizarCampeonato";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Erro";
	}
	
	@RequestMapping("tela_adicionar_time")
	public String adicionarTimeCampeonato(@RequestParam int id, Model model) {
		ArrayList<Time> listaTimes = new ArrayList<>();
		Campeonato campeonato = new Campeonato();
		
		try {
			listaTimes = timeService.listarTimeCampeonato(id);
			campeonato = campeonatoService.buscarCampeonato(id);
			model.addAttribute("listaTimes", listaTimes);
			model.addAttribute("campeonato", campeonato);
			return "TelaAdicionarTime";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Erro";
	}
	
	@RequestMapping("adicionar_time")
	public String adicionarTime(@RequestParam int idTime, @RequestParam int idCampeonato, HttpSession session, Model model) {
		Campeonato campeonato = new Campeonato();
		Time time = new Time();
		time.setId(idTime);
		try {
			System.out.println(idTime);
			System.out.println(idCampeonato);
			campeonatoService.inserirTimeCampeonato(idCampeonato, time);
			campeonato = campeonatoService.buscarCampeonato(idCampeonato);
			int quantidade = campeonatoService.timesCampeonato(campeonato.getId());
			session.setAttribute("quantidade", quantidade);
			model.addAttribute("campeonato", campeonato);
			return "TelaVisualizarCampeonato";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(idTime);
		System.out.println(idCampeonato);
		return "Erro";
	}
	
	@RequestMapping("buscar_campeonatos")
	public String buscarCampeonatos(@RequestParam String chave, ArrayList<Campeonato> listaCampeonato, HttpSession session) {
		try {
			listaCampeonato = campeonatoService.listarCampeonato(chave);
			session.setAttribute("listaCampeonato", listaCampeonato);
			return "TelaCampeonato";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Erro";
	}
	
	@RequestMapping("visualizar_tela_campeonato")
	public String visualizarCampeonato(@RequestParam int id, Model model, HttpSession session) {
		Campeonato campeonato = new Campeonato();
		
		try {
			campeonato = campeonatoService.buscarCampeonato(id);
			int quantidade = campeonatoService.timesCampeonato(campeonato.getId());
			session.setAttribute("quantidade", quantidade);
			model.addAttribute("campeonato", campeonato);
			return "TelaVisualizarCampeonato";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Erro";
	}
	
	@RequestMapping("ver_jogadores")
	public String verJogador(@RequestParam int id, ArrayList<Jogador> listaJogadorTime, Time time, Model model) {
		try {
			listaJogadorTime = jogadorService.buscarJogadorTime(id);
			time = timeService.buscarTime(id);
			model.addAttribute("time", time);
			model.addAttribute("listaJogadorTime",listaJogadorTime);
			return "TelaTimeJogador";

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Erro";	
	}
	
	@RequestMapping("tela_rodada_partidas")
	public String telaRodadaPartidas(@RequestParam int id, ArrayList<Time> listaTimesCampeonato, Campeonato campeonato, Model model) {
		System.out.println(id);
		try {
			campeonato = campeonatoService.buscarCampeonato(id);
			int rodada = 1;
			int n;
			boolean teste = false;
			int erro = 0;
			do {
				System.out.println("DAISDIASJIDJIASDIJAIJSDIJASDIJAJISDASI");
				n = campeonatoService.quantidadeRodadas(rodada, campeonato.getId());
				System.out.println(campeonato.getId());
				System.out.println(n);
				if(n == campeonato.getQuantidadeTimes()/2) {
					teste = false;
					rodada++;
				} else {
					teste = true;
				}
				if(rodada > campeonato.getQuantidadeRodadas()) {
					teste = true;
				}
				
				System.out.println(teste);
			} while(teste == false);
			
			if(rodada <= campeonato.getQuantidadeRodadas()) {
				listaTimesCampeonato = timeService.listarTimesCampeonatoRodada(campeonato, rodada);
				model.addAttribute("listaTimesCampeonato", listaTimesCampeonato);
				model.addAttribute("campeonato", campeonato);
				model.addAttribute("rodada", rodada);
				model.addAttribute("erro", erro);
				
				return "TelaCriarPartida";
			} else {
				erro = 1;
				model.addAttribute("erro", erro);
				model.addAttribute("campeonato", campeonato);
				return "TelaCriarPartida";
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Erro";
	}
	
	
	/*@RequestMapping("tela_criar_partidas")
	public String telaCriarPartidas(@RequestParam int id, ArrayList<Time> listaTimesCampeonato, Campeonato campeonato, Model model) {
		System.out.println(id);
		try {
			campeonato = campeonatoService.buscarCampeonato(id);
			listaTimesCampeonato = timeService.listarTimesCampeonatoExists(campeonato);
			model.addAttribute("campeonato", campeonato);
			model.addAttribute("listaTimesCampeonato", listaTimesCampeonato);
			return "TelaCriarPartida";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Erro";
	}*/

	@RequestMapping("escolher_mandante")
	public String telaEscolherRodada(@RequestParam int idTime, @RequestParam int idCampeonato, @RequestParam int rodada, Model model) {
		Campeonato campeonato = new Campeonato();
		Time time = new Time();
		ArrayList<Integer> listaRodadaTime = new ArrayList<>();
		ArrayList<Integer> listaRodada = new ArrayList<>();
		int partidasMandante, partidasVisitante;
		try {
			time = timeService.buscarTime(idTime);
			campeonato = campeonatoService.buscarCampeonato(idCampeonato);
			listaRodadaTime = timeService.timeRodadas(campeonato, time);

			for(int i = 1; i <= campeonato.getQuantidadeRodadas(); i++) {
				boolean c = true;
				for(int n:listaRodadaTime) {
					if(n == i) {
						c = false;
					}
				}
				if(c == true) {
					listaRodada.add(i);
				}
			}
			
			partidasVisitante = timeService.partidasVisitante(time.getId(), campeonato);
			partidasMandante = timeService.partidasMandante(time.getId(), campeonato);
			
			model.addAttribute("rodada", rodada);
			model.addAttribute("campeonato", campeonato);
			model.addAttribute("time", time);
			model.addAttribute("listaRodada", listaRodada);
			model.addAttribute("partidasVisitante", partidasVisitante);
			model.addAttribute("partidasMandante", partidasMandante);
			model.addAttribute("limite", campeonato.getQuantidadeRodadas()/2);
			
			return "TelaEscolherMandante";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Erro";
	}
	
	@RequestMapping("salvar_mandante")
	public String telaEscolherTime(@RequestParam int idTime, @RequestParam int idCampeonato, @RequestParam int rodada, Model model, @RequestParam String mandanteVisitante) {
		System.out.println("INICIO");
		System.out.println(idTime);
		System.out.println(idCampeonato);
		System.out.println(mandanteVisitante);
		System.out.println(rodada);
		Time time = new Time();
		Campeonato campeonato = new Campeonato();
		ArrayList<Time> listaTime = new ArrayList<>();
		try {
			time = timeService.buscarTime(idTime);
			campeonato = campeonatoService.buscarCampeonato(idCampeonato);
			
			if(mandanteVisitante.equals("mandante")) {
				listaTime = timeService.listarTimesPartidaMandante(campeonato, time, rodada);
			}
			if(mandanteVisitante.equals("visitante")) {
				listaTime = timeService.listarTimesPartidaVisitante(campeonato, time, rodada);
			}
			
			model.addAttribute("listaTime", listaTime);
			model.addAttribute("campeonato", campeonato);
			model.addAttribute("time", time);
			model.addAttribute("mandanteVisitante", mandanteVisitante);
			model.addAttribute("rodada", rodada);
			
			return "EscolherAdversario";
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "TelaCampeonato";
	}
	
	@RequestMapping("escolher_adversario")
	public String escolherAdversario(@RequestParam int idTime, @RequestParam int idCampeonato, @RequestParam String mandanteVisitante, @RequestParam int idTimeAdversario, @RequestParam int rodada,
			Model model, @RequestParam Date data) {
		ArrayList<Time> listaTimesCampeonato = new ArrayList<>();
		Time timeMandante = new Time();
		Time timeVisitante = new Time();
		Campeonato campeonato = new Campeonato();
		Partida partida = new Partida();
		ArrayList<Integer> listaRodadaTimeMandante = new ArrayList<>();
		ArrayList<Integer> listaRodadaTimeVisitante = new ArrayList<>();
		ArrayList<Integer> listaRodadaRascunho = new ArrayList<>();
		ArrayList<Integer> listaRodada = new ArrayList<>();
		
		try {
			campeonato = campeonatoService.buscarCampeonato(idCampeonato);
			if(mandanteVisitante.equals("mandante")) {
				timeMandante = timeService.buscarTime(idTime);
				timeVisitante = timeService.buscarTime(idTimeAdversario);
				
			}
			if(mandanteVisitante.equals("visitante")) {
				timeVisitante = timeService.buscarTime(idTime);
				timeMandante = timeService.buscarTime(idTimeAdversario);
			}
			
			partida.setCampeonato(campeonato);
			partida.setDataPartida(data);
			partida.setTimeMandante(timeMandante);
			partida.setTimeVisitante(timeVisitante);
			
			campeonatoService.inserirPartida(partida, rodada);
			
			campeonato = campeonatoService.buscarCampeonato(idCampeonato);
			rodada = 1;
			int n;
			boolean teste = false;
			int erro = 0;
			
			do {
				System.out.println("DAISDIASJIDJIASDIJAIJSDIJASDIJAJISDASI");
				n = campeonatoService.quantidadeRodadas(rodada, campeonato.getId());
				System.out.println(campeonato.getId());
				System.out.println(n);
				if(n == campeonato.getQuantidadeTimes()/2) {
					teste = false;
					rodada++;
				} else {
					teste = true;
				}
				if(rodada > campeonato.getQuantidadeRodadas()) {
					teste = true;
				}
				
				System.out.println(teste);
			} while(teste == false);
			
			if(rodada <= campeonato.getQuantidadeRodadas()) {
				listaTimesCampeonato = timeService.listarTimesCampeonatoRodada(campeonato, rodada);
				model.addAttribute("listaTimesCampeonato", listaTimesCampeonato);
				model.addAttribute("campeonato", campeonato);
				model.addAttribute("rodada", rodada);
				model.addAttribute("erro", erro);
				
				return "TelaCriarPartida";
			} else {
				erro = 1;
				model.addAttribute("erro", erro);
				model.addAttribute("campeonato", campeonato);
				return "TelaCriarPartida";
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Erro";
	}
	
	@RequestMapping("salvar_partida")
	public String salvarPartida(@RequestParam int idTimeMandante, @RequestParam int idTimeVisitante, @RequestParam int idCampeonato, Model model, @RequestParam Date data, @RequestParam int rodada) {
		System.out.println(idTimeMandante);
		System.out.println(idTimeVisitante);
		System.out.println(idCampeonato);
		System.out.println(data);
		ArrayList<Time> listaTimesCampeonato = new ArrayList<>();
		Time timeMandante = new Time();
		Time timeVisitante = new Time();
		Campeonato campeonato = new Campeonato();
		Partida partida = new Partida();
		
		try {
			campeonato = campeonatoService.buscarCampeonato(idCampeonato);
			System.out.println("teste1");
			partida.setCampeonato(campeonato);
			System.out.println("teste2");
			timeMandante = timeService.buscarTime(idTimeMandante);
			System.out.println("teste3");
			timeVisitante = timeService.buscarTime(idTimeVisitante);
			System.out.println("teste4");
			partida.setTimeMandante(timeMandante);
			System.out.println("teste5");
			partida.setTimeVisitante(timeVisitante);
			System.out.println("teste6");
			partida.setDataPartida(data);
			campeonatoService.inserirPartida(partida, rodada);
			System.out.println("teste7");
			
			listaTimesCampeonato = timeService.listarTimesCampeonatoExists(campeonato);
			model.addAttribute("campeonato", campeonato);
			model.addAttribute("listaTimesCampeonato", listaTimesCampeonato);
			return "TelaCriarPartida";
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Erro";
	}
	
	@RequestMapping("visualizar_partidas")
	public String listarPartidas(@RequestParam int id, Campeonato campeonato, ArrayList<Partida> listaPartida, Model model) {
		try {
			listaPartida = campeonatoService.listarPartidas(id);
			campeonato = campeonatoService.buscarCampeonato(id);
			Time timeMandante, timeVisitante;
			for(Partida partida: listaPartida) {
				partida.setTimeMandante(timeService.buscarTime(partida.getTimeMandante().getId()));
				partida.setTimeVisitante(timeService.buscarTime(partida.getTimeVisitante().getId()));
			}
			
			model.addAttribute("listaPartida", listaPartida);
			model.addAttribute("campeonato", campeonato);
			
			return "VisualizarPartidas";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Erro";
	}
	
	@RequestMapping("gerenciar_partida")
	public String listarPartidas(@RequestParam int idCampeonato, @RequestParam int idTimeMandante, @RequestParam int idTimeVisitante, Model model) {
		Time timeMandante = new Time();
		Time timeVisitante = new Time();
		Partida partida = new Partida();
		Campeonato campeonato = new Campeonato();
		ArrayList<Jogador> listaJogador = new ArrayList<>();
		try {
			campeonato = campeonatoService.buscarCampeonato(idCampeonato);
			timeMandante = timeService.buscarTime(idTimeMandante);
			timeVisitante = timeService.buscarTime(idTimeVisitante);
			partida.setTimeMandante(timeMandante);
			partida.setTimeVisitante(timeVisitante);
			partida.setCampeonato(campeonato);
			listaJogador = jogadorService.listarJogadoresPartida(partida);
			
			model.addAttribute("campeonato", campeonato);
			model.addAttribute("listaJogador",  listaJogador);
			model.addAttribute("partida",  partida);
			
			return "GerenciarPartida";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Erro";
	}
	
	@RequestMapping("cadastrar_gol")
	public String cadastrarGol(@RequestParam int idCampeonato, @RequestParam int idTimeMandante, @RequestParam int idTimeVisitante, @RequestParam int idJogador, @RequestParam int idTimeGol) {
		ArrayList<Partida> listaPartida = new ArrayList<>();
		Campeonato campeonato = new Campeonato();
		Partida partida = new Partida();
		Gol gol = new Gol();
		Jogador jogador = new Jogador();
		
		try {
			campeonato = campeonatoService.buscarCampeonato(idCampeonato);
			partida.setTimeMandante(timeService.buscarTime(idTimeMandante));
			partida.setTimeVisitante(timeService.buscarTime(idTimeVisitante));
			partida.setCampeonato(campeonato);
			gol.setTimeMandante(partida.getTimeMandante());
			gol.setTimeVisitante(partida.getTimeVisitante());
			gol.setCampeonato(campeonato);
			
			if(gol.getTimeMandante().getId() == idTimeGol) {
				gol.setTimeMandanteGol(true);
				gol.setTimeVisitanteGol(false);
			}
			if(gol.getTimeVisitante().getId() == idTimeGol) {
				gol.setTimeMandanteGol(false);
				gol.setTimeVisitanteGol(true);
			}
			
			jogador.setId(idJogador);
			gol.setJogador(jogador);
			golService.inserirGol(gol);
			campeonatoService.atualizarStatus(partida);
			int vitoria = 0, empate = 0, derrota = 0;
			int golMandanteTotal = 0, golVisitanteTotal = 0;
			listaPartida = campeonatoService.listarPartidas(partida, partida.getTimeMandante().getId());
			Gol golTabela;
			Campeonato campeonatoTabela;
			Time timeMandanteTabela, timeVisitanteTabela;
			ArrayList<Gol> listaGol;
			for(Partida p:listaPartida) {
				golTabela = new Gol();
				listaGol = new ArrayList<>();
				timeMandanteTabela = new Time();
				timeVisitanteTabela = new Time();
				campeonatoTabela = new Campeonato();
				campeonatoTabela.setId(p.getCampeonato().getId());
				golTabela.setCampeonato(campeonatoTabela);
				timeMandanteTabela.setId(p.getTimeMandante().getId());
				timeVisitanteTabela.setId(p.getTimeVisitante().getId());
				golTabela.setTimeMandante(timeMandanteTabela);
				golTabela.setTimeVisitante(timeVisitanteTabela);
				listaGol = golService.listarGols(golTabela);
				int golMandante = 0, golVisitante = 0;
				
				for(Gol g: listaGol) {
					if(g.isTimeMandanteGol()) {
						golMandante = golMandante + 1;
					}
					if(g.isTimeMandanteGol()) {
						golMandante = golMandante + 1;
					}
					if(g.isTimeVisitanteGol()) {
						golMandante = golMandante + 1;
						
					}
				}

				if(golMandante > golVisitante) {
					vitoria = vitoria + 1 ; 
					golMandanteTotal = golMandanteTotal + golMandante;
				} else if(golMandante < golVisitante) {
					derrota = derrota + 1;
					golMandanteTotal = golMandanteTotal - golVisitante;
				} else {
					empate = empate + 1;
				}
				
			}
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Erro";
	}
	
}

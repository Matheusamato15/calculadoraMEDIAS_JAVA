package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Modelo.ModeloMateria;
import Util.UtilRetorno;
import Util.UtilRetornoDado;


public class PersistenciaDAOMateria {
	
	public static final String SERVIDOR = "localhost:5433";
	public static final String BANCO_NOME = "calculadora6";
	public static final String USUARIO_NOME = "postgres";
	public static final String USUARIO_SENHA = "";
	
	private static PersistenciaDAOMateria dao;
	private Connection conexao;
	
	private PersistenciaDAOMateria() {
		inicializarDriverConexao();
		inicializarConexao();
		//criarTabelaBancoDeDados();
		
	}
	
	private void criarTabelaBancoDeDados() {
		
		try {
			 
			Statement stmt = conexao.createStatement();
			 String sql = "CREATE TABLE IF NOT EXISTS materia " 
			 + "(id INTEGER NOT NULL AUTO_INCREMENT, "
			 + " nomeMateria VARCHAR(100), "
			 + " primeiraNota INTEGER, "
			 + " segundaNota INTEGER, "
			 + " restanteNota FLOAT, "
			 + " mediaFinal FLOAT, "
			 + " PRIMARY KEY ( id ))";
			 
			 stmt.executeUpdate(sql);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} 
		 
	}
	
	private void inicializarConexao() {
		try {
			
			conexao = DriverManager.getConnection("jdbc:postgresql://"+SERVIDOR+"/"+BANCO_NOME, 
					USUARIO_NOME, 
					USUARIO_SENHA);
		} catch (Exception e) {
			System.out.println("Erro de conexão!");
			e.printStackTrace();
			System.exit(2);
		}
		
		
	}

	private void inicializarDriverConexao() {
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			
			System.out.println("Falha ao carregar o Driver de conexão do banco de dados!");
			e.printStackTrace();
			System.exit(1);
			
		}
	}
	
	public UtilRetornoDado<ModeloMateria> getmateria(Integer id){// throws ExceptionPersistencia {
		UtilRetornoDado<ModeloMateria> retornoDado = new UtilRetornoDado<>(true);
		
		ModeloMateria ModeloMateria = new ModeloMateria();
		ModeloMateria.setId(id);
		
		UtilRetornoDado<List<ModeloMateria>> listarmateria = this.pesquisarmateria(ModeloMateria);
		retornoDado.setMensagens(listarmateria.getMensagens());
		
		if(listarmateria.isSucesso()) {				
			retornoDado.setDado(listarmateria.getDado().get(0));
		}
		return retornoDado;
	}
	
	public UtilRetornoDado<List<ModeloMateria>> listarmateria(){
		return this.pesquisarmateria(null);
	}
	
	public UtilRetornoDado<List<ModeloMateria>> pesquisarmateria(ModeloMateria materia){// throws ExceptionPersistencia {
		UtilRetornoDado<List<ModeloMateria>> retornoDado = new UtilRetornoDado<>(true);
		String sql = "select id, nomeMateria, primeiraNota, segundaNota, restanteNota, mediaFinal from materia ";
		
		String where = preparaStringDeWhereListar(materia);
		sql += where;

		ModeloMateria ModeloMateria = null;
		try {
			PreparedStatement pst = conexao.prepareStatement(sql);
			
			configurarPreparedStatementListar(materia, pst);
			
			ResultSet rs = pst.executeQuery();
			List<ModeloMateria> listaMaterias = new ArrayList<ModeloMateria>();

			while (rs.next()) {
				ModeloMateria = new ModeloMateria();
				ModeloMateria.setId(rs.getInt("id"));
				ModeloMateria.setNomeMateria(rs.getString("nomeMateria"));
				ModeloMateria.setPrimeiraNota(rs.getString("primeiraNota"));
				ModeloMateria.setSegundaNota(rs.getString("segundaNota"));
				ModeloMateria.setRestanteNota(rs.getString("restanteNota"));
				ModeloMateria.setMediaFinal(rs.getString("mediaFinal"));
				listaMaterias.add(ModeloMateria);
			}
			retornoDado.setDado(listaMaterias);

		} catch (SQLException e) {
			retornoDado.setSucesso(false);
			retornoDado.getMensagens().add(e.getMessage());
		} catch (NullPointerException e) {
			retornoDado.setSucesso(false);
			retornoDado.addMensagem("Falha ao usar a conexão!!");
		}
		return retornoDado;
	}
	
	private void configurarPreparedStatementListar(ModeloMateria materia, PreparedStatement pst) throws SQLException {
		if(materia!=null) {
			int seqSet = 1;
			if(materia.getId()!=null) {
				pst.setInt(seqSet++, materia.getId());
			}
			if(materia.getPrimeiraNota()!=null && !materia.getPrimeiraNota().equals("")) {
				pst.setString(seqSet++, materia.getPrimeiraNota()+"%");
			}
			if(materia.getSegundaNota()!=null && !materia.getSegundaNota().equals("")) {
				pst.setString(seqSet++, materia.getSegundaNota()+"%");
			}
			if(materia.getRestanteNota()!=null && !materia.getRestanteNota().equals("")) {
				pst.setString(seqSet++, materia.getRestanteNota()+"%");
			}
			if(materia.getMediaFinal()!=null && !materia.getMediaFinal().equals("")) {
				pst.setString(seqSet++, materia.getMediaFinal()+"%");
			}
			
		}
	}

	private String preparaStringDeWhereListar(ModeloMateria materia) {
		String where = "";
		if(materia!=null) {
			if(materia.getId()!=null) {
				where +=" where id = ?";
			}
			if(materia.getNomeMateria()!=null && !materia.getNomeMateria().equals("")){
				if(where.equals("")) {
					where = " where nomeMateria like ?";
				}else {
					where +=" and nomeMateria like ?";
				}
			}
			
			if(materia.getPrimeiraNota()!=null && !materia.getPrimeiraNota().equals("")){
				if(where.equals("")) {
					where = " where primeiraNota like ?";
				}else {
					where +=" and primeiraNota like ?";
				}
			}
			
			if(materia.getSegundaNota()!=null && !materia.getSegundaNota().equals("")){
				if(where.equals("")) {
					where = " where segundaNota like ?";
				}else {
					where +=" and segundaNota like ?";
				}
			}
			
			if(materia.getRestanteNota()!=null && !materia.getRestanteNota().equals("")){
				if(where.equals("")) {
					where = " where restanteNota like ?";
				}else {
					where +=" and restanteNota like ?";
				}
			}
			
			if(materia.getMediaFinal()!=null && !materia.getMediaFinal().equals("")){
				if(where.equals("")) {
					where = " where mediaFinal like ?";
				}else {
					where +=" and mediaFinal like ?";
				}
			}

			

		}
		return where;
	}
	
	public UtilRetorno gravarmateria(String acao, String sql, ModeloMateria materia, Map<Integer, Object> parametros) {
		UtilRetorno retorno = new UtilRetorno(true);
		try {
			PreparedStatement pst = conexao.prepareStatement(sql);

			for(Integer key: parametros.keySet()) {
				pst.setObject(key, parametros.get(key));
			}

			pst.executeUpdate();

			pst.close();

		} catch (SQLException e) {
			retorno.setSucesso(false);
			if (e.getMessage().contains("idx_titulo_unico")) {
				retorno.getMensagens().add("Já existe um materia com esse nome!");
			} else {
				retorno.getMensagens().add("Erro ao "+acao+" materia");
			}
			retorno.getMensagens().add(e.getMessage());
			return retorno;
		}
		retorno.getMensagens().add("Ação("+acao+") Realizada com sucesso!");
		return retorno;
	}
	
	public UtilRetorno incluir(ModeloMateria materia) {
		String sql = "insert into materia(nomeMateria,primeiraNota,segundaNota,restanteNota,mediaFinal) values(?,?,?,?,?)";
		String acao = "incluir";
		
		UtilRetornoDado<Map<Integer, Object>> retornoParametros = getParametrosmateria(acao,materia);
		if(!retornoParametros.isSucesso()) {
			return retornoParametros;
		}
		return gravarmateria(acao, sql, materia, retornoParametros.getDado());
	}

	private UtilRetornoDado<Map<Integer, Object>> getParametrosmateria(String acao,ModeloMateria materia) {
		UtilRetornoDado<Map<Integer, Object>> ret = isParametromateriaPreenchido(acao, materia);
		if(!ret.isSucesso()) {return ret;}
		
		Map<Integer, Object> parametros =new HashMap<>();
		
		parametros.put(1, materia.getNomeMateria());
		parametros.put(2, materia.getPrimeiraNota());
		parametros.put(3, materia.getSegundaNota());
		parametros.put(4, materia.getRestanteNota());
		parametros.put(5, materia.getMediaFinal());
		
		ret.setDado(parametros);
		return ret;
	}

	private UtilRetornoDado<Map<Integer, Object>> isParametromateriaPreenchido(String acao, ModeloMateria materia) {
		UtilRetornoDado<Map<Integer, Object>> retorno = new UtilRetornoDado<>(true);
		if (materia == null) {
			retorno.setSucesso(false);
			retorno.addMensagem("Não foi informado objeto materia para "+acao);
			return retorno;
		}
		return retorno;
	}
	
	public UtilRetorno remover(ModeloMateria materia) {
		UtilRetornoDado<Map<Integer, Object>> retorno = isParametromateriaPreenchido("remover", materia);
		if(!retorno.isSucesso()) {return retorno;}
		
		String sql = "delete from materia where id=?";
		
		PreparedStatement pst;
		try {
			pst = conexao.prepareStatement(sql);
			pst.setInt(1,materia.getId());
			
			pst.executeUpdate();
			
			retorno.addMensagem("Ação(remover) realizada com sucesso!!"); 
		} catch (SQLException e) {
			retorno.addMensagem("Erro ao Remover. Erro: "+e.getMessage());
			retorno.setSucesso(false);
		}
		return retorno;
	}
	
	
	public static PersistenciaDAOMateria getInstance() {
		if(dao == null) {
			dao = new PersistenciaDAOMateria();
		}
		return dao;
	}
	
	
}

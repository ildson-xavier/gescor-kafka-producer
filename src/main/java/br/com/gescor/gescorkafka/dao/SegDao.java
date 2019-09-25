package br.com.gescor.gescorkafka.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.gescor.gescorkafka.config.BeanConfig;
import br.com.gescor.gescorkafka.model.Insured;

@Component
public class SegDao {

	@Autowired
	private BeanConfig config;
	
	public List<Insured> buscarSegurados(String path) {

		List<Insured> segurados = new ArrayList<Insured>();
		
		Connection con = config.connection(path);
		
		String sql = "SELECT SegCod, SegNom, CtaDes, SegCgcCpf, SegTelRes, SegCelRes, "
				+ "SegEndRes, SegBaiRes, SegCidRes, SegUfRes, SegNumRes "
				+ " FROM SEG "
				+ "INNER JOIN CTA ON CtaCod = SegPdtCod "
				+ "ORDER BY SegCod ASC";
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Insured s = new Insured();
				s.setCodigo(rs.getInt("SegCod"));
				s.setSegurado(rs.getString("SegNom"));
				s.setCorretor(rs.getString("CtaDes"));
				s.setCpf(rs.getString("SegCgcCpf"));
				s.setTelefone(rs.getString("SegTelRes"));
				s.setCelular(rs.getString("SegCelRes"));
				s.setBairro(rs.getString("SegBaiRes"));
				s.setCidade(rs.getString("SegCidRes"));
				s.setUf(rs.getString("SegUfRes"));
				s.setEndereco(rs.getString("SegEndRes"));
				s.setNumero(rs.getString("SegNumRes"));
				s.setApolice("");
				segurados.add(s);
			}
			
		} catch (SQLException e) {
			System.out.println("Erro ao tentar conectar no banco de dados > "+e.getMessage());
		}
	
		return segurados;
	}
	
	public List<Insured> buscarSeguradosPorId(String path, int id) {
		System.out.println("buscarSeguradosPorId ...");
		List<Insured> segurados = new ArrayList<Insured>();
		
		System.out.println("Estabelecendo conexao ...");
		Connection con = config.connection(path);
		
		String sql ="SELECT SegCod, SegNom, CtaDes, SegCgcCpf, SegTelRes, SegCelRes, "
				+ "SegEndRes, SegBaiRes, SegCidRes, SegUfRes, SegNumRes "
				+ "FROM SEG "
				+ "INNER JOIN CTA ON CtaCod = SegPdtCod "
				+ "WHERE SegCod > ? "
				+ "ORDER BY SegCod ASC";
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Insured s = new Insured();
				s.setCodigo(rs.getInt("SegCod"));
				s.setSegurado(rs.getString("SegNom"));
				s.setCorretor(rs.getString("CtaDes"));
				s.setCpf(rs.getString("SegCgcCpf"));
				s.setTelefone(rs.getString("SegTelRes"));
				s.setCelular(rs.getString("SegCelRes"));
				s.setBairro(rs.getString("SegBaiRes"));
				s.setCidade(rs.getString("SegCidRes"));
				s.setUf(rs.getString("SegUfRes"));
				s.setEndereco(rs.getString("SegEndRes"));
				s.setNumero(rs.getString("SegNumRes"));
				s.setApolice("");
				segurados.add(s);
			}
			
		} catch (SQLException e) {
			System.out.println("Erro ao tentar conectar no banco de dados > "+e.getMessage());
		}
	
		return segurados;
	}

}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Empresa;
import model.Horario;

public class EmpresaDAO {
	
	// INCLUIR EMPRESA
	public void incluir(Empresa empresa) {
		String sqlInsert = "INSERT INTO empresa (rsocial, cnpj, temp, conjunto, horaF, horaA) VALUES (?, ?, ?, ?, ?, ?)";
		
		try(Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			
			stm.setString(1, empresa.getRazaoSocial());
			stm.setString(2, empresa.getCnpj());
			stm.setString(3, empresa.getTemperatura());
			stm.setInt(4, empresa.getConjunto());
			stm.setString(5, empresa.getHoraFuncionamento());
			stm.setString(6, empresa.getHoraArCondicionado());
			stm.execute();
			
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			
			try(PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					empresa.setId(rs.getInt(1));
				}
			} catch(SQLException e) {
				e.printStackTrace();
				System.out.println("Erro ao carregar ID!");
			}
			
			System.out.println("Empresa cadastrada com sucesso!");
			
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Erro ao cadastrar empresa!");
		}
	}
	
	// ATUALIZAR EMPRESA
	public void atualizar(Empresa empresa) {
		String sqlUpdate = "UPDATE empresa SET rsocial=?, cnpj=?, temp=?, conjunto=?, horaF=?, horaA=? WHERE id=?";
		
		if(empresa != null) {
			try(Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
				
				stm.setString(1, empresa.getRazaoSocial());
				stm.setString(2, empresa.getCnpj());
				stm.setString(3, empresa.getTemperatura());
				stm.setInt(4, empresa.getConjunto());
				stm.setString(5, empresa.getHoraFuncionamento());
				stm.setString(6, empresa.getHoraArCondicionado());
				stm.setInt(7, empresa.getId());
				stm.execute();
				
				System.out.println("Empresa atualizada com sucesso!");
				
			} catch(SQLException e) {
				e.printStackTrace();
				System.out.println("Erro ao atualizar empresa!");
			}
		}
	}
	
	// EXCLUIR EMPRESA
	public void excluir(Empresa empresa) {
		String sqlDelete = "DELETE FROM empresa WHERE id=?";
		
		try(Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			
			stm.setInt(1, empresa.getId());
			stm.execute();
			
			System.out.println("Empresa removida com sucesso!");
			
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Erro ao remover empresa!");
		}
	}
	
	// CARREGAR EMPRESA
	public Empresa carregar(int id) {
		String sqlSelect = "SELECT * FROM empresa WHERE id=?";
		
		Empresa empresa = new Empresa();
		empresa.setId(id);
		
		try(Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			
			stm.setInt(1, empresa.getId());
			
			try(ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					empresa.setRazaoSocial(rs.getString("rsocial"));
					empresa.setCnpj(rs.getString("cnpj"));
					empresa.setTemperatura(rs.getString("temp"));
					empresa.setConjunto(rs.getInt("conjunto"));
					
					String[] horaFunc = rs.getString("horaF").split("-");
					empresa.setHoraFuncionamento(new Horario(horaFunc[0], horaFunc[1]));
					
					String[] horaAr = rs.getString("horaA").split("-");
					empresa.setHoraArCondicionado(new Horario(horaAr[0], horaAr[1]));
					
					System.out.println("Empresa carregada com sucesso!");
				}
				
				return empresa;
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Erro ao carregar empresa!");
		}
		
		return null;
	}
	
	// CARREGAR TODAS AS EMPRESAS
	public List<Empresa> carregarTudo() {
		
		String sqlSelect = "SELECT * FROM empresa";
		List<Empresa> empresas = new ArrayList<>(); 
		
		try(Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			
			try(ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					Empresa empresa = new Empresa();
					
					empresa.setId(rs.getInt("id"));
					empresa.setRazaoSocial(rs.getString("rsocial"));
					empresa.setCnpj(rs.getString("cnpj"));
					empresa.setTemperatura(rs.getString("temp"));
					empresa.setConjunto(rs.getInt("conjunto"));
					
					String[] horaFunc = rs.getString("horaF").split("-");
					empresa.setHoraFuncionamento(new Horario(horaFunc[0], horaFunc[1]));
					
					String[] horaAr = rs.getString("horaA").split("-");
					empresa.setHoraArCondicionado(new Horario(horaAr[0], horaAr[1]));
					
					empresas.add(empresa);
				}
				
				System.out.println("Empresas carregadas com sucesso!");
				
				return empresas;
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Erro ao carregar empresas!");
		}
		
		return null;
	}
	
}

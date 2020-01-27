package br.com.rsinet.hub_tdd.utils;

public class MassaDeDados {
	
	public String getUserName() throws Exception {
		return ExcelDadosConfig.getCellData(1, 0);
	}
	

	public String getEmail() throws Exception {
		return ExcelDadosConfig.getCellData(1, 1);
	}

	public String getSenha() throws Exception {
		return ExcelDadosConfig.getCellData(1, 2);
	}

	public String getConfirmarSenha() throws Exception {
		return ExcelDadosConfig.getCellData(1, 3);
	}

	public String getNome() throws Exception {
		return ExcelDadosConfig.getCellData(1, 4);
	}

	public String getSobrenome() throws Exception {
		return ExcelDadosConfig.getCellData(1, 5);
	}

	public String getTelefone() throws Exception {
		return ExcelDadosConfig.getCellData(1, 6);
	}

	public String getPais() throws Exception {
		return ExcelDadosConfig.getCellData(1, 7);
	}

	public String getCidade() throws Exception {
		return ExcelDadosConfig.getCellData(1, 8);
	}

	public String getEndereco() throws Exception {
		return ExcelDadosConfig.getCellData(1, 9);
	}

	public String getEstado() throws Exception {
		return ExcelDadosConfig.getCellData(1, 10);
	}

	public String getCEP() throws Exception {
		return ExcelDadosConfig.getCellData(1, 11);
	}

}

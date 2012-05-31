package com.vejagol.webservices;

import java.util.ArrayList;

import com.avaya.ade.common.utils.crypto.Crypto;
import com.vejagol.controller.CadastroJogo;
import com.vejagol.controller.CadastroMelhorDaSemana;
import com.vejagol.model.Jogo;
import com.vejagol.model.MelhorDaSemana;


public class VejaGolWS {
	
	private static final String CHAVE_VEJAGOL = "VejaGolWS.Authentication.0p9o8i7u";
	private static final String CHAVE_VEJAGOL_IOS = "VejaGolWS.Authentication"; 
	
	public CadastroJogo cadastroJogo = new CadastroJogo();	
	public CadastroMelhorDaSemana cadastroMelhorDaSemana = new CadastroMelhorDaSemana();	
	
	public ArrayList<Jogo> getListaJogos(int de, int ate, String ordem, String filtros, boolean ascending, String chave) {
		
		try {
			if (new String(Crypto.decrypt(chave.getBytes())).equals(VejaGolWS.CHAVE_VEJAGOL)
					|| new String(Crypto.decrypt(chave.getBytes())).equals(VejaGolWS.CHAVE_VEJAGOL_IOS)) {
				ArrayList<Jogo> listaJogos = cadastroJogo.listarJogos(de, ate, ordem, filtros, ascending);
				return listaJogos;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getUltimoMelhorDaSemana(String chave) {
		try {
			if (new String(Crypto.decrypt(chave.getBytes())).equals(VejaGolWS.CHAVE_VEJAGOL)
					|| new String(Crypto.decrypt(chave.getBytes())).equals(VejaGolWS.CHAVE_VEJAGOL_IOS)) {
				ArrayList<MelhorDaSemana> melhoresDasSemanas = cadastroMelhorDaSemana.listarMelhorDaSemana(0, 1, "ano; mes; semana", "", false);
				if (melhoresDasSemanas.size() > 0) {
					MelhorDaSemana melhorDaSemana = melhoresDasSemanas.get(0);
					return melhorDaSemana.getLink();
				}				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<MelhorDaSemana> getListaMelhoresDasSemanas(int de, int ate, String ordem, String filtros, boolean ascending, String chave) {
		try {
			if (new String(Crypto.decrypt(chave.getBytes())).equals(VejaGolWS.CHAVE_VEJAGOL)
					|| new String(Crypto.decrypt(chave.getBytes())).equals(VejaGolWS.CHAVE_VEJAGOL_IOS)) {
				ArrayList<MelhorDaSemana> melhoresDasSemanas = cadastroMelhorDaSemana.listarMelhorDaSemana(de, ate, ordem, filtros, ascending);
				return melhoresDasSemanas;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}

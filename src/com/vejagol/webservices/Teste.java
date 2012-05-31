package com.vejagol.webservices;

import java.util.Calendar;

import com.avaya.ade.common.utils.crypto.Crypto;



public class Teste {

	public static void main(String...args) {
		
		try {
			String s = new String(Crypto.encrypt("VejaGolWS.Authentication.0p9o8i7u".getBytes()));
		} catch (Exception e) {
			e.printStackTrace();
		}
//		CadastroJogo cadJogo = new CadastroJogo();
//		Calendar cal = Calendar.getInstance();
//		cal.set(2011, Calendar.NOVEMBER, 20, 10, 10, 10);
//		Jogo jogo = new Jogo(cal, "Sport", "Parana", 3, 0, "Brasileiro B", "", "http://video.rutube.ru/e7f23063b1bc13a5f16908e7c09ef763");
		
//		cadJogo.adicionar(jogo);
		VejaGolWS vejaGol = new VejaGolWS();
//		ArrayList<Jogo> jogos = vejaGol.getListaJogos(0, 15, "data", "Brasil", false, "xI7B+3va7ghx+PSI6qqISet5Vb2Wi2yxi5/PolNOtdo=");
//		for (Jogo j : jogos) {
//			System.out.println(j.getTimeCasa() + " " + j.getPlacarCasa()  + " X " + j.getPlacarVisitante() + " "+ j.getTimeVisitante());
//		}
		
//		ArrayList<MelhorDaSemana> melhoresDasSemanas = vejaGol.getListaMelhoresDasSemanas(0, 1, "ano", "", false, "xI7B+3va7ghx+PSI6qqISet5Vb2Wi2yxi5/PolNOtdo=");
//		for (MelhorDaSemana m : melhoresDasSemanas) {
//			System.out.println("Mes: " + m.getMes() + " Semana: " + m.getSemana() + " Ano: " + m.getAno());
//		}

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, 23);
		System.out.println(vejaGol.getUltimoMelhorDaSemana("xI7B+3va7ghx+PSI6qqISet5Vb2Wi2yxi5/PolNOtdo="));
		//		try {
//			System.out.println(new String(Crypto.encrypt("VejaGolWS.getListaJogosVejaGol".getBytes())));
//			System.out.println(new String(Crypto.encrypt("VejaGolWS.getMelhoresGolsDaSemana".getBytes())));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}
}

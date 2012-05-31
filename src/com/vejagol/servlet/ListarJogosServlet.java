package com.vejagol.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.vejagol.controller.CadastroJogo;
import com.vejagol.model.Jogo;

/**
 * Servlet implementation class getListaJogos
 */
@WebServlet("/ListarJogosServlet")
public class ListarJogosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CadastroJogo cadastroJogo;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarJogosServlet() {
        super();
        cadastroJogo = new CadastroJogo();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int de = 0;
		int ate = 15;
		String ordem = "data";
		String filtros = "";
		boolean ascending = true;
		
		if (request.getParameter("de") != null) {
			de = new Integer(request.getParameter("de"));
		}
		if (request.getParameter("ate") != null) {
			ate = new Integer(request.getParameter("ate"));
		}
		if (request.getParameter("ordem") != null) {
			ordem = request.getParameter("ordem");
		}
		if (request.getParameter("filtros") != null) {
			filtros = request.getParameter("filtros");
		}
		if (request.getParameter("ascending") != null) {
			ascending = new Boolean(request.getParameter("ascending"));
		}
		ArrayList<Jogo> listaJogos = cadastroJogo.listarJogos(de, 
				ate, 
				ordem, 
				filtros, 
				ascending);
		
		JsonParser jsonParser = new JsonParser();
		JsonArray jsonListaJogos = new JsonArray();
		
		for (Jogo j : listaJogos) {
			jsonListaJogos.add(jsonParser.parse(j.getJSONObject()));
		}
		
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.getWriter().write("{\"result\" : \"OK\", \"listaJogos\" : " + jsonListaJogos + "}");
	}

}

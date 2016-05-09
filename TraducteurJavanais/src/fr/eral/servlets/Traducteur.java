package fr.eral.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eral.javaClasses.FrToJav;
import fr.eral.javaClasses.JavToFr;

/**
 * Servlet de traduction français-javanais
 *
 * @return le texte traduit, ou le message d'erreur, dans l'attribut
 *         "texteTraduit"
 * 
 * @author richard gaming rig
 *
 */
public class Traducteur extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public Traducteur() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		this.getServletContext().getRequestDispatcher("/WEB-INF/traducteur.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String action = req.getParameter("action");
		String texteOrigine = req.getParameter("texteOrigine");
		String retour = null;

		// Français vers javanais
		if ("FrToJav".equals(action)) {
			FrToJav frToJav = new FrToJav();
			retour = frToJav.tradFrToJav(texteOrigine);
		}
		// javanais vers français
		else if ("JavToFr".equals(action)) {
			JavToFr JavToFr = new JavToFr();
			retour = JavToFr.tradJavToFr(texteOrigine);
		}

		req.setAttribute("texteTraduit", retour);

		this.getServletContext().getRequestDispatcher("/WEB-INF/traducteur.jsp").forward(req, resp);
	}

}

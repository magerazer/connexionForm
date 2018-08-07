package com.sdzee.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdzee.beans.Utilisateur;
import com.sdzee.forms.InscriptionForm;

public class Inscription extends HttpServlet {

    public static final String VUE      = "/WEB-INF/inscription.jsp";

    public static final String ATT_USER = "utilisateur";
    public static final String ATT_FORM = "form";

    @Override
    protected void doGet( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {

        this.getServletContext().getRequestDispatcher( VUE ).forward( req, resp );

    }

    @Override
    protected void doPost( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {

        InscriptionForm form = new InscriptionForm();

        Utilisateur utilisateur = form.inscrireUtilisateur( req );

        req.setAttribute( ATT_FORM, form );
        req.setAttribute( ATT_USER, utilisateur );

        this.getServletContext().getRequestDispatcher( VUE ).forward( req, resp );

    }

}

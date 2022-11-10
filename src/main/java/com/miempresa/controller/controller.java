package com.miempresa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class controller {
	
	@GetMapping("/resultados")
	public String resultado(
			@RequestParam(name="inicio") String inicio,
			@RequestParam(name="fin") String fin,
			Model model) {
		int ninicio = Integer.parseInt(inicio);
		int nfinal = Integer.parseInt(fin);
		List<Integer> lista = new ArrayList<Integer>();
		int contador = 0;
	 
		for (int a = ninicio;a<=nfinal;a++) {
			for (int i = a; i >= 1; i--) {
		        if (a % i == 0) {
		        	contador++;	        	
	        	}	
		    }
			if(contador == 2) {
        		lista.add(a);
        	}
			contador = 0;
		}
		model.addAttribute("primos",lista);
		return "resultado";
	}
	
	@GetMapping("/resultados2")
	public String multiplicar(
			@RequestParam(name="num") String num,
			Model model) {
		String check = "checked";
		ArrayList<Integer> lista = new ArrayList<Integer>();
		ArrayList<Integer> multiplicadores = new ArrayList<Integer>();
		int numero = Integer.parseInt(num);
		int mult = 0;
		for(int i = 1;i<=10;i++) {
			mult = i*numero;
			lista.add(mult);
			multiplicadores.add(i);
		}
		model.addAttribute("lista",lista);
		model.addAttribute("num",numero);
		model.addAttribute("multi",multiplicadores);
		model.addAttribute("chec",check);
		return "resultados2";
	}
}

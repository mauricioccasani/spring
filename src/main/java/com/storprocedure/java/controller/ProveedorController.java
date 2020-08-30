package com.storprocedure.java.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.storprocedure.java.entity.Proveedor;
import com.storprocedure.java.service.IProveedorService;

import lombok.Data;

@Controller
@Data
//@RequestMapping("/")
public class ProveedorController {
	@Autowired
	private IProveedorService service;
	
	@GetMapping("/lista")
	public String demo() {
		return"lista";
	}
	@GetMapping(value = "/proveedores/{term}", produces = { "application/json" })
	public @ResponseBody List<Proveedor>cargarProveedor(@PathVariable String term) throws Exception {
		return this.service.findByNombre(term);
	}

	@GetMapping("/")
	public String listar(Proveedor proveedoreBean, Model model) throws Exception {
		List<Proveedor> proveedors;
		try {
			proveedors = this.getService().findByLike(new Proveedor());
			model.addAttribute("proveedors", proveedors);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return "proveedor_listar";
	}

	@PostMapping("/buscar")
	public String buscar(Proveedor proveedor, Model model) throws Exception {
		List<Proveedor> proveedors;
		try {
			proveedors = this.getService().findByLike(proveedor);
			model.addAttribute("proveedors", proveedors);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return "proveedor_listar";
	}

	@ModelAttribute
	public void setGenericos(Model model) {
		Proveedor proveedor = new Proveedor();

		model.addAttribute("search", proveedor);
		// model.addAttribute("vacantes", serviceVacantes.buscarDestacadas());
		// model.addAttribute("categorias", serviceCategorias.buscarTodas());
	}
	

	@GetMapping("/registrar")
	public String nuevo(ModelMap model)   {
		model.put("proveedor", new Proveedor());
		return "registrar";
	}
	@PostMapping(value="/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String userAdd(@Valid @RequestBody Proveedor proveedor, BindingResult result) throws Exception {
		if(result.hasErrors()) {
			return "registrar";
		} else {
			String s=this.getService().save(proveedor);
			return s;
		}
	}
	
	//@RequestMapping(value = "/proveedor/json/serch", produces = "application/json")
	@PostMapping(value="/serch", produces = "application/json" )//consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE
	@ResponseBody
	public Map<String, Object> serch(@RequestParam("term")Proveedor proveedor) throws Exception  {
		Map<String, Object>map=new HashMap<String, Object>();
		String nombre=proveedor.getNombre();

			List<Proveedor>list=this.service.findByLike(proveedor);
			for (int i = 0; i <list.size(); i++) {
				Proveedor proveedor2=list.get(i);
				map.put("nombre"+i,proveedor2.getId()+" "+proveedor2.getNombre());
			}
			System.out.println(map.toString());
	
		return map;
	}
	
	

}

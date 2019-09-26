package br.com.gescor.gescorkafka.service;

import java.lang.reflect.Field;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import br.com.gescor.gescorkafka.dao.SegDao;
import br.com.gescor.gescorkafka.engine.Producer;
import br.com.gescor.gescorkafka.model.Insured;
import br.com.gescor.gescorkafka.model.Parameter;

@Service
public class GescorServiceImpl implements GescorService{
	
	private static final Logger logger = LoggerFactory.getLogger(GescorServiceImpl.class);

	@Autowired
	private Parameter parameter;
	
	@Autowired
	private Producer producer;
	
	@Autowired
	private SegDao dao;
	
	@Override
	public String loadInsured () {
		logger.info("#### loadInsured");
		
		List<Insured> insureds = this.dao.buscarSegurados(parameter.getPathDB());
		
		logger.info("#### Insured >>> " + insureds.size());
		try {
			JSONArray jsonArray = this.criarJsonArray(insureds);
			
			String json = jsonArray.toString();
			
			logger.info("#### Insured >>> " + json);
			
			this.producer.sendMessage(json);
			
			return "OK";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "NOK";
	}
	
	private JSONArray criarJsonArray(List<Insured> insureds) throws Exception  {
		JSONArray array = new JSONArray();

		for (Insured Ins : (ArrayList<Insured>) insureds){
			JSONObject json = new JSONObject();
			Class<Insured> classe = (Class<Insured>) Ins.getClass();

			for (Field atributo : classe.getDeclaredFields()){
				if (atributo.getType() == Integer.class){
					json.put(atributo.getName(), (Integer) atributo.get(Ins));
				} else if (atributo.getType() == String.class){
					json.put(atributo.getName(), (String) atributo.get(Ins));
				} else {
					json.put(atributo.getName(), (Date) atributo.get(Ins));
				}
			}
			array.put(json);
		}
		return array;
	}


	@Override
	public int lastIdConf(String path) {
		Client c = Client.create();
		WebResource wr = c.resource(path);
		int ret = maxId(wr.get(String.class));
		return ret;
	}
	
	private int maxId(String json) {
		JSONArray object = new JSONArray(json);
		JSONObject js = null;
		int retorno = 0;
		if (object.length() > 0) {
			System.out.println(object.length() + " > " + json);
			js = new JSONObject(object.get(0).toString());
			System.out.println(js.get("ultimoId"));
			retorno = Integer.parseInt(js.get("ultimoId").toString());
		}

		return retorno;
	}
	

}

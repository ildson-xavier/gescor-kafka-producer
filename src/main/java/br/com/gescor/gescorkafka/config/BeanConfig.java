package br.com.gescor.gescorkafka.config;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import br.com.gescor.gescorkafka.model.Parameter;

@Component
@Configuration
@ComponentScan(basePackages = { "br.com.gescor.gescorkafka.*" })
@EnableTransactionManagement
@PropertySource({ "classpath:parameters.properties" })
public class BeanConfig {

	@Autowired
	private Environment env;
	
	@Bean
	public Parameter setParameters() {
		Parameter parameter = new Parameter();
		parameter.setPathDB(env.getProperty("DIR_BD"));
		parameter.setUrlAddConf(env.getProperty("URL_ADD_CONF"));
		parameter.setUrlAddSeg(env.getProperty("URL_ADD_SEG"));
		parameter.setUrlConsConf(env.getProperty("URL_CONS_CONF"));
		return parameter;
	}
	
	public Connection connection(String path) {
		Connection con = null;
		File arquivo = new File(path);
		
		if (!arquivo.exists()){
			System.out.println("Nao foi encontrado com arquivo "+ path);
		}
		
		String database = "jdbc:ucanaccess://" + path.trim() +";memory=false";
		
		System.out.println(database);
		
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			con = DriverManager.getConnection(database, "@37N", "@37N");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Erro ao tentar localizar o driver de conex�o > "+e.getMessage());

		} catch (SQLException e) {
			System.out.println("Erro ao tentar estabelecer conex�o > "+e.getMessage());
		}
		
		return con;
	}
}

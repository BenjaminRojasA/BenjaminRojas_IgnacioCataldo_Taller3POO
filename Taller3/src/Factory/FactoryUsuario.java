package Factory;

import Taller3.Usuario;
public class FactoryUsuario {

	public static Usuario crearUsuario(String username,String contraseña, String rol) {
		return new Usuario(username,contraseña,rol);
	}
}

package br.com.gsv.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.gsv.domain.Usuario;
import br.com.gsv.domain.sub.Grupo;
import br.com.projeto.gsv.service.UsuarioService;

public class AppUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		UsuarioService service = new UsuarioService();
		Usuario usuario = service.BuscandoPeloLogin(login);
		
		UsuarioSistema user = null;
		
		if (usuario != null) {
			user = new UsuarioSistema(usuario, getGrupos(usuario));
		} else {
			throw new UsernameNotFoundException("Usuário não encontrado.");
		}
		
		return user;
	}

	private Collection<? extends GrantedAuthority> getGrupos(Usuario usuario) {
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		
		authorities.add(new SimpleGrantedAuthority(usuario.getGrupo().getNome().toUpperCase()));
		
		
		return authorities;
	}

}

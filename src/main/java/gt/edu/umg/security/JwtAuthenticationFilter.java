package gt.edu.umg.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenValidator tokenValidator;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        System.out.println("JwtAuthenticationFilter se está EJECUTANDO");

        // Obtener el token del header Authorization
        String authHeader = request.getHeader("Authorization");

        // Si no hay token o no empieza con "Bearer ", continuar sin autenticar
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            System.out.println("No se encontró token en la petición");
            filterChain.doFilter(request, response);
            return;
        }

        // Extraer el token (quitar "Bearer ")
        String token = authHeader.substring(7);
        System.out.println("Token recibido: " + token.substring(0, Math.min(token.length(), 30)) + "...");

        // Validar el token
        if (tokenValidator.validateToken(token)) {
            String username = tokenValidator.getUsernameFromToken(token);
            System.out.println("Token válido para usuario: " + username);

            // Crear autenticación sin roles (o puedes agregarlos si los extraes del token)
            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(username, null, null);

            // Establecer la autenticación en el contexto de seguridad
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } else {
            System.out.println("Token inválido");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Token inválido");
            return;
        }

        // Continuar con la cadena de filtros
        filterChain.doFilter(request, response);
    }
}
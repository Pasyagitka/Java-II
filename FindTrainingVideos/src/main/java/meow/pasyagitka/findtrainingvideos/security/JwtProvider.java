package meow.pasyagitka.findtrainingvideos.security;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Component
public class JwtProvider {

    @Value("$(jwt.secret)")
    private String jwtSecret;

    //вход которого будет приходить логин пользователя а на выходе будет строка jwt:
    public String generateToken(String login) {
        Date date = Date.from(LocalDate.now().plusDays(15).atStartOfDay(ZoneId.systemDefault()).toInstant());
        return Jwts.builder()
                .setSubject(login) //логин пользователя, чтобы потом его оттуда забрать в фильтре, когда пользователь будет делать запрос.
                .setExpiration(date)//15 дней (по истечении будет выброшено сообщение об ошибке в методе validateToken)
                .signWith(SignatureAlgorithm.HS512, jwtSecret) // принимает на вход алгоритм подписи и кодовое слово, которое потом потребуется для расшифровки.
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
        }
        /*catch (ExpiredJwtException expEx) {
            log.severe("Token expired");
        } catch (UnsupportedJwtException unsEx) {
            log.severe("Unsupported jwt");
        } catch (MalformedJwtException mjEx) {
            log.severe("Malformed jwt");
        } catch (SignatureException sEx) {
            log.severe("Invalid signature");
        } catch (Exception e) {
            log.severe("invalid token");
        }*/
        return false; //false если валидация прошла с ошибкой.
    }

    //получить информацию о логине пользователя
    public String getLoginFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
}

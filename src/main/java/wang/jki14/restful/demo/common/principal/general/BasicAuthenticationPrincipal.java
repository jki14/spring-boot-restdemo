package wang.jki14.restful.demo.common.principal.general;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Base64Utils;

import wang.jki14.restful.demo.common.RestWidget;
import wang.jki14.restful.demo.common.exception.RestException;
import wang.jki14.restful.demo.common.exception.general.Unauthorized;
import wang.jki14.restful.demo.common.principal.Principal;

public class BasicAuthenticationPrincipal extends Principal {

    public BasicAuthenticationPrincipal(JdbcTemplate sql, boolean anonymousAllowed) throws RestException {
        super();
        String authload = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization");
        if (authload != null && authload.startsWith("Basic")) {
            String[] splited = new String(Base64Utils.decodeFromUrlSafeString(authload.substring("Basic".length()).trim())).split(":");
            if (splited.length == 2 && RestWidget.isInt32Nonnegative(splited[0])) {
                Integer candidateId = Integer.parseInt(splited[0]);
                if (!sql.queryForMap("SELECT COUNT(*) FROM `token` WHERE `userId`=? AND `token`=?", candidateId, splited[1]).get("COUNT(*)").equals(Long.valueOf(0))) {
                    this.userId = candidateId;
                } else {
                    throw new Unauthorized();
                }
            }
        }
        if (!anonymousAllowed && this.userId == null) {
            throw new Unauthorized();
        }
    }

}